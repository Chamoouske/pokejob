package com.pokejob.pokemon.batch.read.list;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class ListPokemonStepWriter implements ItemWriter<String> {
    private JobExecution jobExecution;

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        jobExecution = stepExecution.getJobExecution();
    }

    @Override
    public void write(Chunk<? extends String> chunk) {
        jobExecution.getExecutionContext().put("listPokemonStep", chunk);
    }
}
