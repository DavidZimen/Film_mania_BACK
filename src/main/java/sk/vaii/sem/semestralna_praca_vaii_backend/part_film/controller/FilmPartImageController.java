package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service.FilmPartImageService;

import java.io.IOException;

@RestController
@RequestMapping("/filmPartImage")
@CrossOrigin(origins = "http://localhost:4201")
@AllArgsConstructor
public class FilmPartImageController {

    private final FilmPartImageService filmPartImageService;

    @PostMapping("upload")
    public ResponseEntity<Long> uploadImage(@RequestParam("image") MultipartFile image) {
        try {
            return new ResponseEntity<>(this.filmPartImageService.uploadImage(image).getId(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping ("update")
    ResponseEntity<Long> updateImage(@RequestParam("image") MultipartFile image) {
        try {
            return new ResponseEntity<>(this.filmPartImageService.updateImage(image).getId(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
