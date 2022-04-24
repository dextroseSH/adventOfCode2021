import java.util.List;
import java.util.stream.Collectors;

public class Ex2 {
    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    private static void partOne() {
        List<Command> commands = parse();
        int horizontal = 0;
        int depth = 0;
        for(Command c : commands){
            switch (c.command){
                case "forward":
                    horizontal+=c.length;
                    break;
                case "down":
                    depth+=c.length;
                    break;
                case "up":
                    depth-=c.length;
                    break;
            }
        }
        System.out.println("Output part 1: " + horizontal * depth);
    }

    private static void partTwo() {
        List<Command> commands = parse();
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        for(Command c : commands){
            switch (c.command) {
                case "forward" -> {
                    horizontal += c.length;
                    depth += aim * c.length;
                }
                case "down" -> aim += c.length;
                case "up" -> aim -= c.length;
            }
        }
        System.out.println("Output part 2: " + horizontal * depth);
    }

    private static List<Command> parse() {
        List<String> input2 = InputReader.getLines(Ex2.class, "input2");
        return input2.stream().map(c-> new Command(c.split(" "))).collect(Collectors.toList());
    }


    private static class Command {
        String command;
        int length;

        Command(String[] commands){
            command = commands[0];
            length = Integer.parseInt(commands[1]);
        }
    }
}
