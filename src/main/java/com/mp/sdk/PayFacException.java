package com.mp.sdk;

public class PayFacException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PayFacException(String message, Exception ex) {

        super(message, ex);
    }

    public PayFacException(String message) {

        super(message);
    }
}
