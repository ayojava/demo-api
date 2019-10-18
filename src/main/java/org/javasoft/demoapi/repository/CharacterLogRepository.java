package org.javasoft.demoapi.repository;

import org.javasoft.demoapi.entity.CharacterLogEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterLogRepository extends JpaRepository<CharacterLogEntity,Long> {

    List<CharacterLogEntity> findAllByGenderOrStatus(String gender , String status ,Sort sort);

    List<CharacterLogEntity> findAllByGender(String gender  ,Sort sort);

    List<CharacterLogEntity> findAllByStatus(String status  ,Sort sort);

    List<CharacterLogEntity> findAll(Sort sort);
}
