package com.github.emilianosantucci.pokemongame.pokemon.strategy;

import com.github.emilianosantucci.pokemongame.pokemon.PokemonType;
import com.github.emilianosantucci.pokemongame.pokemon.PokemonAction;

import java.util.List;

public class WaterPokemonTypeStrategy extends AbstractPokemonTypeStrategy {
    @Override
    PokemonType allowType() {
        return PokemonType.WATER;
    }

    @Override
    Double multipliedHealth(Double health) {
        return health * 1.10;
    }

    @Override
    List<PokemonAction> addActions() {
        return null;
    }
}
