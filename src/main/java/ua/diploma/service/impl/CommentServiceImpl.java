package ua.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.diploma.entity.CommentEntity;
import ua.diploma.service.CommentService;
import ua.diploma.utils.ObjectMapperUtils;
import ua.diploma.domain.CommentDTO;
import ua.diploma.repository.CommentRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void saveComment(CommentDTO commentDTO) {
        CommentEntity commentEntity = modelMapper.map(commentDTO, CommentEntity.class);
        commentRepository.save(commentEntity);
    }

    @Override
    public List<CommentDTO> findCommentByFilmId(Long id) {
        List<CommentEntity> commentEntity = commentRepository.findByFilmId(id);
        List<CommentDTO> commentDTOS = modelMapper.mapAll(commentEntity, CommentDTO.class);
        return commentDTOS;
    }
}
