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
    boolean didSacrifice = false;

    public void summon() throws IOException, InterruptedException {
        Utility.printAnimation(this.orb_file, 16, false);
        // TODO : save final orb frame to be able to keep it on the screen for dialogue

        System.out.println("\n\nThe orb awakens. ");
        // Print out prompts from Orb
        Map<Integer, String> orbOptions = new TreeMap(Map.of(
                1, "Acquire your desires",
                2, "Offer a sacrifice",
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
                offerSacrifice();
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

    private void offerSacrifice(){
        // If user has a pet, this pet will get sacrificed by orb -- this restores Satisfaction Status to full
        // TODO: how to know if pet was created? .pet file exists ?
    }

    private void giveCompliment(){
        // If you sacrificed pet, orb gives it back
        System.out.println("You tell the orb that you admire its unwavering wit and tenacity.");
        System.out.println("The orb contemplates your words. ");
        if (didSacrifice){
            System.out.println("Its metaphorical heart softens, and it returns your beloved pet back to you.");
            // TODO: get pet's name somehow and insert into above statement dynamically ?
            /*
                Create petHandler obj, call readDryRubi(), then petHandler.dryRubi.getName();
             */
        }
        // TODO [idea] : should I keep a tally for how happy orb is (based on compliments/insults)?

    }

    private void giveInsult(){
        // Sacrifice pet after certain amount of Satisfaction Status? (see above func) ?
    }
}
