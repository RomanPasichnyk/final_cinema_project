package ua.diploma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.diploma.entity.RoleEntity;
import ua.diploma.repository.RoleRepository;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setName("ADMIN");
            roleRepository.save(roleEntity);

            roleEntity = new RoleEntity();
            roleEntity.setName("USER");

            roleRepository.save(roleEntity);
        }


    }

}
