package com.github.emilianosantucci.pokemongame;

import com.github.emilianosantucci.pokemongame.pattern.FacadeException;
import com.github.emilianosantucci.pokemongame.pokemon.Pokemon;
import com.github.emilianosantucci.pokemongame.pokemon.PokemonService;

import java.util.List;

public class Application {
    public static void main(String[] args) throws FacadeException {
        PokemonService pokemonService = new PokemonService();
        List<Pokemon> pokemons = pokemonService.getAll();

        for (Pokemon pokemon : pokemons) {
            System.out.println("[");
            System.out.printf("\tName: %s\n", pokemon.getName());
            System.out.printf("\tType: %s\n", pokemon.getType().name());
            System.out.printf("\tStatus: %s\n", pokemon.getStatus().name());
            System.out.printf("\tLevel: %d\n", pokemon.getLevel());
            System.out.printf("\tHealth: %.2f\n", pokemon.getHealth());
            System.out.printf("\tActions: %s\n", pokemon.getActions());
            System.out.println("]");
        }
    }
}
