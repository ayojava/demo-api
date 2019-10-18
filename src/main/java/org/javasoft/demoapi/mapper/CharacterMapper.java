package org.javasoft.demoapi.mapper;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.javasoft.demoapi.entity.CharacterLogEntity;
import org.javasoft.demoapi.payload.client.character.CharacterResponse;
import org.javasoft.demoapi.payload.endpoint.character.CharacterResponseDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Slf4j
@Component
public class CharacterMapper {

    public Function<CharacterResponseDTO, CharacterLogEntity> mapCharacterResponse = characterResponse -> {
        val characterLogEntity = new CharacterLogEntity();
        characterLogEntity.setEpisodeList(characterResponse.getEpisode().size());
        characterLogEntity.setGender(characterResponse.getGender());
        characterLogEntity.setCharacterId(characterResponse.getId());
        characterLogEntity.setName(characterResponse.getName());
        characterLogEntity.setSpecies(characterResponse.getSpecies());
        characterLogEntity.setStatus(characterResponse.getStatus());
        characterLogEntity.setType(characterResponse.getType());
        return characterLogEntity;
    };

    public Function<CharacterLogEntity, CharacterResponse> mapCharacterLogEntity = characterLogEntity -> {
        val characterResponse = new CharacterResponse();
        characterResponse.setCharacterId(characterLogEntity.getCharacterId());
        characterResponse.setEntityId(characterLogEntity.getId());
        characterResponse.setEpisodeList(characterLogEntity.getEpisodeList());
        characterResponse.setCharacterId(characterLogEntity.getCharacterId());
        characterResponse.setGender(characterLogEntity.getGender());
        characterResponse.setName(characterLogEntity.getName());
        characterResponse.setSpecies(characterLogEntity.getSpecies());
        characterResponse.setStatus(characterLogEntity.getStatus());
        characterResponse.setType(characterLogEntity.getType());
        return characterResponse;
    };
}
