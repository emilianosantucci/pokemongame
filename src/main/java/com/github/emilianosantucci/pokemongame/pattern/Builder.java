package com.github.emilianosantucci.pokemongame.pattern;

public interface Builder<T> {
    T build() throws BuildException;
}
