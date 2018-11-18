package ua.logos.service;


import ua.logos.domain.FilmDTO;

import java.util.List;

public interface FilmService {

    void saveFilm(FilmDTO filmDTO);

    FilmDTO findFilmById(Long id);

    List<FilmDTO> getAllFilms();

}
