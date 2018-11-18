package ua.logos.service;

import ua.logos.domain.HallDTO;

import java.util.List;

public interface HallService {

    void saveHall(HallDTO hallDTO);

    List<HallDTO> getAllHall();

    HallDTO findHallById(Long id);

}
