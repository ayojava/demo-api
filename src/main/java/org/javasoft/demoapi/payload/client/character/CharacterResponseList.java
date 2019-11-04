package org.javasoft.demoapi.payload.client.character;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CharacterResponseList {

    private List<CharacterResponse> characterList;

    private int count;
}
