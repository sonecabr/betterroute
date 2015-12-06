package com.soneca.wmtest.api.exception;

/**
 * Exception for business
 * @author andre
 * @since 06/12/2015 13:39
 */
public class WmBusinessException extends Exception {

    public WmBusinessException() {
    }

    public WmBusinessException(String message) {
        super(message);
    }

    public WmBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public WmBusinessException(Throwable cause) {
        super(cause);
    }

    public WmBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
