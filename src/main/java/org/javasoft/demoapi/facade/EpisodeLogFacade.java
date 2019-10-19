package org.javasoft.demoapi.facade;

import lombok.extern.slf4j.Slf4j;
import org.javasoft.demoapi.mapper.EpisodeMapper;
import org.javasoft.demoapi.payload.client.comment.CommentRequest;
import org.javasoft.demoapi.payload.client.episode.EpisodeResponse;
import org.javasoft.demoapi.service.db.EpisodeLogDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EpisodeLogFacade {

    private final EpisodeLogDBService episodeLogDBService;

    private final EpisodeMapper episodeMapper;

    @Autowired
    public EpisodeLogFacade(EpisodeLogDBService episodeLogDBService, EpisodeMapper episodeMapper) {
        this.episodeLogDBService = episodeLogDBService;
        this.episodeMapper = episodeMapper;
    }

    public void updateEpisode(String ipAddress , CommentRequest commentRequest){
        episodeLogDBService.findEpisodeLogEntity(String.valueOf(commentRequest.getEpisodeId()) , commentRequest.getComment() , ipAddress);
    }

    public List<EpisodeResponse> listAllEpisodes(){
        return episodeLogDBService.findAllEpisodes().stream()
                .map(episodeMapper.mapEpisodeLogEntity)
                .collect(Collectors.toList());
    }
}
