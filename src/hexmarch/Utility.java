package hexmarch;

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
}
