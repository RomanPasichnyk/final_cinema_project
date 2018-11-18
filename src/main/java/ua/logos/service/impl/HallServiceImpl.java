package ua.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.domain.HallDTO;
import ua.logos.entity.HallEntity;
import ua.logos.repository.HallRepository;
import ua.logos.service.HallService;
import ua.logos.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void saveHall(HallDTO hallDTO) {
        HallEntity hallEntity = modelMapper.map(hallDTO, HallEntity.class);
        hallRepository.save(hallEntity);
    }

    @Override
    public List<HallDTO> getAllHall() {
        List<HallEntity> hallEntities = hallRepository.findAll();
        List<HallDTO> hallDTOS = modelMapper.mapAll(hallEntities, HallDTO.class);
        return hallDTOS;
    }

    @Override
    public HallDTO findHallById(Long id) {
        HallEntity hallEntity = hallRepository.findById(id).get();
        HallDTO hallDTO = modelMapper.map(hallEntity, HallDTO.class);
        return hallDTO;
    }
}
