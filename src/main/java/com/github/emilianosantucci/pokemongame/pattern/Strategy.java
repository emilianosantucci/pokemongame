package com.github.emilianosantucci.pokemongame.pattern;

public interface Strategy<T> {
     void apply(T target) throws StrategyException;
}
