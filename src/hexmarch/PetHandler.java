package hexmarch;

import java.io.*;
import java.util.Scanner;

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

    public void watchPet() {
        Utility.printSplash("hexmarch/Egg.txt");
        System.out.println(dryRubi);
    }
}
