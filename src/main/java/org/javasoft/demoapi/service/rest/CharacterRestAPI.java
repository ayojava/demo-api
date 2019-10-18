package org.javasoft.demoapi.service.rest;


import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.javasoft.demoapi.bean.RestTemplateBean;
import org.javasoft.demoapi.payload.endpoint.character.CharacterResponseListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CharacterRestAPI {

    private final RestTemplateBean<String, CharacterResponseListDTO> restTemplateBean;

    @Autowired
    public CharacterRestAPI(RestTemplateBean<String, CharacterResponseListDTO> restTemplateBean) {
        this.restTemplateBean = restTemplateBean;
    }

    public CharacterResponseListDTO retrieveCharacters(){
        val characterResponseListDTO = new CharacterResponseListDTO();
        return restTemplateBean.getRequestObject("character/?page=3" ,characterResponseListDTO);
    }
}
