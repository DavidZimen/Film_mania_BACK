package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service;

import com.scheidtbachmann.ps.search.searchextension.dto.SearchResult;
import com.scheidtbachmann.ps.search.searchextension.service.Searchable;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.DirectorMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.DirectorAddDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.DirectorUpdateDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Director;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.FilmPartImage;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.DirectorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DirectorService implements Searchable<SearchResult> {

    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper;
    private final FilmPartImageService filmPartImageService;

    public Director addDirector(DirectorAddDto directorAddDto) {
        Director director = this.directorMapper.directorAddDtoToActor(directorAddDto);

        if (directorAddDto.getImage_id() == null) throw new IllegalStateException("Nesmie byt null");

        //find image and set it ot actor
        Optional<FilmPartImage> image = this.filmPartImageService.getImageById(directorAddDto.getImage_id());
        image.ifPresent(director::setDirectorImage);

        return this.directorRepository.save(director);
    }

    public Director updateDirector(DirectorUpdateDto directorUpdateDto) {
        Director director = this.directorMapper.directorUpdateDtoToActor(directorUpdateDto);

        //find image and set it ot director
        Optional<FilmPartImage> image = this.filmPartImageService.getImageById(directorUpdateDto.getImage_id().getId());
        image.ifPresent(director::setDirectorImage);

        return this.directorRepository.save(director);
    }

    public List<Director> getAllDirectors() {
        return this.directorRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Optional<Director> getDirectorById(Long id) {
        return this.directorRepository.findById(id);
    }

    public Optional<Director> getDirectorByName(String name) {
        return this.directorRepository.findByName(name);
    }

    public Director getDirectorOfFilm(Long filmId) {
        return this.directorRepository.getDirectorOfFilm(filmId);
    }

    public void deleteDirector(Long id) {
        Director director = this.directorRepository.getById(id);
        if (director.getFilms().isEmpty()) {
            this.directorRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Director can't be assigned to any movie.");
        }
    }

    @Override
    public List<SearchResult> search(String query) {
        return directorRepository.searchDirectors(query)
                .stream()
                .map(director -> {
                    SearchResult result = directorMapper.toSearchResultDto(director);
                    result.setResultType("Director");
                    return result;
                })
                .collect(Collectors.toList());
    }
    
}
