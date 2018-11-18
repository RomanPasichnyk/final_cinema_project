package ua.logos.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.logos.entity.FilmEntity;
import ua.logos.entity.HallEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor

public class SessionDTO {

    private Long id;

    private LocalTime time;

    private LocalDate date;

    private FilmEntity film;

    private HallEntity hall;

}
