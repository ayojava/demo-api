package org.javasoft.demoapi.payload.endpoint.episode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class EpisodeResponseDTO {

    private int id;

    private String name;

    private String air_date;

    private String episode;

    private List<String> characters;

    private String url;

    private String created;

}
