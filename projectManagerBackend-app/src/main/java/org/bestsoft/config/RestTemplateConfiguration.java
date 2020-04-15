package org.bestsoft.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RestTemplateConfiguration {

//    @Value("${http.connect.time.out}")
    private Integer connectionTimeOut;

//    @Value("${http.read.time.out}")
    private Integer readTimeOut;

//    @Bean
//    public RestTemplate restTemplate() {
//        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
//        httpRequestFactory.setConnectTimeout(connectionTimeOut);
//        httpRequestFactory.setReadTimeout(readTimeOut);
//        return restTemplate;
//    }
}
