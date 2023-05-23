package sk.vaii.sem.film_mania_back.part_security.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import sk.vaii.sem.film_mania_back.part_security.dto.PrivilegeDto;
import sk.vaii.sem.film_mania_back.part_security.service.PrivilegeService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/privileges")
public class PrivilegeController {

    private final PrivilegeService privilegeService;

    @GetMapping(value = "privilege/{roleId}")
    public ResponseEntity<List<PrivilegeDto>> getPrivilegesOfRole(@PathVariable @NonNull Long roleId) {
        return new ResponseEntity<>(this.privilegeService.getPrivilegesOfRole(roleId), HttpStatus.OK);
    }
}
