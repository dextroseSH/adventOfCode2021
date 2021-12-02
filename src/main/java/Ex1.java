import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex1 {

    public static void main(String[] args) throws IOException {
        partOne();
        partTwo();
    }

    private static void partOne() throws IOException {
        InputStream is = Ex1.class.getResourceAsStream("input1");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        //List<Integer> depth = new LinkedList<>();
        String currentLine;
        Integer lastDepth = null;
        int increaseCounter = 0;

        while((currentLine = bufferedReader.readLine()) != null){
            int currentDepth = Integer.parseInt(currentLine);
            if(lastDepth == null){
                lastDepth = currentDepth;
                continue;
            }
            if (currentDepth > lastDepth) {
                increaseCounter++;
            }
            lastDepth = currentDepth;
        }

        System.out.println("Output part 1: "+ increaseCounter);
    }

    private static void partTwo(){
        InputStream is = Ex1.class.getResourceAsStream("input1");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        List<Integer> depths = bufferedReader.lines().map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> windows = sliding(depths, 3).map(l -> l.stream()
                .mapToInt(Integer::intValue).sum())
                .collect(Collectors.toList());

        int sum = sliding(windows, 2).map(l -> l.get(1) > l.get(0)).mapToInt(b -> b ? 1 : 0).sum();
        System.out.println("Output part 2: "+ sum);
    }

    public static <T> Stream<List<T>> sliding(List<T> list, int size) {
        if(size > list.size())
            return Stream.empty();
        return IntStream.range(0, list.size()-size+1)
                .mapToObj(start -> list.subList(start, start+size));
    }
}
