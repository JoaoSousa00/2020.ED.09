package Exceptions;

/**
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 * Exception that
 * </p>
 */
public class EmptyCollectionException extends Exception {

    /**
     * Creates a new instance of <code>EmptyCollectionException</code> without detail message.
     */
    public EmptyCollectionException() {
    }

    /**
     * Constructs an instance of <code>EmptyCollectionException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EmptyCollectionException(String msg) {
        super(msg);
    }
}
