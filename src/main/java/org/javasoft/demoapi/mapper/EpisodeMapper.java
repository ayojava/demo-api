package org.javasoft.demoapi.mapper;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.time.DateUtils;
import org.javasoft.demoapi.entity.EpisodeLogEntity;
import org.javasoft.demoapi.payload.endpoint.episode.*;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.function.Function;

@Slf4j
@Component
public class EpisodeMapper {

    public Function<EpisodeResponseDTO, EpisodeLogEntity> mapEpisodeResponse = episodeResponse -> {
        val episodeLogEntity = new EpisodeLogEntity();
        episodeLogEntity.setCharacterCount(episodeResponse.getCharacters().size());
        episodeLogEntity.setEpisodeCode(episodeResponse.getEpisode());
        episodeLogEntity.setEpisodeId(String.valueOf(episodeResponse.getId()));
        episodeLogEntity.setName(episodeResponse.getName());
        try {
            episodeLogEntity.setAirDate(DateUtils.parseDate(episodeResponse.getAir_date() ,"MMMMM dd, yyyy"));
        } catch (ParseException e) {
            log.error("Exception parsing Date ::::: {}" , e);
        }
        return episodeLogEntity;
    };
}
