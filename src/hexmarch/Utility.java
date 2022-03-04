package hexmarch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
}
