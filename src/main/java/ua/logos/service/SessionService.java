package ua.logos.service;

import ua.logos.domain.SessionDTO;

import java.util.List;

public interface SessionService {

    void saveSession(SessionDTO sessionDTO);

    List<SessionDTO> getAllSession();

    SessionDTO getSessionById(Long id);

}
