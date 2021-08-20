package com.rrules.configuration;

import com.rrules.services.RandomMessageService;
import com.rrules.services.RandomMessageServiceImpl;
import com.rrules.services.RussianRouletteService;
import com.rrules.services.RussianRouletteServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableCaching
public class RussianRulesConfiguration {
    
    @Value("${news.service.url.bad}")
    String badNewsUrl;
    
    @Value("${news.service.url.good}")
    String goodNewsUrl;    
    
    @Bean
    RussianRouletteService russianRouletteService() {
        return new RussianRouletteServiceImpl();
    }
    
    @Bean
    RandomMessageService randomMessageService(RestTemplate restTemplate) {
        return new RandomMessageServiceImpl(badNewsUrl, goodNewsUrl, restTemplate);
    }
    
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
}
