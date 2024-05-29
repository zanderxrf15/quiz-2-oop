package predictive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import wordTree.MainNode;
import wordTree.WordNotFoundException;

/**
 * Stores a dictionary with a Tree-type implementation.
 */
public class DictionaryTreeImpl implements Dictionary {
    private final MainNode tree = new MainNode(); // Instance of tree with 8 children
    private final String filePath; // File path variable

    // Class Constructor
    public DictionaryTreeImpl(String path) {
        filePath = path;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.lines()
                    .filter(this::isValidWord)
                    .map(String::toLowerCase)
                    .forEach(tree::insertWord);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String wordToSignature(String word) {
        return word.toLowerCase().chars()
                .mapToObj(c -> Character.isAlphabetic(c) ? (char) ((c - 'a') / 3 + '2') : ' ')
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    @Override
    public Set<String> signatureToWords(String signature) {
        try {
            return new TreeSet<>(tree.getWordsFromSig(signature));
        } 
        catch (WordNotFoundException e) {
            System.out.println("Word not in the dictionary");
            return new TreeSet<>();
        }
    }

    // Method to check whether the input word is alphabetic
    private boolean isValidWord(String word) {
        return word.chars().allMatch(Character::isAlphabetic);
    }
}

