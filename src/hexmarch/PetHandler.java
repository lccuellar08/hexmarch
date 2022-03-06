package hexmarch;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PetHandler {
    DryRubi dryRubi;
    String path = "/Users/lc2377/IdeaProjects/hexmarch/pets/";

    public DryRubi getDryRubi() {
        return dryRubi;
    }

    public void newDryRubi() {
        System.out.println("Enter a name for your pet");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        this.dryRubi = new DryRubi(name);
    }

    public void saveDryRubi() {
        try {
            FileOutputStream fos = new FileOutputStream(new File(path+"DryRubi.pet"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(dryRubi);

            oos.close();
            fos.close();

        } catch(IOException e) {
            System.err.println(e);
        }
    }

    public void readDryRubi() {
        try {
            FileInputStream fi = new FileInputStream(new File(path+"DryRubi.pet"));
            ObjectInputStream ois = new ObjectInputStream(fi);

            this.dryRubi = (DryRubi) ois.readObject();

            ois.close();
            fi.close();

        } catch(IOException | ClassNotFoundException e) {
            System.err.println(e);
        }
    }

    public void handlePet() {
        dryRubi.tick();
        String name = dryRubi.getName();

        Map<Integer, String> handleOptions = new TreeMap(Map.of(
                1, "Feed "+name,
                2, "Play with "+name,
                3, "Exit"
        ));

        int selected;

        do {
            watchPet();
            selected = Utility.printMenu(handleOptions);

            switch(selected) {
                case 1:
                    giveFood();
                    break;
                case 2:
                    playWithPet();
                    break;
                default:
                    break;
            }

            dryRubi.tick();

        } while(!handleOptions.get(selected).equals("Exit"));
    }

    private void giveFood() {
        switch(dryRubi.getCurrentStage()) {
            case EGG:
            case PUPA:
            case MOTH:
                break;
            case CATERPILLAR:
                Utility.printAnimation("hexmarch/CaterpillarEat.txt", 5, true);
                break;
        }
        dryRubi.eatFood();
    }

    private void playWithPet() {
        switch(dryRubi.getCurrentStage()) {
            case EGG:
            case PUPA:
            case MOTH:
                break;
            case CATERPILLAR:
                Utility.printAnimation("hexmarch/CaterpillarPlay.txt", 5, true);
                Utility.printAnimation("hexmarch/CaterpillarPlay.txt", 5, true);
                Utility.printAnimation("hexmarch/CaterpillarPlay.txt", 5, true);
                break;
        }
        dryRubi.play();
    }

    public void watchPet() {
        switch(dryRubi.getCurrentStage()) {
            case EGG:
                Utility.printSplash("hexmarch/Egg.txt");
                break;
            case CATERPILLAR:
                Utility.printSplash("hexmarch/Caterpillar.txt");
                break;
            case PUPA:
                break;
            case MOTH:
                break;
        }

        System.out.println(dryRubi);
    }
}
