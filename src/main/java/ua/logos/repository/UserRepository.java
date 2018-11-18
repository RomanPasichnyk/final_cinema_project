package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.logos.entity.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

    List<UserEntity> findByNameLikeOrEmail(String name, String email);

    UserEntity findByPhoneNumber(String phoneNumber);

}
