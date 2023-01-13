package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Director;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.DirectorRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DirectorService {

    private final DirectorRepository directorRepository;

    public Director addDirector(Director director) {
        return this.directorRepository.save(director);
    }

    public Director updateDirector(Director director) {
        return this.directorRepository.save(director);
    }

    public List<Director> getAllDirectors() {
        return this.directorRepository.findAll();
    }

    public Optional<Director> getDirectorById(Long id) {
        return this.directorRepository.findById(id);
    }

    public Optional<Director> getDirectorByName(String name) {
        return this.directorRepository.findByName(name);
    }

    public void deleteDirector(Long id) {
        this.directorRepository.deleteById(id);
    }
    
}
