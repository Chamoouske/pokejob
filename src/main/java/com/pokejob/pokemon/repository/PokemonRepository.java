package com.pokejob.pokemon.repository;

import com.pokejob.pokemon.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
