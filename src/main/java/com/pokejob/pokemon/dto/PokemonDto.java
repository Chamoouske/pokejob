package com.pokejob.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PokemonDto(Long id, String name, Long order, @JsonProperty("base_experience") Long baseExperience, Double height, Double weight) {
}
