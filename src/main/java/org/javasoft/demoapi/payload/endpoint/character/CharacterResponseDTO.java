package org.javasoft.demoapi.payload.endpoint.character;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class CharacterResponseDTO {

    private int id;

    private String name;

    private String status;

    private String species;

    private String type;

    private String gender;

    private String image;

    private UtilResponse origin;

    private UtilResponse location;

    private List<String> episode;

    private String url;

    private String created;


}

