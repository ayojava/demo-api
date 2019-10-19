package org.javasoft.demoapi.service.db;

import org.javasoft.demoapi.entity.CommentLogEntity;
import org.javasoft.demoapi.repository.CommentLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentLogDBService {

    private final CommentLogRepository commentLogRepository;

    @Autowired
    public CommentLogDBService(CommentLogRepository commentLogRepository) {
        this.commentLogRepository = commentLogRepository;
    }

    public List<CommentLogEntity> findAllCommentLog(){
        return commentLogRepository.findAllByOrderByCreateTimeAsc();
    }
}
