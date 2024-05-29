package predictive;

/**
 * This class represents a pair of a word and its signature.
 * It implements the Comparable interface for custom comparison.
 */
public class WordSig implements Comparable<WordSig> {

    private String words;
    private String signature;

    /**
     * Constructs a WordSig object with the given word and signature.
     *
     * @param words     The word.
     * @param signature The corresponding signature.
     */
    public WordSig(String words, String signature) {
        this.words = words;
        this.signature = signature;
    }

    /**
     * Gets the word.
     *
     * @return The word.
     */
    public String getWords() {
        return words;
    }

    /**
     * Gets the signature.
     *
     * @return The signature.
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Compares two WordSig objects based on their signatures.
     *
     * @param otherWordSig The WordSig object to compare with.
     * @return -1 if this signature is less, 1 if greater, 0 if equal.
     */
    @Override
    public int compareTo(WordSig otherWordSig) {
        String otherSignature = otherWordSig.getSignature();

        // Compare signatures character by character
        for (int i = 0; i < signature.length() && i < otherSignature.length(); i++) {
            if (signature.charAt(i) > otherSignature.charAt(i)) {
                return 1;
            } 
            else if (signature.charAt(i) < otherSignature.charAt(i)) {
                return -1;
            }
        }

        // If signatures have different lengths, return the difference
        return Integer.compare(signature.length(), otherSignature.length());
    }
}
