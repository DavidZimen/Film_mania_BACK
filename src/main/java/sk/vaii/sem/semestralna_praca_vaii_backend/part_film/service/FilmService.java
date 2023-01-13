package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.FilmMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.FilmAddDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Actor;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Director;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Film;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Genre;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.FilmRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;
    private final DirectorService directorService;
    private final ActorService actorService;
    private final GenreService genreService;

    public Film addFilm(FilmAddDto filmAddDto) {
        Film film = this.filmMapper.filmAddDtotoFilm(filmAddDto);

        //find actors in DB and set them to film
        List<Actor> actors = new ArrayList<>(filmAddDto.getActorNames().size());
        filmAddDto.getActorNames().forEach((name) -> {
            Actor actor = this.actorService.getActorByName(name).get();
            actors.add(actor);
        });
        film.setActors(actors);

        //find director and set him to film
        Director director = this.directorService.getDirectorByName(filmAddDto.getDirectorName()).get();
        film.setDirector(director);

        //find genres and set them to film
        List<Genre> genres = new ArrayList<>(filmAddDto.getGenreNames().size());
        filmAddDto.getGenreNames().forEach((name) -> {
            Genre genre = this.genreService.getGenreByName(name).get();
            genres.add(genre);
        });
        film.setGenres(genres);

        //persist in DB
        return this.filmRepository.save(film);
    }

    public List<Film> getAllFilms() {
        return this.filmRepository.findAll();
    }
}
