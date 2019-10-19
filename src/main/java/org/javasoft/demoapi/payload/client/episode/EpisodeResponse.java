package org.javasoft.demoapi.payload.client.episode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.javasoft.demoapi.payload.client.comment.CommentResponse;

import java.util.List;

@ToString
@Getter
@Setter
public class EpisodeResponse {

    private String episodeId;

    private String name ;

    private String episodeDate ;

    private String episodeCode;

    private int characterCount;

    private List<CommentResponse> comments;
}
