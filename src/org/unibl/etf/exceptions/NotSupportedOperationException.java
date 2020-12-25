package org.unibl.etf.exceptions;

/**
 * Exception thrown when an invalid operation is provided
 *
 * @author Dragan Zrilic
 * @version 1.0.0
 */
public class NotSupportedOperationException extends Exception {

    /**
     * Default constructor.
     */
    public NotSupportedOperationException() {
    }

    /**
     * Constructor from a string.
     *
     * @param message String value that will be incorporated in the message for this exception.
     */
    public NotSupportedOperationException(String message) {
        super(message);
    }
}
