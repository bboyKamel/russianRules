package com.rrules.configuration;

import com.rrules.services.RandomMessageService;
import com.rrules.services.RandomMessageServiceImpl;
import com.rrules.services.RussianRouletteService;
import com.rrules.services.RussianRouletteServiceImpl;
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
    RussianRouletteService russianRouletteService() {
        return new RussianRouletteServiceImpl();
    }
    
    @Bean
    RandomMessageService randomMessageService(RestTemplate restTemplate) {
        return new RandomMessageServiceImpl(restTemplate);
    }
    
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
}
