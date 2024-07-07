package com.pokejob.pokemon.utils;

import com.pokejob.pokemon.dto.PokemonDto;
import com.pokejob.pokemon.entity.Pokemon;

public class Converter {
    private Converter() {}

    public static PokemonDto toDto(Pokemon pokemon) {
        return new PokemonDto(pokemon.getId(), pokemon.getName(), pokemon.getOrder(), pokemon.getBaseExperience(), pokemon.getHeight(), pokemon.getWeight());
    }

    public static Pokemon toEntity(PokemonDto pokemonDto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(pokemonDto.id());
        pokemon.setName(pokemonDto.name());
        pokemon.setOrder(pokemonDto.order());
        pokemon.setBaseExperience(pokemonDto.baseExperience());
        pokemon.setHeight(pokemonDto.height());
        pokemon.setWeight(pokemonDto.weight());

        return pokemon;
    }
}
