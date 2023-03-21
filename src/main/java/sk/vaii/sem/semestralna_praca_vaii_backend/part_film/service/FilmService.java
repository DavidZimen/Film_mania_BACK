package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.FilmMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.FilmAddDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.FilmDetailDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.FilmInTableDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.FilmUpdateDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.*;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.FilmRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.searching.dto.SearchResultDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.searching.service.Searchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilmService implements Searchable {

    private final FilmRepository filmRepository;
    private final FilmPartImageService filmPartImageService;
    private final FilmMapper filmMapper;
    private final DirectorService directorService;
    private final ActorService actorService;
    private final GenreService genreService;

    private final RatingService ratingService;

    public Film addFilm(FilmAddDto filmAddDto) {
        Film film = this.filmMapper.filmAddDtotoFilm(filmAddDto);

        //find image and set it ot actor
        Optional<FilmPartImage> image = this.filmPartImageService.getImageById(filmAddDto.getImage_id());
        image.ifPresent(film::setFilmImage);

        //find actors in DB and set them to film
        List<Actor> actors = new ArrayList<>(filmAddDto.getActorIds().size());
        filmAddDto.getActorIds().forEach((id) -> {
            Actor actor = this.actorService.getActorById(id).get();
            actors.add(actor);
        });
        film.setActors(actors);

        //find director and set him to film
        Director director = this.directorService.getDirectorById(filmAddDto.getDirectorId()).get();
        film.setDirector(director);

        //find genres and set them to film
        List<Genre> genres = new ArrayList<>(filmAddDto.getGenreIds().size());
        filmAddDto.getGenreIds().forEach((id) -> {
            Genre genre = this.genreService.getGenreById(id).get();
            genres.add(genre);
        });
        film.setGenres(genres);

        //persist in DB
        return this.filmRepository.save(film);
    }

    public Film updateFilm(FilmUpdateDto filmUpdateDto) {
        Film film = this.filmMapper.filmUpdateDtoToFilm(filmUpdateDto);

        //find image and set it to film
        Optional<FilmPartImage> image = this.filmPartImageService.getImageById(filmUpdateDto.getImage_id().getId());
        image.ifPresent(film::setFilmImage);

        //find actors in DB and set them to film
        List<Actor> actors = new ArrayList<>(filmUpdateDto.getActorIds().size());
        filmUpdateDto.getActorIds().forEach((id) -> {
            Actor actor = this.actorService.getActorById(id).get();
            actors.add(actor);
        });
        film.setActors(actors);

        //find director and set him to film
        Director director = this.directorService.getDirectorById(filmUpdateDto.getDirectorId()).get();
        film.setDirector(director);

        //find genres and set them to film
        List<Genre> genres = new ArrayList<>(filmUpdateDto.getGenreIds().size());
        filmUpdateDto.getGenreIds().forEach((id) -> {
            Genre genre = this.genreService.getGenreById(id).get();
            genres.add(genre);
        });
        film.setGenres(genres);

        //find ratings and set them to film
        List<Rating> ratings = this.ratingService.getRatingsOfFilm(film.getId());
        film.setRatings(ratings);

        return this.filmRepository.save(film);
    }

    public List<FilmInTableDto> getAllFilmsForTable(Long userId) {
        List<Film> films = this.filmRepository.findAll();
        List<FilmInTableDto> filmInTableDtos = this.filmMapper.filmsToFilmInTableDtos(films);

        for (int i = 0; i < films.size(); i++) {
            double avgRating = this.ratingService.convertToAverageRating(films.get(i).getRatings());
            filmInTableDtos.get(i).setOverallRating(avgRating);
            if (userId != null) {
                Optional<Rating> rating = this.ratingService.getUserRatingOfFilm(userId, films.get(i).getId());
                if (rating.isPresent()) {
                    filmInTableDtos.get(i).setUserRating(rating.get().getRating());
                    filmInTableDtos.get(i).setRatingId(rating.get().getId());
                } else {
                    filmInTableDtos.get(i).setUserRating(-1);
                    filmInTableDtos.get(i).setRatingId(-1L);
                }
            }
        }

        return filmInTableDtos;
    }

    public FilmDetailDto getFilmById(Long filmId, Long userId) {
        Film film = this.filmRepository.getById(filmId);
        double avgRating = this.ratingService.convertToAverageRating(film.getRatings());

        FilmDetailDto filmDetail = this.filmMapper.filmToFilmDetailDto(film);
        filmDetail.setOverallRating(avgRating);
        if (userId != null) {
            Optional<Rating> rating = this.ratingService.getUserRatingOfFilm(userId, filmId);
            if (rating.isPresent()) {
                filmDetail.setUserRating(rating.get().getRating());
                filmDetail.setRatingId(rating.get().getId());
            } else {
                filmDetail.setUserRating(-1);
                filmDetail.setRatingId(-1L);
            }
        }

        return filmDetail;
    }

    public FilmAddDto getFilmForUpdate(Long id) {
        return this.filmMapper.filmToFilmAddDto(this.filmRepository.getById(id));
    }

    public boolean deleteFilm(Long id) {
        this.filmRepository.deleteById(id);
        return true;
    }

    public List<Film> getAllFilms() {
        return this.filmRepository.findAll();
    }

    @Override
    public List<SearchResultDto> search(String query) {
        return filmMapper.toSearchResultDtoList(filmRepository.searchFilms(query))
                .stream()
                .peek(film -> {
                    film.setResultType("Film");
                    film.setResultLink("http://localhost:4201/films_list/film/" + film.getResultLocalId());
                })
                .collect(Collectors.toList());
    }
}
