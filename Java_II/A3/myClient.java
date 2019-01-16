/**
 * A client for ProvidedClass.
 *
 * @author Omar Barazanji (osb0002@auburn.edu)
 * @version 2017-9-25
 */
public class myClient {

    // to convert from nanoseconds to seconds
    private static final double SECONDS = 1_000_000_000d;

    /** Drives execution. */
    public static void main(String[] args) {
        int numRuns = 10;
        int n = 2;
        ProvidedClass myClass = new ProvidedClass(903862963);
        for (int i = 0; i < numRuns; i++) {
            long startTime = System.nanoTime();
            myClass.methodToTime(n);
            long endTime = System.nanoTime();
            double elapsedTime = (endTime - startTime) / SECONDS;
            System.out.println("Problem size = " + n + " "
                + "Elapsed time = " + elapsedTime);
            n = n * 2;
        }
    }
}
