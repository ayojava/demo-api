package org.javasoft.demoapi.payload.client.character;

import lombok.Data;

import java.util.List;

@Data
public class CharacterResponseList {

    private List<CharacterResponse> characterList;

    private int count;
}
