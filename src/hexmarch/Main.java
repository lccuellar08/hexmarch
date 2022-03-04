package hexmarch;

import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
      //  printSplash("src/hexmarch/splash.txt");
        Utility.printSplash("hexmarch/splash.txt");

        Utility util = new Utility();
        util.setTextDelay(300L);

        Map<Integer, String> menuOptions = new TreeMap(Map.of(
                1, "Consult the Orb",
                2, "Manage Pet",
                3, "Exit"
        ));

        int selected = printMenu(menuOptions);
        switch(selected) {
            case 1:
                summonOrb();
                break;
            case 2:
                managePet();
                break;
            default:
                // Do nothing
        }
    }

    private static void summonOrb() throws IOException, InterruptedException{
        Orb orb = new Orb();
        orb.summon();
    }

    private static void managePet() {
        PetHandler petHandler = new PetHandler();


        Map<Integer, String> petOptions = new TreeMap(Map.of(
                1, "Create New Pet",
                2, "Manage Current Pet",
                3, "Exit"
        ));

        System.out.println("\n\nWelcome to the Pet Handler!");

        int selected = printMenu(petOptions);
        switch(selected) {
            case 1:
                petHandler.newDryRubi();
                break;
            case 2:
                petHandler.readDryRubi();
                break;
            default:
                // Exit
        }

        petHandler.watchPet();
        petHandler.saveDryRubi();
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

//    private static void printDelayedText(String text, long delay) throws InterruptedException {
//            for(char ch: text.toCharArray()) {
//                System.out.print(ch);
//                Thread.sleep(delay);
//                System.out.flush();
//            }
//            System.out.println();
//    }
}
