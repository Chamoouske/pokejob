package com.pokejob.pokemon.client;

import com.pokejob.config.FeignConfig;
import com.pokejob.pokemon.dto.Pokemon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pokemonClient", url = "${servico.pokeapi.url-pokemon}", configuration = FeignConfig.class)
public interface PokemonClient {
    @GetMapping(value = "{nomePokemon}", produces = {MediaType.APPLICATION_JSON_VALUE})
    Pokemon getPokemon(@PathVariable("nomePokemon") String nomePokemon);
}
