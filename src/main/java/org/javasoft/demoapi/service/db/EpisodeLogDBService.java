package org.javasoft.demoapi.service.db;

import lombok.val;
import org.javasoft.demoapi.DemoApiApplication;
import org.javasoft.demoapi.entity.CommentLogEntity;
import org.javasoft.demoapi.entity.EpisodeLogEntity;
import org.javasoft.demoapi.exception.DemoAPIException;
import org.javasoft.demoapi.exception.ErrorDTO;
import org.javasoft.demoapi.repository.EpisodeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.javasoft.demoapi.exception.ErrorMsg.INTERNAL_ERROR_TYPE;

@Service
public class EpisodeLogDBService {

    private final EpisodeLogRepository episodeLogRepository;

    @Autowired
    public EpisodeLogDBService(EpisodeLogRepository episodeLogRepository) {
        this.episodeLogRepository = episodeLogRepository;
    }

    public void saveEpisodeList(List<EpisodeLogEntity> episodeLogEntityList){
        episodeLogRepository.saveAll(episodeLogEntityList);
    }

    public void findEpisodeLogEntity(String episodeId , String comment , String ipAddress){
        val optionalEpisodeLogEntity = episodeLogRepository.findByEpisodeId(episodeId);
        if(optionalEpisodeLogEntity.isPresent()){
            val episodeLogEntity = optionalEpisodeLogEntity.get();
            val commentLogEntity = new CommentLogEntity();

        }else {
            throw new DemoAPIException(INTERNAL_ERROR_TYPE ,"Episode Id {" + episodeId + " } not found");
        }
    }
}
