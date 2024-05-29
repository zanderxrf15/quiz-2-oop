package wordTree;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MainNode {
    // Array to store child nodes of the tree
    private MainNode[] children = new MainNode[8];
    
    // Depth of the current node in the tree
    private final int nodeDepth;
    
    // Set to store words associated with the current node
    private Set<String> words = new HashSet<>();

    // Default constructor for the root node
    public MainNode() {
        this.nodeDepth = 0;
    }

    // Special constructor for internal nodes, with specified depth
    protected MainNode(int nodeDepth) {
        this.nodeDepth = nodeDepth;
    }

    // Method to trim a word based on the node depth
    private String trimWord(String word) {
        return word.substring(0, nodeDepth);
    }

    // Method to insert a word into the tree
    public void insertWord(String word) {
        // If not the root, add the trimmed word to the node's word set
        if (this.nodeDepth != 0) {
            words.add(trimWord(word));
        }

        // If the word is longer than the current node's depth, insert recursively
        if (word.length() > nodeDepth) {
            int charValue = numberToLetters(word.charAt(nodeDepth)) - 2;
            // If the child node is null, create a new one
            if (children[charValue] == null) {
                children[charValue] = new MainNode(nodeDepth + 1);
            }
            // Recursive call to insertWord for the child node
            children[charValue].insertWord(word);
        }
    }

    // Method to retrieve words corresponding to a given signature
    public Collection<String> getWordsFromSig(String sig) throws WordNotFoundException {
        // Base case: if the signature is empty, return the words at this node
        if (sig.isEmpty()) {
            return words;
        } 
        else {
            // Get the child number based on the first character of the signature
            int childNumber = Character.getNumericValue(sig.charAt(0)) - 2;
            // If the child node exists, recursively call getWordsFromSig
            if (children[childNumber] != null) {
                return children[childNumber].getWordsFromSig(sig.substring(1));
            } 
            else {
                // If the child node is null, throw an exception
                throw new WordNotFoundException("Your word was not in the dictionary");
            }
        }
    }

    // Method to retrieve all words stored at this node
    public Collection<String> getWords() {
        return words;
    }

    // Method to get the child node at a specified index
    public MainNode getChild(int i) {
        return children[i];
    }

    // Helper method to convert a character to a numerical value
    public int numberToLetters(char x) {
        char current = Character.toLowerCase(x);
        switch (current) {
            case 'a': case 'b': case 'c': return 2;
            case 'd': case 'e': case 'f': return 3;
            case 'g': case 'h': case 'i': return 4;
            case 'j': case 'k': case 'l': return 5;
            case 'm': case 'n': case 'o': return 6;
            case 'p': case 'q': case 'r': case 's': return 7;
            case 't': case 'u': case 'v': return 8;
            case 'w': case 'x': case 'y': case 'z': return 9;
            default: return 0;
        }
    }

    // Helper method to convert a numerical value to a string of letters
    public String numberToLetters(int x) {
        switch (x) {
            case 2: return "abc";
            case 3: return "def";
            case 4: return "ghi";
            case 5: return "jkl";
            case 6: return "mno";
            case 7: return "pqrs";
            case 8: return "tuv";
            case 9: return "wxyz";
            default: return "";
        }
    }
}


