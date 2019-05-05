package ua.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.diploma.entity.FilmEntity;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Long> {

    FilmEntity findByFilmName(String filmName);

}
