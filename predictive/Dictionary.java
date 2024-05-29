package predictive;

import java.util.Set;

/**
 * Interface for word and signature manipulation.
 */
public interface Dictionary {
    // Constant for the dictionary path (unused in this version)
    String DICTIONARY_PATH = "D:\\ITS 2022\\campus life\\sophomore\\TUGAS\\semester 3\\OOP\\quiz2\\src\\predictive\\words";

    /**
     * Converts a word to its signature.
     *
     * @param word The input word.
     * @return The signature corresponding to the input word.
     */
    String wordToSignature(String word);

    /**
     * Converts a signature to a set of words.
     *
     * @param signature The input signature.
     * @return A set of words corresponding to the input signature.
     */
    Set<String> signatureToWords(String signature);
}
