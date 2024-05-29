package predictive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Efficiently implements dictionary and word-signature manipulations.
 */
public class DictionaryListImpl {
    // Stores the word-signature pairs
    public static List<WordSig> myList = new ArrayList<>();

    // Class constructor
    DictionaryListImpl() {
        // Try to open the file and store valid words in stringList
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\ITS 2022\\campus life\\sophomore\\TUGAS\\semester 3\\OOP\\quiz2\\src\\predictive\\words"))) {
            String currentLine;
            List<String> stringList = new ArrayList<>();

            // Read all words from the file
            while ((currentLine = br.readLine()) != null) {
                if (isValidWord(currentLine)) {
                    stringList.add(currentLine.toLowerCase());
                }
            }

            // Add WordSig objects to myList
            for (String s : stringList) {
                String signature = wordToSignature(s);
                myList.add(new WordSig(s, signature));
            }

            // Sort the list for binary search
            Collections.sort(myList);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Converts a word to its signature.
     *
     * @param word A word to be converted.
     * @return The signature corresponding to the input word.
     */
    public static String wordToSignature(String word) {
        // Implementation similar to wordToSignature in PredictivePrototype
        StringBuilder signature = new StringBuilder();
        for (char current : word.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(current)) {
                signature.append((char) ((current - 'a') / 3 + '2'));
            } 
            else {
                signature.append(' ');
            }
        }
        return signature.toString();
    }

    /**
     * Converts a signature to the corresponding set of words.
     *
     * @param signature The input signature.
     * @return A set of words corresponding to the input signature.
     */
    public static Set<String> signatureToWords(String signature) {
        Set<String> result = new TreeSet<>();

        // Binary search to find the index of the first matching signature
        int indexFinder = Collections.binarySearch(myList, new WordSig(null, signature));

        // Check if the word is available or not
        if (indexFinder >= 0) {
            result.add(myList.get(indexFinder).getWords());
            // Check to the incremented index for words with the same signature
            int upperIndex = indexFinder + 1;
            while (upperIndex < myList.size() && myList.get(upperIndex).getSignature().equals(signature)) {
                result.add(myList.get(upperIndex).getWords());
                upperIndex++;
            }
            // Check to the decremented index for words with the same signature
            int lowerIndex = indexFinder - 1;
            while (lowerIndex >= 0 && myList.get(lowerIndex).getSignature().equals(signature)) {
                result.add(myList.get(lowerIndex).getWords());
                lowerIndex--;
            }
        } 
        else {
            System.out.println("Words unavailable");
        }
        return result;
    }

    /**
     * Checks if a word is alphabetic.
     *
     * @param word A word to be checked for validity.
     * @return True if the word is valid (alphabetic), false otherwise.
     */
    private static boolean isValidWord(String word) {
        return word.chars().allMatch(Character::isAlphabetic);
    }
}

