package com.pokejob.pokemon.batch.download;

import com.pokejob.pokemon.dto.PokemonDto;
import com.pokejob.pokemon.entity.Pokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DownloadPokemonStep {
    private static final Integer NUMERO_PADRAO_CHUNKS = 5;
    private final JobRepository jobRepository;
    private final DataSourceTransactionManager dataSourceTransactionManager;
    private final DownloadPokemonStepReader reader;
    private final DownloadPokemonStepWriter writer;
    private final DownloadPokemonStepProcessor processor;
    private Step step;

    public Step getStep() {
        if (step == null) {
            step = new StepBuilder("downloadPokemonStep", jobRepository)
                    .<PokemonDto, Pokemon>chunk(NUMERO_PADRAO_CHUNKS, dataSourceTransactionManager)
                    .reader(reader)
                    .processor(processor)
                    .writer(writer)
                    .build();
        }

        return step;
    }
}
