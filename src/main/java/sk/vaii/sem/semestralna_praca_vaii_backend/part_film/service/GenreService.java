package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Genre;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public Genre addGenre(Genre genre) {
        return this.genreRepository.save(genre);
    }

    public List<Genre> getAllGenres() {
        return this.genreRepository.findAll();
    }

    public Optional<Genre> getGenreById(Long id) {
        return this.genreRepository.findById(id);
    }

    public Optional<Genre> getGenreByName(String name) {
        return this.genreRepository.findByName(name);
    }

    public void deleteGenre(Long id) {
        this.genreRepository.deleteById(id);
    }
}
