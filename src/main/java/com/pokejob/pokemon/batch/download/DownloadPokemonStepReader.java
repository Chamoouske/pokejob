package com.pokejob.pokemon.batch.download;

import com.pokejob.pokemon.dto.PokemonDto;
import com.pokejob.pokemon.service.PokemonService;
import com.pokejob.utils.DoIfNotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
@RequiredArgsConstructor
public class DownloadPokemonStepReader implements ItemReader<PokemonDto> {
    private static final Integer MAX_COUNT = 10;
    private final PokemonService pokemonService;
    private Integer counter = 0;
    private JobExecution jobExecution;

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        jobExecution = stepExecution.getJobExecution();
    }

    @Override
    public PokemonDto read() {
        Chunk<?> chunk = (Chunk<?>) jobExecution.getExecutionContext().get("listPokemonStep");
        AtomicReference<PokemonDto> pokemonDto = new AtomicReference<>();
        DoIfNotNull.doIfNotNull(chunkNotNull -> {
            List<?> itemsList = chunkNotNull.getItems();
            if (!(itemsList.size() <= counter || counter > MAX_COUNT)) {
                pokemonDto.set(pokemonService.getPokemonFromPokeApi((String) itemsList.get(counter)));
                counter++;
            }
        }, chunk);
        return pokemonDto.get();
    }
}
