package com.pokejob.config;

import com.pokejob.pokemon.dto.PokemonFileDto;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public FlatFileItemReader<PokemonFileDto> reader() {
        return new FlatFileItemReaderBuilder<PokemonFileDto>()
                .name("pokemonListItemReader")
                .resource(new ClassPathResource("data/pokemons.txt"))
                .delimited()
                .names("nome")
                .targetType(PokemonFileDto.class)
                .build();
    }
}
