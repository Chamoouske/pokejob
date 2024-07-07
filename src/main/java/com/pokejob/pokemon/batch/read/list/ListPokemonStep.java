package com.pokejob.pokemon.batch.read.list;

import com.pokejob.pokemon.dto.PokemonFileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ListPokemonStep {
    private static final Integer NUMERO_PADRAO_CHUNKS = 5;
    private final JobRepository jobRepository;
    private final DataSourceTransactionManager dataSourceTransactionManager;
    private final FlatFileItemReader<PokemonFileDto> reader;
    private final ListPokemonStepWriter writer;
    private Step step;

    public Step getStep() {
        if (step == null) {
            step = new StepBuilder("downloadPokemonStep", jobRepository)
                    .<PokemonFileDto, String>chunk(NUMERO_PADRAO_CHUNKS, dataSourceTransactionManager)
                    .reader(reader)
                    .processor(PokemonFileDto::getNome)
                    .writer(writer)
                    .build();
        }

        return step;
    }
}
