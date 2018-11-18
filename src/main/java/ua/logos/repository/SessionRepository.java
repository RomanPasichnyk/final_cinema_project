package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.logos.entity.SessionEntity;

@Repository
public interface SessionRepository extends JpaRepository<SessionEntity, Long> {
}
