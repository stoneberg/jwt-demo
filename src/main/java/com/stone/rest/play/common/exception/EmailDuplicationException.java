package com.stone.rest.play.common.exception;

public class EmailDuplicationException extends Exception {

    private static final long serialVersionUID = 5629182988557873754L;

    public EmailDuplicationException(String message) {
        super(message);
    }
}
