package com.pokejob.pokemon.batch.download;

import com.pokejob.pokemon.dto.PokemonDto;
import com.pokejob.pokemon.service.PokemonService;
import com.pokejob.utils.DoIfNotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Component
@RequiredArgsConstructor
public class DownloadPokemonStepReader implements ItemReader<PokemonDto> {
    private final PokemonService pokemonService;
    private final AtomicInteger counter = new AtomicInteger(0);
    private List<String> pokemonNames;

    @BeforeStep
    @SuppressWarnings("unchecked")
    public void beforeStep(StepExecution stepExecution) {
        pokemonNames = (List<String>) stepExecution.getJobExecution().getExecutionContext().get("listPokemonStep");
    }

    @Override
    public PokemonDto read() {
        AtomicReference<PokemonDto> pokemonDto = new AtomicReference<>();
        DoIfNotNull.doIfNotNull(itensNotNull -> {
            if (counter.get() < itensNotNull.size()) {
                pokemonDto.set(pokemonService.getPokemonFromPokeApi(itensNotNull.get(counter.getAndIncrement())));
            }
        }, pokemonNames);
        return pokemonDto.get();
    }
}
