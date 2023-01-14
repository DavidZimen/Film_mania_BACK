package sk.vaii.sem.semestralna_praca_vaii_backend.mapper;

import org.mapstruct.Mapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.RatingAddDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.RatingUpdateDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Rating;

@Mapper
public interface RatingMapper {
    Rating ratingUpdateDtoToRating(RatingUpdateDto ratingUpdateDto);
    Rating ratingAddDtoToRating(RatingAddDto ratingAddDto);
}
