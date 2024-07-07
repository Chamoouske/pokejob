package com.pokejob.pokemon.dto;

import java.util.List;

public record ResultAllPokemonClient(String count, String next, String previous, List<PokemonUrlDto> results) {
}
