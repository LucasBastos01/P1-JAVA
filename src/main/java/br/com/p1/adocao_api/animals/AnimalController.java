package br.com.p1.adocao_api.animals;

import br.com.p1.adocao_api.animals.dto.AnimalRequestDTO;
import br.com.p1.adocao_api.animals.dto.AnimalResponseDTO;
import br.com.p1.adocao_api.animals.enums.AnimalSpecies;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalsService;

    public AnimalController(AnimalService animalsService) {
        this.animalsService = animalsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalResponseDTO create(
            @Valid @RequestBody AnimalRequestDTO animal
    ) {
        return animalsService.create(animal);
    }

    @GetMapping
    public List<AnimalResponseDTO> getList(
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) AnimalSpecies species
    ) {
        return animalsService.getList(minAge, maxAge, species);
    }

    @GetMapping("/{id}")
    public AnimalResponseDTO getById(@PathVariable UUID id) {
        return animalsService.getById(id);
    }

    @PutMapping("/{id}")
    public AnimalResponseDTO update(
            @PathVariable UUID id,
            @Valid @RequestBody AnimalRequestDTO animal
    ) {
        return animalsService.update(id, animal);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        animalsService.delete(id);
    }
}