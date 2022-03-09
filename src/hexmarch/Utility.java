package hexmarch;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Stream;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

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
            System.out.println("file length: "+ String.valueOf(lineLength));

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

    public static void SendEmail() {
        // TODO: create email account for this; using personal for now
        System.out.println("In SendMail function");

        String to = "irynamotyashok@gmail.com";

        // This will be user input
        String from = "hexmarzo@gmail.com";

        // Assuming you are sending email from localhost
        String host = "smtp.gmail.com"; //"localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);
//
//        try {
//            // Create a default MimeMessage object.
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From: header field of the header.
//            message.setFrom(new InternetAddress(from));
//
//            // Set To: header field of the header.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            // Set Subject: header field
//            message.setSubject("This is the Subject Line!");
//
//            // Now set the actual message
//            message.setText("This is actual message");
//
//            // Send message
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
    }
}
