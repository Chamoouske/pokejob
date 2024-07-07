package com.pokejob.pokemon.batch;

import com.pokejob.commons.JobListenner;
import com.pokejob.pokemon.batch.download.DownloadPokemonStep;
import com.pokejob.pokemon.batch.read.list.ListPokemonStep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class PokemonJob {
    private final JobRepository jobRepository;
    private final JobListenner jobListenner;

    @Bean
    public Job getJob(DownloadPokemonStep downloadPokemonStep, ListPokemonStep listPokemonStep) {
        return new JobBuilder("downloadPokemonJob", jobRepository)
                .listener(jobListenner)
                .start(listPokemonStep.getStep())
                .next(downloadPokemonStep.getStep())
                .build();
    }
}
