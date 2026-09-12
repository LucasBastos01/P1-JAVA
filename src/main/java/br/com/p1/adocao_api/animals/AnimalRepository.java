package br.com.p1.adocao_api.animals;

import br.com.p1.adocao_api.animals.enums.AnimalSpecies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AnimalRepository extends JpaRepository<Animal, UUID> {

    List<Animal> findByAgeBetween(Integer minAge, Integer maxAge);

    List<Animal> findBySpecies(AnimalSpecies species);

    List<Animal> findByAgeBetweenAndSpecies(
            Integer minAge,
            Integer maxAge,
            AnimalSpecies species
    );
}