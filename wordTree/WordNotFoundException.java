package wordTree;

/**
 * Exception class for word not found
 */
@SuppressWarnings("serial")
public class WordNotFoundException extends Exception {
    // Constructor with a message
    public WordNotFoundException(String message) {
        // Call the constructor of the superclass (Exception) with the provided message
        super(message);
    }
}
