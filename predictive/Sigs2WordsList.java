package predictive;

import java.util.Scanner;

/**
 * This class runs the Sig2Words implementation using List-type dictionary.
 */
public class Sigs2WordsList {
    public static void main(String[] args) {
        // Create DictionaryListImpl instance to populate the dictionary data from its constructor
        DictionaryListImpl dict = new DictionaryListImpl();

        try (Scanner scan = new Scanner(System.in)) {
            // Scan input from the console and convert it to corresponding words
            while (scan.hasNextLine()) {
                String input = scan.next();
                System.out.println(input + ": " + dict.signatureToWords(input));
            }
        }
    }
}
