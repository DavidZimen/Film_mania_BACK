package sk.vaii.sem.film_mania_back.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sk.vaii.sem.film_mania_back.part_security.entities.Privilege;
import sk.vaii.sem.film_mania_back.part_security.entities.Role;
import sk.vaii.sem.film_mania_back.part_security.repository.PrivilegeRepository;
import sk.vaii.sem.film_mania_back.part_security.repository.RoleRepository;
import sk.vaii.sem.film_mania_back.part_appuser.entities.AppUser;
import sk.vaii.sem.film_mania_back.part_appuser.repositoriy.AppUserRepository;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Component
public class StarterConfig implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = true;

    @Autowired
    private AppUserRepository userRepository;

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

        Role authorRole = this.roleRepository.findByName("ROLE_AUTHOR");
        AppUser appUser = new AppUser();
        appUser.setFisrtName("author");
        appUser.setLastName("author");
        appUser.setPassword(passwordEncoder.encode("author"));
        appUser.setEmail("author@author.com");
        appUser.setRoles(Arrays.asList(authorRole));
        appUser.setEnabled(true);
        userRepository.save(appUser);

        alreadySetup = true;
    }

    @Transactional
    public Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = this.privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            this.privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    public Role createRoleIfNotFound(
            String name, List<Privilege> privileges) {

        Role role = this.roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
