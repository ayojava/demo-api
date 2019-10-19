package org.javasoft.demoapi.facade;

import lombok.extern.slf4j.Slf4j;
import org.javasoft.demoapi.mapper.CommentMapper;
import org.javasoft.demoapi.payload.client.comment.CommentResponse;
import org.javasoft.demoapi.service.db.CommentLogDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CommentLogFacade {

    private final CommentLogDBService commentLogDBService;

    private final CommentMapper commentMapper;

    @Autowired
    public CommentLogFacade(CommentLogDBService commentLogDBService, CommentMapper commentMapper) {
        this.commentLogDBService = commentLogDBService;
        this.commentMapper = commentMapper;
    }

    public List<CommentResponse> findAllComments(){
        return commentLogDBService.findAllCommentLog()
                .stream()
                .map(commentMapper.mapCommentResponse)
                .collect(Collectors.toList());
    }
}
