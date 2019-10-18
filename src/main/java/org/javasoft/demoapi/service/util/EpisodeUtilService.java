package org.javasoft.demoapi.service.util;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.javasoft.demoapi.mapper.EpisodeMapper;
import org.javasoft.demoapi.service.db.EpisodeLogDBService;
import org.javasoft.demoapi.service.rest.EpisodeRestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
public class EpisodeUtilService {

    private final EpisodeMapper episodeMapper;

    private final EpisodeLogDBService episodeLogDBService;

    private final EpisodeRestAPI episodeRestAPI;

    @Autowired
    public EpisodeUtilService(EpisodeMapper episodeMapper, EpisodeLogDBService episodeLogDBService, EpisodeRestAPI episodeRestAPI) {
        this.episodeMapper = episodeMapper;
        this.episodeLogDBService = episodeLogDBService;
        this.episodeRestAPI = episodeRestAPI;
    }

    public  void populateDB (){
        val episodeResponseListDTO = episodeRestAPI.retrieveEpisodes();
        log.info("EpisodeResponseListDTO ::::: {}" , episodeResponseListDTO.toString());
        val episodeResponseList = episodeResponseListDTO.getResults();
        val episodeLogEntityList = episodeResponseList.stream()
                .map(episodeMapper.mapEpisodeResponse)
                .collect(Collectors.toList());
        episodeLogDBService.saveEpisodeList(episodeLogEntityList);
    }
}
