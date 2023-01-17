package sk.vaii.sem.semestralna_praca_vaii_backend.mapper;

import org.mapstruct.Mapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.DirectorAddDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.DirectorUpdateDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Director;

@Mapper
public interface DirectorMapper {
    Director directorAddDtoToActor(DirectorAddDto directorAddDto);
    Director directorUpdateDtoToActor(DirectorUpdateDto directorUpdateDto);
}
