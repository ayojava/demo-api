package org.javasoft.demoapi.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.javasoft.demoapi.exception.ErrorDTO;
import org.javasoft.demoapi.facade.CharacterLogFacade;
import org.javasoft.demoapi.payload.client.character.CharacterRequest;
import org.javasoft.demoapi.payload.client.character.CharacterResponseList;
import org.javasoft.demoapi.payload.client.comment.CommentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static org.javasoft.demoapi.api.ClientAPI.LIST_CHARACTER_API;

@Slf4j
@RestController
public class DemoController {

    private final CharacterLogFacade characterLogFacade;

    public DemoController(CharacterLogFacade characterLogFacade) {
        this.characterLogFacade = characterLogFacade;
    }

    @PostMapping( LIST_CHARACTER_API)
    @ApiOperation(value = "", notes = "List Characters")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content", response = ErrorDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Internal Server EmailError", response = ErrorDTO.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public CharacterResponseList retrieveCharacterList(@RequestBody @Valid CharacterRequest characterRequest){
        return characterLogFacade.handleCharacterList(characterRequest);
    }

    public void updateComment(HttpServletRequest request, @RequestBody @Valid CommentRequest commentRequest){

    }
}
