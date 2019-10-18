package org.javasoft.demoapi.facade;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.javasoft.demoapi.mapper.CharacterMapper;
import org.javasoft.demoapi.payload.client.character.CharacterRequest;
import org.javasoft.demoapi.payload.client.character.CharacterResponseList;
import org.javasoft.demoapi.service.db.CharacterLogDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
public class CharacterLogFacade {

    private final CharacterLogDBService characterLogDBService;

    private final CharacterMapper characterMapper;

    @Autowired
    public CharacterLogFacade(CharacterLogDBService characterLogDBService, CharacterMapper characterMapper) {
        this.characterLogDBService = characterLogDBService;
        this.characterMapper = characterMapper;
    }

    public CharacterResponseList handleCharacterList(CharacterRequest characterRequest){
        val characterLogEntities = characterLogDBService.filter(characterRequest);
        val characterResponseList = new CharacterResponseList();
        val characterList = characterLogEntities.stream()
                .map(characterMapper.mapCharacterLogEntity)
                .collect(Collectors.toList());
        characterResponseList.setCharacterList(characterList);
        characterResponseList.setCount(characterList.size());
        return characterResponseList;
    }
}
