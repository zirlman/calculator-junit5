package org.unibl.etf.exceptions;

public class NotSupportedOperationException extends Exception {

    public NotSupportedOperationException() {
    }

    public NotSupportedOperationException(String message) {
        super(message);
    }

    public NotSupportedOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportedOperationException(Throwable cause) {
        super(cause);
    }

    public NotSupportedOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
