package sk.vaii.sem.film_mania_back.part_security.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import sk.vaii.sem.film_mania_back.part_security.dto.RoleDto;
import sk.vaii.sem.film_mania_back.part_security.service.RoleService;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping(value = "role/{userId}")
    public ResponseEntity<RoleDto> getRolesOfUser(@PathVariable @NonNull Long userId) {
        return new ResponseEntity<>(this.roleService.getUserRoles(userId), HttpStatus.OK);
    }
}
