package ua.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.domain.FilmDTO;
import ua.logos.entity.FilmEntity;
import ua.logos.repository.FilmRepository;
import ua.logos.service.FilmService;
import ua.logos.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void saveFilm(FilmDTO filmDTO) {
        FilmEntity filmEntity = modelMapper.map(filmDTO, FilmEntity.class);
        filmRepository.save(filmEntity);
    }

    @Override
    public List<FilmDTO> getAllFilms() {
        List<FilmEntity> filmEntities = filmRepository.findAll();
        List<FilmDTO> filmDTOS = modelMapper.mapAll(filmEntities, FilmDTO.class);
        return filmDTOS;
    }

    @Override
    public FilmDTO findFilmById(Long id) {
        return null;
    }
}
