package org.javasoft.demoapi.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.javasoft.demoapi.exception.ErrorDTO;
import org.javasoft.demoapi.facade.CharacterLogFacade;
import org.javasoft.demoapi.facade.CommentLogFacade;
import org.javasoft.demoapi.facade.EpisodeLogFacade;
import org.javasoft.demoapi.payload.client.character.CharacterRequest;
import org.javasoft.demoapi.payload.client.character.CharacterResponseList;
import org.javasoft.demoapi.payload.client.comment.CommentRequest;
import org.javasoft.demoapi.payload.client.comment.CommentResponse;
import org.javasoft.demoapi.payload.client.episode.EpisodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.List;

import static org.javasoft.demoapi.api.ClientAPI.*;

@Slf4j
@RestController
public class DemoController {

    private final CharacterLogFacade characterLogFacade;

    private final EpisodeLogFacade episodeLogFacade;

    private final CommentLogFacade commentLogFacade;

    @Autowired
    public DemoController(CharacterLogFacade characterLogFacade, EpisodeLogFacade episodeLogFacade, CommentLogFacade commentLogFacade) {
        this.characterLogFacade = characterLogFacade;
        this.episodeLogFacade = episodeLogFacade;
        this.commentLogFacade = commentLogFacade;
    }

    @PostMapping( LIST_CHARACTER_API )
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

    @PutMapping( UPDATE_EPISODE_API )
    @ApiOperation(value = "", notes = "Update Episode with Comment")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content", response = ErrorDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Internal Server EmailError", response = ErrorDTO.class)
    })
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateComment(HttpServletRequest request, @RequestBody @Valid CommentRequest commentRequest){
        episodeLogFacade.updateEpisode(request.getLocalAddr(),commentRequest);
    }

    @GetMapping( LIST_EPISODE_API )
    @ApiOperation(value = "", notes = "List All Episodes")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content", response = ErrorDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Internal Server EmailError", response = ErrorDTO.class)
    })
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<EpisodeResponse> findAllEpisodes(){
        return episodeLogFacade.listAllEpisodes();
    }

    @GetMapping(LIST_COMMENT_API)
    @ApiOperation(value = "", notes = "List All Comments")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content", response = ErrorDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Internal Server EmailError", response = ErrorDTO.class)
    })
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<CommentResponse> findAllComments(){
        return commentLogFacade.findAllComments();
    }
}
