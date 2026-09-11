package br.com.p1.adocao_api.animals;

import br.com.p1.adocao_api.animals.enums.AnimalSpecies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AnimalsRepository extends JpaRepository<Animals, UUID> {

    List<Animals> findByAgeBetween(Integer minAge, Integer maxAge);

    List<Animals> findBySpecies(AnimalSpecies species);

    List<Animals> findByAgeBetweenAndSpecies(
            Integer minAge,
            Integer maxAge,
            AnimalSpecies species
    );
}