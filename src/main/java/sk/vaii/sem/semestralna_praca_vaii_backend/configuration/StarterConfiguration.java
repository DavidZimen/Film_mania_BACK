package sk.vaii.sem.semestralna_praca_vaii_backend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.AppUser;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.Privilege;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.Role;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.PrivilegeRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.RoleRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;

@Component
public class StarterConfiguration implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = true;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        Privilege readPrivilege = this.createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = this.createPrivilegeIfNotFound("WRITE_PRIVILEGE");
        Privilege deletePrivilege = this.createPrivilegeIfNotFound("DELETE_PRIVILEGE");

        this.createRoleIfNotFound("ROLE_ADMIN", Arrays.asList(readPrivilege, writePrivilege, deletePrivilege));
        this.createRoleIfNotFound("ROLE_AUTHOR", Arrays.asList(readPrivilege, writePrivilege));
        this.createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        Role userRole = this.roleRepository.findByName("ROLE_USER");
        AppUser appUser = new AppUser();
        appUser.setFisrtName("user");
        appUser.setLastName("user");
        appUser.setPassword(passwordEncoder.encode("user"));
        appUser.setEmail("user@user.com");
        appUser.setRoles(Arrays.asList(userRole));
        appUser.setEnabled(true);
        userRepository.save(appUser);

        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = this.privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            this.privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Role role = this.roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
