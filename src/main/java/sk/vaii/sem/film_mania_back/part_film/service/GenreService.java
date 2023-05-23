package sk.vaii.sem.film_mania_back.part_film.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sk.vaii.sem.film_mania_back.part_film.repository.GenreRepository;
import sk.vaii.sem.film_mania_back.part_film.entity.Genre;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public Genre addGenre(String genreName) {
        Genre genre = new Genre();
        genre.setName(genreName);

        return this.genreRepository.save(genre);
    }

    public List<Genre> getAllGenres() {
        return this.genreRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Optional<Genre> getGenreById(Long id) {
        return this.genreRepository.findById(id);
    }

    public Optional<Genre> getGenreByName(String name) {
        return this.genreRepository.findByName(name);
    }

    public List<Genre> getGenresOfFilm(Long filmId) {
        return this.genreRepository.getGenresOfFilm(filmId);
    }

    public void deleteGenre(Long id) {
        Genre genre = this.genreRepository.getById(id);
        if (genre.getFilms().isEmpty()) {
            this.genreRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Genre can't be assigned to any movie.");
        }
    }
}
