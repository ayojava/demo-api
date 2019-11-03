package org.javasoft.demoapi.repository;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.javasoft.demoapi.util.SortUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class CharacterLogRepositoryTest {

    @Autowired
    private CharacterLogRepository characterLogRepository;

    @Test
    public void findAll_Test(){
        val sortVal = SortUtil.handleSort(false, false, false);
        val characterLogEntityList = characterLogRepository.findAll(sortVal);
        assertThat(characterLogEntityList).isNotEmpty();
    }
}