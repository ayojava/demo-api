package org.javasoft.demoapi.util;

import lombok.val;
import org.javasoft.demoapi.payload.client.character.CharacterRequest;

public class PayloadUtil {

    public static CharacterRequest buildValidCharacterRequest(){
        val characterRequest = new CharacterRequest();
        characterRequest.setGender("Male");
        characterRequest.setStatus("Alive");
        characterRequest.setSortGenderASC(true);
        return characterRequest;
    }

    public static CharacterRequest buildInValidCharacterRequest(){
        val characterRequest = new CharacterRequest();
        characterRequest.setGender("Age");
        characterRequest.setStatus("xxxxx");
        characterRequest.setSortGenderASC(true);
        return characterRequest;
    }
}
