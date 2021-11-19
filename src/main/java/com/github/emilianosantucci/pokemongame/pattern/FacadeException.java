package com.github.emilianosantucci.pokemongame.pattern;

public class FacadeException extends Exception {
    public FacadeException(Exception e) {
        super(e);
    }

    public FacadeException(String message, Exception e) {
        super(message, e);
    }

    public FacadeException(String message) {
        super(message);
    }
}
