package org.javasoft.demoapi.service.util;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.javasoft.demoapi.mapper.CharacterMapper;
import org.javasoft.demoapi.service.db.CharacterLogDBService;
import org.javasoft.demoapi.service.rest.CharacterRestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
public class CharacterUtilService {

    private final CharacterMapper characterMapper;

    private final CharacterLogDBService characterLogDBService;

    private final CharacterRestAPI characterRestAPI;

    @Autowired
    public CharacterUtilService(CharacterMapper characterMapper, CharacterLogDBService characterLogDBService, CharacterRestAPI characterRestAPI) {
        this.characterMapper = characterMapper;
        this.characterLogDBService = characterLogDBService;
        this.characterRestAPI = characterRestAPI;
    }

    public  void populateDB (){
        val characterResponseListDTO = characterRestAPI.retrieveCharacters();
        log.info("CharacterResponseListDTO ::::: {}" , characterResponseListDTO.toString());
        val characterResponseList = characterResponseListDTO.getResults();
        val characterLogEntityList = characterResponseList.stream()
                .map(characterMapper.mapCharacterResponse)
                .collect(Collectors.toList());
        characterLogDBService.saveCharacterLogList(characterLogEntityList);
    }
}
