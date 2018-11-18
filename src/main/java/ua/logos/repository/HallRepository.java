package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.logos.entity.HallEntity;

@Repository
public interface HallRepository extends JpaRepository<HallEntity, Long> {
}
