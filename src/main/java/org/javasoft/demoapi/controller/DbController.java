package org.javasoft.demoapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.javasoft.demoapi.service.util.CharacterUtilService;
import org.javasoft.demoapi.service.util.EpisodeUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DbController {

    private final EpisodeUtilService episodeUtilService;

    private final CharacterUtilService characterUtilService;

    @Autowired
    public DbController(EpisodeUtilService episodeUtilService, CharacterUtilService characterUtilService) {
        this.episodeUtilService = episodeUtilService;
        this.characterUtilService = characterUtilService;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/populateEpisodes")
    public void saveEpisodeList(){
        log.info("Came here");
        episodeUtilService.populateDB();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/populateCharacters")
    public void saveCharacterList(){
        log.info("Came here");
        characterUtilService.populateDB();
    }
}
