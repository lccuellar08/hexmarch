package hexmarch;

import jdk.jshell.execution.Util;

import java.util.Map;
import java.io.IOException;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
      //  printSplash("src/hexmarch/splash.txt");
        Utility.printSplash("hexmarch/splash.txt");

        Utility util = new Utility();
        util.setTextDelay(300L);

        Map<Integer, String> menuOptions = new TreeMap(Map.of(
                1, "Consult the Orb",
                2, "Manage Pet",
                3, "[dev] Run Tests",
                4, "Exit"
        ));

        int selected;

        do {
            selected = Utility.printMenu(menuOptions);
            switch(selected) {
                case 1:
                    summonOrb();
                    break;
                case 2:
                    managePet();
                    break;
                case 3:
                    runTests();
                    break;
                default:
                    // Do nothing
            }
        } while(!menuOptions.get(selected).equals("Exit"));

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

        int selected = Utility.printMenu(petOptions);
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

        petHandler.handlePet();
        petHandler.saveDryRubi();
    }

    private static void runTests(){
        // Test 1: sending an email
        System.out.println("\n>>> Running test 1: sending an email");
        Utility.SendEmail();
        System.out.println();

        //
    }
}
