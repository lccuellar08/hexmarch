package hexmarch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Utility {
    private static long delay = 40L; // Default delay

    public static void setTextDelay(long _delay){
        delay = _delay;
    }

    public static void printDelayedText(String text) throws InterruptedException {
        for(char ch: text.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(delay);
            System.out.flush();
        }
        System.out.println();
    }

    public static void printSplash(String filename) {
        try {
            Stream<String> lines = Files.lines(Paths.get(filename));
            lines.forEach(System.out::println);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static int printMenu(Map<Integer, String> options)  {

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

    public static void printAnimation(String fileName, int frameSize, boolean clearAtEnd) {
        try {
            Stream<String> lines = Files.lines(Paths.get(fileName));
            List<String> linesList = lines.toList();
            int lineLength = linesList.size();
            int line_num = 0;

            for (String line : linesList) {
                line_num += 1;
                System.out.println(line);
                // Thread.sleep(40L);
                System.out.flush();
                if (line_num != lineLength || clearAtEnd) {
                    if (line_num % frameSize == 0) {
                        //Clears Screen in java
                        Thread.sleep(40L);
                        if (System.getProperty("os.name").contains("Windows"))
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        else {
                            new ProcessBuilder("clear").inheritIO().start().waitFor();
                        }
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
