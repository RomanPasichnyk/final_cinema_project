package ua.diploma.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.diploma.entity.UserEntity;
import ua.diploma.entity.FilmEntity;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor

public class CommentDTO {

    private Long id;

    private String comment;

    private LocalTime commentsTime;

    private LocalDate commentsDate;

    private FilmEntity film;

    private UserEntity user;

}
