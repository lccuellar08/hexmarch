package hexmarch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;
import java.util.List;

public class Orb {
   // String orb_file = "src/hexmarch/orb.txt";
    String orb_file = "hexmarch/orb.txt";

    public void summon() throws IOException, InterruptedException {
        Stream<String> lines = Files.lines(Paths.get(this.orb_file));
        List<String> linesList = lines.toList();
        int lineLength = linesList.size();
        int line_num = 0;
        int orb_size = 47;

        for (String line : linesList) {
            line_num += 1;
            System.out.println(line);
            // Thread.sleep(40L);
             System.out.flush();
            if (line_num != lineLength) {
                if (line_num % orb_size == 0) {
                    //Clears Screen in java
                    Thread.sleep(40L);
                    try {
                        if (System.getProperty("os.name").contains("Windows"))
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        else
                            Runtime.getRuntime().exec("clear");
                    } catch (IOException | InterruptedException ex) {
                    }
                }
            }
        }
        // TODO : save final orb frame to be able to keep it on the screen for dialogue

        System.out.println("\n\nThe orb awakens. ");
        // Print out prompts from Orb
        Map<Integer, String> orbOptions = new TreeMap(Map.of(
                1, "Acquire your desires",
                2, "Assess your chances",
                3, "Compliment the orb",
                4, "Insult the orb",
                5, "Exit"
        ));



        int selected = Utility.printMenu(orbOptions);
        switch(selected) {
            case 1:
                acquireDesires();
                break;
            case 2:
                assessChances();
                break;
            case 3:
                giveCompliment();
                break;
            case 4:
                giveInsult();
                break;
            default:
                // Exit
        }
    }

    private void acquireDesires(){
        /*
            TODO [idea]: prompt user for a term, find an image for it from a search engine,
            then email them that image....
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell the orb in one word what it is that you desire: ");
        String desire_input = scanner.nextLine();
        String cap = desire_input.substring(0, 1).toUpperCase();
        String user_desire = cap + desire_input.substring(1);
        // TEMP OUTPUT:
        System.out.println(">>"+user_desire+"... this is what human desires? Interesting.<<<");
    }

    private void assessChances(){

    }

    private void giveCompliment(){

    }

    private void giveInsult(){

    }
}
