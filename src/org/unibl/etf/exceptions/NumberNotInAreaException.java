package org.unibl.etf.exceptions;

public class NumberNotInAreaException extends Exception{

    public NumberNotInAreaException() {
    }

    public NumberNotInAreaException(String message) {
        super(message);
    }

    public NumberNotInAreaException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberNotInAreaException(Throwable cause) {
        super(cause);
    }

    public NumberNotInAreaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
