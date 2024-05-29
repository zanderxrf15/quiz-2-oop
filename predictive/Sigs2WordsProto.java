package predictive;

import java.util.Scanner;

/**
 * This class is a command-line program to test the signatureToWords method in PredictivePrototype.
 */
public class Sigs2WordsProto {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            // Scan input from the console and convert it to corresponding words
            while (scan.hasNextLine()) {
                String input = scan.next();
                System.out.println(input + ": " + PredictivePrototype.signatureToWords(input));
            }
        }
    }
}

