package ua.logos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.domain.HallDTO;
import ua.logos.service.HallService;

import java.util.List;

@RestController
@RequestMapping("halls")
public class HallController {

    @Autowired
    private HallService hallService;

    @PostMapping
    public ResponseEntity<?> saveHall(@RequestBody HallDTO hallDTO) {
        hallService.saveHall(hallDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllHalls() {
        List<HallDTO> hallDTOS = hallService.getAllHall();
        return new ResponseEntity<List<HallDTO>>(hallDTOS, HttpStatus.OK);
    }

}
