package ua.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.diploma.service.SessionService;
import ua.diploma.utils.ObjectMapperUtils;
import ua.diploma.domain.SessionDTO;
import ua.diploma.entity.SessionEntity;
import ua.diploma.exception.ResourceNotFoundException;
import ua.diploma.repository.SessionRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void saveSession(SessionDTO sessionDTO) {
        SessionEntity sessionEntity = modelMapper.map(sessionDTO, SessionEntity.class);
        sessionRepository.save(sessionEntity);
    }

    @Override
    public List<SessionDTO> getAllSession() {
        List<SessionEntity> sessionEntities = sessionRepository.findAll();
        List<SessionDTO> sessionDTOS = modelMapper.mapAll(sessionEntities, SessionDTO.class);
        return sessionDTOS;
    }

    @Override
    public SessionDTO findSessionById(Long id) {
        SessionEntity sessionEntity = sessionRepository.findById(id).get();
        SessionDTO sessionDTO = modelMapper.map(sessionEntity, SessionDTO.class);
        return sessionDTO;
    }

    @Override
    public List<SessionDTO> getSessionByFilmId(Long id) {

        List<SessionEntity> sessionEntities = sessionRepository.findByFilmId(id);
        List<SessionDTO> sessionDTOS = modelMapper.mapAll(sessionEntities, SessionDTO.class);
        return sessionDTOS;
    }

    @Override
    public List<SessionDTO> getSessionByFilmIdAndDate(Long id, LocalDate date) {
        List<SessionEntity> sessionEntities = sessionRepository.findByFilmIdAndDate(id, date);
        List<SessionDTO> sessionDTOS = modelMapper.mapAll(sessionEntities, SessionDTO.class);
        return sessionDTOS;
    }

    @Override
    public void deleteSessionById(Long id) {
        SessionEntity sessionEntity = sessionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Could not delete film with id[" + id + "]. Not Found!")
        );
        sessionRepository.deleteById(id);
    }

    @Override
    public List<SessionDTO> getSessionByFilmIdAndDateAndNameCinema(Long id, LocalDate date, String nameCinema) {

        List<SessionEntity> sessionEntities = sessionRepository.findByFilmIdAndDateAndNameCinema(id, date, nameCinema);
        List<SessionDTO> sessionDTOS = modelMapper.mapAll(sessionEntities, SessionDTO.class);
        return sessionDTOS;
    }
}
