package com.pokejob.pokemon.service;

import com.pokejob.pokemon.client.PokemonClient;
import com.pokejob.pokemon.dto.PokemonDto;
import com.pokejob.pokemon.entity.Pokemon;
import com.pokejob.pokemon.repository.PokemonRepository;
import com.pokejob.pokemon.utils.Converter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PokemonService {
    private final PokemonClient client;
    private final PokemonRepository pokemonRepository;

    public PokemonDto getPokemonFromPokeApi(String namePokemon) {
        return client.getPokemon(namePokemon);
    }

    @Transactional
    public PokemonDto addPokemon(Pokemon pokemon) {
        return Converter.toDto(pokemonRepository.save(pokemon));
    }
}
