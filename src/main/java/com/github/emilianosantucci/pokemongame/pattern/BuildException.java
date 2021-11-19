package com.github.emilianosantucci.pokemongame.pattern;

public class BuildException extends Exception {
    public BuildException(Exception e) {
        super(e);
    }

    public BuildException(String message, Exception e) {
        super(message, e);
    }

    public BuildException(String message) {
        super(message);
    }
}
