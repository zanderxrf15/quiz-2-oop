package predictive;

import java.util.Scanner;

/**
 * This class runs the Sig2Words implementation using Map-type dictionary.
 */
public class Sigs2WordsMap {
    public static void main(String[] args) {
        // Create a Dictionary type variable with a DictionaryMapImpl instance
        Dictionary dictMap = new DictionaryMapImpl();

        try (Scanner scan = new Scanner(System.in)) {
            // Scan input from the console and convert it to corresponding words
            while (scan.hasNextLine()) {
                String input = scan.next();
                System.out.println(input + ": " + dictMap.signatureToWords(input));
            }
        }
    }
}
