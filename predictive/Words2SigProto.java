package predictive;

import java.util.Scanner;

/**
 * This class is a command-line program to test the wordToSignature method in PredictivePrototype.
 */
public class Words2SigProto {
    public static void main(String[] args) {
        // Scan input from the console and convert it to signatures
        try (Scanner scan = new Scanner(System.in)) {
            while (scan.hasNextLine()) {
                String input = scan.next();
                // Print the input word along with its corresponding signature
                System.out.println(input + ": " + PredictivePrototype.wordToSignature(input));
            }
        }
    }
}
