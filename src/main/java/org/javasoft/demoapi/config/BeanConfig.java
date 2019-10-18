package org.javasoft.demoapi.config;

import lombok.val;
import org.javasoft.demoapi.bean.RestTemplateBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import static org.javasoft.demoapi.api.RestAPI.EXT_API;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;
import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

@Configuration
public class BeanConfig {

    @Bean
    @Scope(value = SCOPE_PROTOTYPE, proxyMode = TARGET_CLASS)
    public RestTemplateBean restTemplateBean() {
        val restTemplateBean = new RestTemplateBean();
        restTemplateBean.setRestTemplate(new RestTemplate());
        restTemplateBean.setBaseURL(EXT_API);
        return restTemplateBean;
    }

}
