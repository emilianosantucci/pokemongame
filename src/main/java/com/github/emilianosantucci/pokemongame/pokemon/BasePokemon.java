package com.github.emilianosantucci.pokemongame.pokemon;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasePokemon implements Pokemon {
    Integer level;
    Double health;
    PokemonStatus status;
    PokemonType type;
    String name;
    List<PokemonAction> actions;

    public BasePokemon() {
        this.health = 100.0;
        this.type = PokemonType.UNKNOWN;
        this.name = "";
        this.status = PokemonStatus.NORMAL;
        this.actions = new ArrayList<>();
    }
}
