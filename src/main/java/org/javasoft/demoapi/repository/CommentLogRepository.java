package org.javasoft.demoapi.repository;

import org.javasoft.demoapi.entity.CommentLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentLogRepository extends JpaRepository<CommentLogEntity,Long> {

    List<CommentLogEntity> findAllByOrderByCreateTimeAsc();
}
