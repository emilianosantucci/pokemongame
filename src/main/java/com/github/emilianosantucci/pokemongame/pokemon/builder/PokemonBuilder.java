package com.github.emilianosantucci.pokemongame.pokemon.builder;

import com.github.emilianosantucci.pokemongame.pattern.BuildException;
import com.github.emilianosantucci.pokemongame.pattern.Builder;
import com.github.emilianosantucci.pokemongame.pattern.FactoryException;
import com.github.emilianosantucci.pokemongame.pokemon.BasePokemon;
import com.github.emilianosantucci.pokemongame.pokemon.Pokemon;
import com.github.emilianosantucci.pokemongame.pokemon.PokemonType;
import com.github.emilianosantucci.pokemongame.pokemon.factory.PokemonTypeFactory;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PokemonBuilder implements Builder<Pokemon> {
    @Setter
    String name;

    @Setter
    PokemonType type;

    @Override
    public Pokemon build() throws BuildException {
        Pokemon pokemon = new BasePokemon();

        try {
            checks();
            PokemonTypeFactory factory = PokemonTypeFactory.newInstance();
            factory.get(type).apply(pokemon);
        } catch (FactoryException fe) {
            throw new BuildException(String.format("Failed to get type factory for type '%s'.", type.name()), fe);
        } catch (Exception e) {
            throw new BuildException(e);
        }

        return pokemon;
    }

    private void checks() throws BuildException {
        if (type == null) {
            throw new BuildException("Pokemon type must not be null.");
        }

        if (name == null || name.equals("")) {
            throw new BuildException("Pokemon name must not be null or empty.");
        }
    }
}
