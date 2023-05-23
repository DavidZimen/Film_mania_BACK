package sk.vaii.sem.film_mania_back.part_film.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.film_mania_back.part_film.entity.Film;
import sk.vaii.sem.film_mania_back.part_film.entity.Rating;
import sk.vaii.sem.film_mania_back.part_film.repository.FilmRepository;
import sk.vaii.sem.film_mania_back.part_film.repository.RatingRepository;
import sk.vaii.sem.film_mania_back.part_appuser.entities.AppUser;
import sk.vaii.sem.film_mania_back.part_appuser.service.AppUserService;
import sk.vaii.sem.film_mania_back.part_film.dto.RatingAddDto;
import sk.vaii.sem.film_mania_back.part_film.dto.RatingUpdateDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;
    private final AppUserService appUserService;
    private final FilmRepository filmService;


    public double convertToAverageRating(List<Rating> ratings) {
        if (ratings.size() == 0) return 0.0;

        int sum = 0;

        for (Rating rating : ratings) {
            sum += rating.getRating();
        }

        double result = (double)sum / ratings.size();

        return new BigDecimal(result).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    public Optional<Rating> getUserRatingOfFilm(Long userId, Long filmId) {
        return this.ratingRepository.getRatingOfUserToTheFilm(userId, filmId);
    }

    public Rating addRating(RatingAddDto ratingAddDto) {
        AppUser appUser = this.appUserService.loadUserById(ratingAddDto.getUserId());
        Film film = this.filmService.getById(ratingAddDto.getFilmId());

        Rating rating = new Rating();
        rating.setRating(ratingAddDto.getRating());
        rating.setFilm(film);
        rating.setAppUser(appUser);

        return this.ratingRepository.save(rating);
    }

    public Rating updateRating(RatingUpdateDto ratingUpdateDto) {
        Rating rating = this.ratingRepository.getById(ratingUpdateDto.getId());
        rating.setRating(ratingUpdateDto.getRating());

        return this.ratingRepository.save(rating);
    }

    public List<Rating> getRatingsOfFilm(Long filmId) {
        return this.ratingRepository.getRatingsOfFilm(filmId);
    }
}
