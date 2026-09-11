package br.com.p1.adocao_api.animals.dto;

import br.com.p1.adocao_api.animals.enums.AnimalSpecies;

import java.util.UUID;

public record AnimalResponseDTO(
        UUID id,
        String name,
        String description,
        Integer age,
        AnimalSpecies species
) {
}