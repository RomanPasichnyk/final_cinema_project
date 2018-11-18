package ua.logos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.domain.SessionDTO;
import ua.logos.service.SessionService;

import java.util.List;

@RestController
@RequestMapping("sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping
    public ResponseEntity<?> saveSession(@RequestBody SessionDTO sessionDTO) {
        sessionService.saveSession(sessionDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllSession() {
        List<SessionDTO> sessionDTOS = sessionService.getAllSession();
        return new ResponseEntity<List<SessionDTO>>(sessionDTOS, HttpStatus.OK);
    }

}
