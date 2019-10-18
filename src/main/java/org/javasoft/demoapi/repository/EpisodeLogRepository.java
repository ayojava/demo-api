package org.javasoft.demoapi.repository;

import org.javasoft.demoapi.entity.EpisodeLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EpisodeLogRepository extends JpaRepository<EpisodeLogEntity,Long> {

    Optional<EpisodeLogEntity> findByEpisodeId(String episodeId);

}
