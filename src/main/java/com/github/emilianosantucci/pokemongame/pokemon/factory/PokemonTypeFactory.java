package com.github.emilianosantucci.pokemongame.pokemon.factory;

import com.github.emilianosantucci.pokemongame.pattern.Factory;
import com.github.emilianosantucci.pokemongame.pokemon.PokemonType;
import com.github.emilianosantucci.pokemongame.pokemon.strategy.PokemonTypeStrategy;
import com.github.emilianosantucci.pokemongame.pokemon.strategy.WaterPokemonTypeStrategy;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PokemonTypeFactory implements Factory<PokemonTypeStrategy, PokemonType> {
    private final Map<PokemonType, PokemonTypeStrategy> strategies;

    public static PokemonTypeFactory newInstance() {
        return new PokemonTypeFactory();
    }

    protected PokemonTypeFactory() {
        strategies = new HashMap<>();
        strategies.put(PokemonType.WATER, new WaterPokemonTypeStrategy());
    }

    public PokemonTypeStrategy get(PokemonType type) throws MissingStrategyException {
        PokemonTypeStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new MissingStrategyException();
        }

        return strategy;
    }

}
