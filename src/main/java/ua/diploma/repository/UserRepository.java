package ua.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.diploma.entity.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByNameLikeOrEmail(String name, String email);

    UserEntity findByPhoneNumber(String phoneNumber);

    Optional<UserEntity> findByEmail(String email);

    Boolean existsByEmail(String email);

}
