package ua.logos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.logos.entity.HallEntity;
import ua.logos.entity.RoleEntity;
import ua.logos.enums.HallTypeEnum;
import ua.logos.repository.HallRepository;
import ua.logos.repository.RoleRepository;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private HallRepository hallRepository;

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

//        private Long id;
//
//        private int numberHall;
//
//        private int maxNumberPlace;
//
//        private HallTypeEnum hallType;

        if (hallRepository.count() == 0) {
            HallEntity hallEntity = new HallEntity();
            for (int i = 0; i < 10; i++) {
                hallEntity.setNumberHall(i);
                hallEntity.setMaxNumberPlace(100);
                hallEntity.setHallType(HallTypeEnum.GOOD);
                hallRepository.save(hallEntity);
                hallEntity = new HallEntity();
            }


        }
    }

}
