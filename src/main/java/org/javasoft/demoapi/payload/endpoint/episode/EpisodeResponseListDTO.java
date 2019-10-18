package org.javasoft.demoapi.payload.endpoint.episode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.javasoft.demoapi.payload.endpoint.InfoResponse;

import java.util.List;

@ToString
@Getter
@Setter
public class EpisodeResponseListDTO {

    private InfoResponse info;

    private List<EpisodeResponseDTO> results;
}
