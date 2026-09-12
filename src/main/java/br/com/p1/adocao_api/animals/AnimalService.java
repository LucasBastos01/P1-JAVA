package br.com.p1.adocao_api.animals;

import br.com.p1.adocao_api.animals.dto.AnimalRequestDTO;
import br.com.p1.adocao_api.animals.dto.AnimalResponseDTO;
import br.com.p1.adocao_api.animals.enums.AnimalSpecies;
import br.com.p1.adocao_api.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnimalService {

    private final AnimalRepository animalsRepository;

    public AnimalService(AnimalRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    public AnimalResponseDTO create(AnimalRequestDTO request) {

        Animal animal = new Animal();

        animal.setName(request.name());
        animal.setDescription(request.description());
        animal.setAge(request.age());
        animal.setSpecies(request.species());

        Animal savedAnimal = animalsRepository.save(animal);

        return toResponse(savedAnimal);
    }

    public List<AnimalResponseDTO> getList(
            Integer minAge,
            Integer maxAge,
            AnimalSpecies species
    ) {

        List<Animal> animals;

        if (minAge != null && maxAge != null && species != null) {
            animals = animalsRepository.findByAgeBetweenAndSpecies(
                    minAge,
                    maxAge,
                    species
            );

        } else if (minAge != null && maxAge != null) {
            animals = animalsRepository.findByAgeBetween(minAge, maxAge);

        } else if (species != null) {
            animals = animalsRepository.findBySpecies(species);

        } else {
            animals = animalsRepository.findAll();
        }

        return animals.stream()
                .map(this::toResponse)
                .toList();
    }

    public AnimalResponseDTO getById(UUID id) {

        Animal animal = findAnimalById(id);

        return toResponse(animal);
    }

    public AnimalResponseDTO update(UUID id, AnimalRequestDTO request) {

        Animal existingAnimal = findAnimalById(id);

        existingAnimal.setName(request.name());
        existingAnimal.setDescription(request.description());
        existingAnimal.setAge(request.age());
        existingAnimal.setSpecies(request.species());

        Animal updatedAnimal = animalsRepository.save(existingAnimal);

        return toResponse(updatedAnimal);
    }

    public void delete(UUID id) {

        Animal animal = findAnimalById(id);

        animalsRepository.delete(animal);
    }

    private Animal findAnimalById(UUID id) {
        return animalsRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Animal não encontrado")
                );
    }

    private AnimalResponseDTO toResponse(Animal animal) {
        return new AnimalResponseDTO(
                animal.getId(),
                animal.getName(),
                animal.getDescription(),
                animal.getAge(),
                animal.getSpecies()
        );
    }
}