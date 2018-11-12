package com.flyingfish.exception;

public class AccountExistsException extends BaseException {
    public AccountExistsException(String message, int errorCode) {
        super(message, errorCode);
    }

    public AccountExistsException(String message, Throwable cause, int errorCode) {
        super(message, cause, errorCode);
    }

    public AccountExistsException(Throwable cause, int errorCode) {
        super(cause, errorCode);
    }

    public AccountExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int errorCode) {
        super(message, cause, enableSuppression, writableStackTrace, errorCode);
    }
}
