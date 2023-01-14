package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.FilmPartImage;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.FilmPartImageRepository;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FilmPartImageService {

    private final FilmPartImageRepository filmPartImageRepository;

    public Optional<FilmPartImage> getImageById(Long id) {
        return this.filmPartImageRepository.findById(id);
    }

    @Transactional
    public FilmPartImage uploadImage(MultipartFile image) throws IOException {
        FilmPartImage filmPartImage = new FilmPartImage();
        filmPartImage.setImage(image.getBytes());

        return this.filmPartImageRepository.save(filmPartImage);
    }

    @Transactional
    public FilmPartImage updateImage(MultipartFile image) throws IOException {
        if (image.getName().equals("image")) {
            return this.uploadImage(image);
        }

        FilmPartImage filmPartImage = this.filmPartImageRepository.getById(Long.parseLong(image.getName()));
        filmPartImage.setImage(image.getBytes());

        return this.filmPartImageRepository.save(filmPartImage);
    }
}
