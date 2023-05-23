package sk.vaii.sem.film_mania_back.mapper;

import org.mapstruct.Mapper;
import sk.vaii.sem.film_mania_back.part_film.entity.Rating;
import sk.vaii.sem.film_mania_back.part_film.dto.RatingAddDto;
import sk.vaii.sem.film_mania_back.part_film.dto.RatingUpdateDto;

@Mapper
public interface RatingMapper {
    Rating ratingUpdateDtoToRating(RatingUpdateDto ratingUpdateDto);
    Rating ratingAddDtoToRating(RatingAddDto ratingAddDto);
}
