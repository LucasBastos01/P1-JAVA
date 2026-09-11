package br.com.p1.adocao_api.animals.dto;

import br.com.p1.adocao_api.animals.enums.AnimalSpecies;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnimalRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        String name,

        String description,

        @NotNull(message = "A idade é obrigatória")
        @Min(value = 0, message = "A idade não pode ser negativa")
        Integer age,

        @NotNull(message = "A espécie é obrigatória")
        AnimalSpecies species

) {
}