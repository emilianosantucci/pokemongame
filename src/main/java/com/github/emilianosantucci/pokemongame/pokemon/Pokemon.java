package com.github.emilianosantucci.pokemongame.pokemon;

import java.util.List;

public interface Pokemon {
    PokemonType getType();
    PokemonStatus getStatus();
    Integer getLevel();
    Double getHealth();
    String getName();
    List<PokemonAction> getActions();
}
