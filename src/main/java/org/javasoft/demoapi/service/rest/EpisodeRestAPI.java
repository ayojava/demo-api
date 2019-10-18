package org.javasoft.demoapi.service.rest;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.javasoft.demoapi.bean.RestTemplateBean;
import org.javasoft.demoapi.payload.endpoint.episode.EpisodeResponseListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EpisodeRestAPI {

    private final RestTemplateBean<String, EpisodeResponseListDTO> restTemplateBean;

    @Autowired
    public EpisodeRestAPI(RestTemplateBean<String, EpisodeResponseListDTO> restTemplateBean) {
        this.restTemplateBean = restTemplateBean;
    }

    public EpisodeResponseListDTO retrieveEpisodes(){
        val episodeResponseListDTO = new EpisodeResponseListDTO();
        return restTemplateBean.getRequestObject("episode/?page=2" ,episodeResponseListDTO);
    }
}
