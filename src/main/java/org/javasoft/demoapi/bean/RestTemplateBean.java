package org.javasoft.demoapi.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class RestTemplateBean<I,O> {

    @Getter  @Setter
    private RestTemplate restTemplate;

    @Getter @Setter
    private String baseURL;

    public O getRequestObject(String resourceURL,O output ){
        val httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        val httpResponseEntity = new HttpEntity<>(httpHeaders);
        final val responseEntity = restTemplate.exchange(baseURL + resourceURL, HttpMethod.GET, httpResponseEntity, output.getClass());
        log.info("Status Code :::: {}" , responseEntity.getStatusCode());
        log.info("Status Code Value:::: {}" , responseEntity.getStatusCodeValue());
        log.info("Status Code Name :::: {}" , responseEntity.getStatusCode().name());
        return (O) responseEntity.getBody();

    }

}
