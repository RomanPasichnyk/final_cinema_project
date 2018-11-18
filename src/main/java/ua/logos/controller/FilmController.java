package ua.logos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.domain.FilmDTO;
import ua.logos.service.FilmService;

import java.util.List;

@RestController
@RequestMapping("films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostMapping
    public ResponseEntity<?> addFilm(@RequestBody FilmDTO filmDTO) {
        System.out.println(filmDTO);
        filmService.saveFilm(filmDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllFilms() {
        List<FilmDTO> filmDTOS = filmService.getAllFilms();
        return new ResponseEntity<List<FilmDTO>>(filmDTOS, HttpStatus.OK);
    }

    @GetMapping("{filmId}")
    public ResponseEntity<?> getFilmById(@PathVariable("filmId") Long id) {
        FilmDTO filmDTO = filmService.findFilmById(id);
        return new ResponseEntity<FilmDTO>(filmDTO, HttpStatus.OK);
    }


}
