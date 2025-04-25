package com.ms.auth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ms.auth.models.ERole;
import com.ms.auth.models.Roles;
import com.ms.auth.repository.RoleRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initializeRoles();
    }

    private void initializeRoles() {
        // Eliminar roles existentes primero
        roleRepository.deleteAll();

        // Crear y guardar los nuevos roles
        Roles userRole = new Roles();
        userRole.setId("1");
        userRole.setName(ERole.ROLE_USER);
        roleRepository.save(userRole);

        Roles modRole = new Roles();
        modRole.setId("2");
        modRole.setName(ERole.ROLE_MODERATOR);
        roleRepository.save(modRole);

        Roles adminRole = new Roles();
        adminRole.setId("3");
        adminRole.setName(ERole.ROLE_ADMIN);
        roleRepository.save(adminRole);

        System.out.println("Roles inicializados correctamente");
    }
}
