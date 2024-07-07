package com.pokejob.pokemon.client;

import com.pokejob.config.FeignConfig;
import com.pokejob.pokemon.dto.PokemonDto;
import com.pokejob.pokemon.dto.ResultAllPokemonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pokemonClient", url = "${servico.pokeapi.url-pokemon}", configuration = FeignConfig.class)
public interface PokemonClient {
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResultAllPokemonClient getAllLinksPokemon();
    @GetMapping(value = "{nomePokemon}", produces = {MediaType.APPLICATION_JSON_VALUE})
    PokemonDto getPokemon(@PathVariable("nomePokemon") String nomePokemon);
}
