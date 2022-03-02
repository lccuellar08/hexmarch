package hexmarch;

import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        printSplash("src/hexmarch/splash.txt");

        Map<Integer, String> menuOptions = Map.of(
                1, "Iryna's Option",
                2, "Option 2",
                3, "Exit"
        );

        int selected = printMenu(menuOptions);
        switch(selected) {
            case 1:
                irynaFunction();
            default:
                // Do nothing
        }
    }

    private static void irynaFunction() {
        System.out.println("Iryna Function");
    }

    private static int printMenu(Map<Integer, String> options)  {

        Scanner scanner = new Scanner(System.in);
        int selectedOption = -1;

        do {
            System.out.println("Enter one of the following:");
            for(Map.Entry<Integer, String> entry: options.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            String line = scanner.nextLine();
            try {
                selectedOption = Integer.parseInt(line);

                // Selected valid option, break out of the while loop
                if(options.containsKey(selectedOption))
                    break;
                // Selected an option that doesn't exist, loop and try again
                else
                    System.out.println("Please enter a valid number from one of the given choices\n");
            } catch (NumberFormatException e) {
                // Entered an option that's not an integer
                System.out.println("Please enter a valid number\n");
            }
        } while(true);

        return selectedOption;
    }

    private static void printSplash(String filename) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(filename));
        lines.forEach(System.out::println);
    }

    private static void printDelayedText(String text, long delay) throws InterruptedException {
        for(char ch: text.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(delay);
            System.out.flush();
        }
        System.out.println();
    }
}
