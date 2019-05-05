package ua.diploma.service;

import ua.diploma.domain.CommentDTO;

import java.util.List;

public interface CommentService {

    void saveComment(CommentDTO commentDTO);

    List<CommentDTO> findCommentByFilmId(Long id);
}
