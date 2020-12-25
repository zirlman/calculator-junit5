package org.unibl.etf.exceptions;

/**
 * Exception thrown when the divident is zero
 *
 * @author Dragan Zrilic
 * @version 1.0.0
 */
public class DivisionByZeroException extends  Exception{

    /**
     * Default constructor.
     */
    public DivisionByZeroException() {
    }

    /**
     * Constructor from a string.
     *
     * @param message String value that will be incorporated in the message for this exception.
     */
    public DivisionByZeroException(String message) {
        super(message);
    }
}
