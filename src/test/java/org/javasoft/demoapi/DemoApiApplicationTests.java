package org.javasoft.demoapi;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.javasoft.demoapi.payload.client.character.CharacterRequest;
import org.javasoft.demoapi.payload.client.character.CharacterResponseList;
import org.javasoft.demoapi.payload.client.episode.EpisodeResponse;
import org.javasoft.demoapi.util.PayloadUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.javasoft.demoapi.api.ClientAPI.LIST_CHARACTER_API;
import static org.javasoft.demoapi.api.ClientAPI.LIST_EPISODE_API;
import static org.javasoft.demoapi.util.PayloadUtil.buildInValidCharacterRequest;
import static org.javasoft.demoapi.util.PayloadUtil.buildValidCharacterRequest;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApiApplication.class , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApiApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private HttpHeaders httpHeaders;

    @Before
    public void init() {
        httpHeaders = new HttpHeaders();
    }
    //https://www.mkyong.com/spring-boot/spring-rest-integration-test-example/

    private String createUrlWithPort(String uri) {
        return "http://localhost:" + port  + uri;
    }

    @Test
    public void testListCharactersWithValidRequest(){
        val characterRequest = buildValidCharacterRequest();
        val characterRequestURL = createUrlWithPort(LIST_CHARACTER_API);
        val characterRequestEntity = new HttpEntity<CharacterRequest>(characterRequest, httpHeaders);

//
        val responseEntity = testRestTemplate.exchange(characterRequestURL, HttpMethod.POST,characterRequestEntity, CharacterResponseList.class);
        log.info("Status Code ::: {}" ,responseEntity.getStatusCode().value());
        log.info("Response Body :::: {}" , responseEntity.getBody().toString());
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void testListCharactersWithInValidRequest(){
        val characterRequest = buildInValidCharacterRequest();
        val characterRequestURL = createUrlWithPort(LIST_CHARACTER_API);
        val characterRequestEntity = new HttpEntity<CharacterRequest>(characterRequest, httpHeaders);

        val responseEntity = testRestTemplate.exchange(characterRequestURL, HttpMethod.POST,characterRequestEntity, CharacterResponseList.class);
        log.info("Status Code ::: {}" ,responseEntity.getStatusCode().value());
        val responseBody = responseEntity.getBody();
        log.info("Response Body :::: {}" , responseBody.toString());
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
        assertThat(responseBody.getCharacterList()).isEmpty();
    }

    @Test
    public void testListEpisodes(){
        val episodeListRequestURL = createUrlWithPort(LIST_EPISODE_API);
        val responseEntity = testRestTemplate.exchange(episodeListRequestURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<EpisodeResponse>>() {
        });
        log.info("Status Code ::: {}" ,responseEntity.getStatusCode().value());
        val responseBody = responseEntity.getBody();
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.ACCEPTED);
        assertThat(responseBody).isNotEmpty();
    }

}
