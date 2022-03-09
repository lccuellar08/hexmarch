package hexmarch;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Desires {
    public static void AcquireDesires(String search) {
        try {
            String urlString = "https://serpapi.com/search.json?q="+search+"&tbm=isch&ijn=0&api_key=8c5a5cf3bc400ddaf9e0a5c09725eb72eba7b69498a42f50e0d89bb2ddc9f7fe";
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String read;
            while ((read=br.readLine()) != null) {
                System.out.println(read);
            }
            br.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
