package org.javasoft.demoapi.mapper;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.javasoft.demoapi.entity.CommentLogEntity;
import org.javasoft.demoapi.payload.client.comment.CommentResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Slf4j
@Component
public class CommentMapper {

    public Function<CommentLogEntity , CommentResponse> mapCommentResponse = commentLogEntity -> {
        val commentResponse = new CommentResponse();
        commentResponse.setComment(commentLogEntity.getComment());
        commentResponse.setCommentDate(DateFormatUtils.format(commentLogEntity.getCreateTime(),"dd-MM-yyyy"));
        commentResponse.setIpAddress(commentLogEntity.getIpAddress());
        return commentResponse;
    };
}
