package org.javasoft.demoapi.payload.client.character;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CharacterResponse {

    private Long entityId;

    private int characterId;

    private String name;

    private String status;

    private String species;

    private String type;

    private String gender;

    private int episodeList;
}
