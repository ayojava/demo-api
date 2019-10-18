package org.javasoft.demoapi.service.db;

import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.javasoft.demoapi.entity.CharacterLogEntity;
import org.javasoft.demoapi.payload.client.character.CharacterRequest;
import org.javasoft.demoapi.repository.CharacterLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CharacterLogDBService {

    private final CharacterLogRepository characterLogRepository;

    @Autowired
    public CharacterLogDBService(CharacterLogRepository characterLogRepository) {
        this.characterLogRepository = characterLogRepository;
    }

    public void saveCharacterLogList(List<CharacterLogEntity> characterLogEntityList){
        characterLogRepository.saveAll(characterLogEntityList);
    }

    public List<CharacterLogEntity> filter(CharacterRequest characterRequest){
        val sortParam = handleSort(characterRequest.isSortNameASC(), characterRequest.isSortGenderASC(), characterRequest.isSortSpeciesASC());
        List<CharacterLogEntity> response = null;
        if(StringUtils.isNotBlank(characterRequest.getGender()) && StringUtils.isNotBlank(characterRequest.getStatus())){
            response=  characterLogRepository.findAllByGenderOrStatus(characterRequest.getGender(),characterRequest.getStatus(),sortParam);
        }else if(StringUtils.isNotBlank(characterRequest.getGender()) && StringUtils.isBlank(characterRequest.getStatus())){
            response=  characterLogRepository.findAllByGender(characterRequest.getGender(), sortParam);
        }else if(StringUtils.isBlank(characterRequest.getGender()) && StringUtils.isNotBlank(characterRequest.getStatus())){
            response=  characterLogRepository.findAllByStatus(characterRequest.getStatus(), sortParam);
        }else{
            response=  characterLogRepository.findAll(sortParam);
        }
        return response;
    }

    private Sort handleSort(boolean sortNameASC , boolean sortGenderASC , boolean sortSpeciesASC){
        Sort genderSort = sortGenderASC ? Sort.by("gender").ascending() : Sort.by("gender").descending();
        Sort nameSort = sortNameASC ? Sort.by("name").ascending() : Sort.by("name").descending();
        Sort speciesSort = sortSpeciesASC ? Sort.by("species").ascending() : Sort.by("species").descending();
        return genderSort.and(nameSort).and(speciesSort);
    }
}
