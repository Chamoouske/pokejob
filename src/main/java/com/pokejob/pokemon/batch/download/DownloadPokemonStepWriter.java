package com.pokejob.pokemon.batch.download;

import com.pokejob.pokemon.entity.Pokemon;
import com.pokejob.pokemon.service.PokemonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@Log
@RequiredArgsConstructor
public class DownloadPokemonStepWriter implements ItemWriter<Pokemon> {
    private final PokemonService pokemonService;

    @Override
    public void write(Chunk<? extends Pokemon> chunk) {
        chunk.getItems().forEach(c -> {
            pokemonService.addPokemon(c);
            log.info("Added pokemon: " + c);
        });
    }
}
