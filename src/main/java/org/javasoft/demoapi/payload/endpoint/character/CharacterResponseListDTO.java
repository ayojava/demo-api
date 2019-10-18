package org.javasoft.demoapi.payload.endpoint.character;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.javasoft.demoapi.payload.endpoint.InfoResponse;

import java.util.List;

@Getter
@Setter
@ToString
public class CharacterResponseListDTO {

    private InfoResponse info;

    private List<CharacterResponseDTO> results;
}
