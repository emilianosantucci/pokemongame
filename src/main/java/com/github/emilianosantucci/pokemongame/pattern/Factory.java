package com.github.emilianosantucci.pokemongame.pattern;

public interface Factory<T, K> {
    T get(K key) throws FactoryException;
}
