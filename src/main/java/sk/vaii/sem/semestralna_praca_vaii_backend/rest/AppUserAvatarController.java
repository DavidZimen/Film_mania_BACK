package sk.vaii.sem.semestralna_praca_vaii_backend.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.AppUserAvatar;
import sk.vaii.sem.semestralna_praca_vaii_backend.service.AppUserAvatarService;


@RestController
@RequestMapping("/avatar")
@AllArgsConstructor
public class AppUserAvatarController {

    private final AppUserAvatarService appUserAvatarService;

    @GetMapping("{id}")
    public ResponseEntity<AppUserAvatar> getArticleByid(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.appUserAvatarService.getAvatar(id), HttpStatus.OK);
    }
}
