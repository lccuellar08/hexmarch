package hexmarch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.List;

public class Orb {
    String orb_file = "src/hexmarch/orb.txt";
   // String orb_file = "hexmarch/orb.txt";

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
    }
}
