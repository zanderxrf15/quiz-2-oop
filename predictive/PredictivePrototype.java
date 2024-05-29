package predictive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * PredictivePrototype Class
 * This class stores methods for words and signature manipulation.
 */
public class PredictivePrototype {

    /**
     * Converts a word to a signature.
     *
     * @param word A word to be converted.
     * @return A string of signature numbers representing the word.
     */
    public static String wordToSignature(String word) {
        StringBuilder signature = new StringBuilder();

        // Convert each character to its corresponding signature number
        for (char current : word.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(current)) {
                signature.append(getSignatureNumber(current));
            } 
            else {
                signature.append(' ');
            }
        }

        return signature.toString();
    }

    /**
     * Converts a signature to corresponding words in the dictionary.
     *
     * @param signature The signature to be processed.
     * @return A set of words with the given signature.
     */
    public static Set<String> signatureToWords(String signature) {
        Set<String> result = new TreeSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("D:\\ITS 2022\\campus life\\sophomore\\TUGAS\\semester 3\\OOP\\quiz2\\words"))) {
            br.lines()
                    .filter(PredictivePrototype::isValidWord)
                    .map(String::toLowerCase)
                    .filter(s -> wordToSignature(s).equals(signature))
                    .forEach(result::add);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Checks whether a word is alphabetic.
     *
     * @param word The word to be checked.
     * @return True if the word is alphabetic, false otherwise.
     */
    private static boolean isValidWord(String word) {
        return word.chars().allMatch(Character::isAlphabetic);
    }

    /**
     * Gets the signature number for a given character.
     *
     * @param character The character for which to get the signature number.
     * @return The signature number.
     */
    private static char getSignatureNumber(char character) {
        switch (character) {
            case 'a', 'b', 'c' -> { return '2'; }
            case 'd', 'e', 'f' -> { return '3'; }
            case 'g', 'h', 'i' -> { return '4'; }
            case 'j', 'k', 'l' -> { return '5'; }
            case 'm', 'n', 'o' -> { return '6'; }
            case 'p', 'q', 'r', 's' -> { return '7'; }
            case 't', 'u', 'v' -> { return '8'; }
            case 'w', 'x', 'y', 'z' -> { return '9'; }
            default -> { return ' '; }
        }
    }
}


