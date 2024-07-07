package com.pokejob.pokemon.batch.download;

import com.pokejob.pokemon.dto.PokemonDto;
import com.pokejob.pokemon.entity.Pokemon;
import com.pokejob.pokemon.utils.Converter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class DownloadPokemonStepProcessor implements ItemProcessor<PokemonDto, Pokemon> {
    @Override
    public Pokemon process(PokemonDto item) {
        return Converter.toEntity(item);
    }
}
