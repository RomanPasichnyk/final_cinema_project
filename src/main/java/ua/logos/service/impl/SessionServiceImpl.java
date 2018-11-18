package ua.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.domain.SessionDTO;
import ua.logos.entity.SessionEntity;
import ua.logos.repository.SessionRepository;
import ua.logos.service.SessionService;
import ua.logos.utils.ObjectMapperUtils;

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
    public SessionDTO getSessionById(Long id) {
        return null;
    }
}
