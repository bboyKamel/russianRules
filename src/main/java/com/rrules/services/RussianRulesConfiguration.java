package com.rrules.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RussianRulesConfiguration {
    
    @Value("${bad.news.service.url}")
    String badNewsUrl;
    
    @Value("${good.news.service.url}")
    String goodNewsUrl;    
    
    @Bean
    RussianRouletteServiceImpl russianRouletteService() {
        return new RussianRouletteServiceImpl();
    }
    
    @Bean
    RandomMessageServiceImpl randomMessageService(RestTemplate restTemplate) {
        return new RandomMessageServiceImpl(restTemplate);
    }
    
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
}
