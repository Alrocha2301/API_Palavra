package com.gft.palavra.exceptions;

public class PalavraException extends RuntimeException{

    private String message;

    public PalavraException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
