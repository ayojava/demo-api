package org.javasoft.demoapi.facade;

import lombok.extern.slf4j.Slf4j;
import org.javasoft.demoapi.service.db.EpisodeLogDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EpisodeLogFacade {

    private final EpisodeLogDBService episodeLogDBService;

    @Autowired
    public EpisodeLogFacade(EpisodeLogDBService episodeLogDBService) {
        this.episodeLogDBService = episodeLogDBService;
    }


}
