package predictive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Efficiently implements dictionary and word-signature manipulations using a HashMap.
 */
public class DictionaryMapImpl implements Dictionary {
    // HashMap to store signatures and corresponding sets of words
    private final Map<String, Set<String>> dictionary = new HashMap<>();

    // Class Constructor
    public DictionaryMapImpl() {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\ITS 2022\\campus life\\sophomore\\TUGAS\\semester 3\\OOP\\quiz2\\src\\predictive\\words"))) {
            String currentLine;
            List<String> stringList = new ArrayList<>();

            // Read all words from the file
            while ((currentLine = br.readLine()) != null) {
                if (isValidWord(currentLine)) {
                    stringList.add(currentLine.toLowerCase());
                }
            }

            // Populate the HashMap with signature-word pairs
            for (String s : stringList) {
                String signature = wordToSignature(s);
                dictionary.computeIfAbsent(signature, k -> new TreeSet<>()).add(s);
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String wordToSignature(String word) {
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

    @Override
    public Set<String> signatureToWords(String signature) {
        return dictionary.getOrDefault(signature, new TreeSet<>());
    }

    // Checks if a word is alphabetic
    private boolean isValidWord(String word) {
        return word.chars().allMatch(Character::isAlphabetic);
    }
}
