import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex3 {
    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    private static void partOne() {
        List<List<Integer>> input = parse();
        int binaryLength = input.get(0).size();
        int numberOfSignals = input.size();

        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for (int i = 0; i < binaryLength; i++) {
            int finalI = i;
            int numberOfOne = input.stream().mapToInt(l -> l.get(finalI)).sum();
            if(numberOfOne > numberOfSignals / 2){
                gamma.append("1");
                epsilon.append("0");
            }else{
                gamma.append("0");
                epsilon.append("1");
            }
        }
        System.out.println("Output Task 1: " +
                Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2));
    }

    private static List<List<Integer>> parse() {
        List<String> strings = InputReader.getLines(Ex3.class, "input3");
        List<List<String>> collect = strings.stream().map(s -> Arrays.stream(s.split("")).toList()).collect(Collectors.toList());
        return collect.stream().map(l -> l.stream().map(Integer::parseInt).collect(Collectors.toList())).collect(Collectors.toList());
    }

    private static void partTwo() {
        List<List<Integer>> input = parse();
        int binaryLength = input.get(0).size();

        for (int i = 0; i < binaryLength; i++) {
            int numberOfSignals = input.size();
            if(numberOfSignals == 1){
                break;
            }

            int finalI = i;
            int numberOfOne = input.stream().mapToInt(l -> l.get(finalI)).sum();
            if(numberOfOne >= numberOfSignals - numberOfOne){
                input = input.stream().filter(b -> b.get(finalI) == 1).collect(Collectors.toList());
            }else{
                input = input.stream().filter(b -> b.get(finalI) == 0).collect(Collectors.toList());
            }
        }

        int oxygen = Integer.parseInt(input.get(0).stream().map(String::valueOf).collect(Collectors.joining("")),2);

        input = parse();
        binaryLength = input.get(0).size();

        for (int i = 0; i < binaryLength; i++) {
            int numberOfSignals = input.size();
            if(numberOfSignals == 1){
                break;
            }

            int finalI = i;
            int numberOfOne = input.stream().mapToInt(l -> l.get(finalI)).sum();
            if(numberOfOne >= numberOfSignals - numberOfOne){
                input = input.stream().filter(b -> b.get(finalI) == 0).collect(Collectors.toList());
            }else{
                input = input.stream().filter(b -> b.get(finalI) == 1).collect(Collectors.toList());
            }
        }

        int coTwo = Integer.parseInt(input.get(0).stream().map(String::valueOf).collect(Collectors.joining("")),2);
        System.out.println("Output Task 2: Oxygen " + oxygen + " co2 " + coTwo + " product " + oxygen * coTwo);
    }


}
