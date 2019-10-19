package org.javasoft.demoapi.payload.client.comment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CommentResponse {

    private String comment;

    private String ipAddress;

    private String commentDate;
}
