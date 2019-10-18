package org.javasoft.demoapi.payload.client.character;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CharacterRequest {

    private String gender;

    private String status;

    private boolean sortNameASC ;

    private boolean sortGenderASC ;

    private boolean sortSpeciesASC ;
}
