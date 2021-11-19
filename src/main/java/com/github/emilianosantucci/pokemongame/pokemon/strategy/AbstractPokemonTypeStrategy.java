package com.github.emilianosantucci.pokemongame.pokemon.strategy;

import com.github.emilianosantucci.pokemongame.pattern.StrategyException;
import com.github.emilianosantucci.pokemongame.pokemon.BasePokemon;
import com.github.emilianosantucci.pokemongame.pokemon.Pokemon;
import com.github.emilianosantucci.pokemongame.pokemon.PokemonType;
import com.github.emilianosantucci.pokemongame.pokemon.PokemonAction;

import java.util.List;

public abstract class AbstractPokemonTypeStrategy implements PokemonTypeStrategy {
    @Override
    public void apply(Pokemon target) throws StrategyException {
        if (target.getType() == allowType()) {
            BasePokemon pokemon = (BasePokemon) target;
            pokemon.setHealth(multipliedHealth(pokemon.getHealth()));
            pokemon.getActions().addAll(addActions());
        } else {
            throw new MismatchTypeException();
        }
    }

    abstract PokemonType allowType();

    abstract Double multipliedHealth(Double health);

    abstract List<PokemonAction> addActions();
}
