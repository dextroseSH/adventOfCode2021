import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {
    public static List<String> getLines(Class clazz, String input){
        InputStream is = clazz.getResourceAsStream(input);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        return bufferedReader.lines().collect(Collectors.toList());
    }
}
