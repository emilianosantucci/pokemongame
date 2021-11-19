package com.github.emilianosantucci.pokemongame.pokemon;

import com.github.emilianosantucci.pokemongame.pattern.BuildException;
import com.github.emilianosantucci.pokemongame.pattern.Facade;
import com.github.emilianosantucci.pokemongame.pattern.FacadeException;
import com.github.emilianosantucci.pokemongame.pokemon.builder.PokemonBuilder;
import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PokemonService implements Facade<Pokemon> {
    final List<Pokemon> pokemons;

    public PokemonService() throws FacadeException {
        try {
            pokemons = this.fakeData();
        } catch (BuildException e) {
            throw new FacadeException("Failed to get fake data", e);
        }
    }

    public List<Pokemon> getAll() {
        return pokemons;
    }

    private List<Pokemon> fakeData() throws BuildException {
        List<Pokemon> fakeList = new ArrayList<>();
        PokemonBuilder builder;

        Faker faker = new Faker(new Random(new Date().getTime()));

        for (int i = 0; i < 10; i++) {
            builder = new PokemonBuilder();
            builder.setName(faker.name().fullName());
            builder.setType(PokemonType.values()[faker.random().nextInt(PokemonType.values().length)]);
            fakeList.add(builder.build());
        }

        return fakeList;
    }
}
