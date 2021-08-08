
package com.rrules.services;

import com.rrules.web.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RandomMessageService {
    
    @Value("${bad.news.service.url}")
    String badNewsUrl;
    
    @Value("${good.news.service.url}")
    String goodNewsUrl;  

    RestTemplate restTemplate;
    
    @Autowired
    RussianRouletteService rRouletteService;

    public RandomMessageService(RestTemplate restTemplate) {        
        this.restTemplate = restTemplate;
    }   

    public String randomMessage() {
        int liczba = (int)(Math.random() * 2);
        boolean random = rRouletteService.checkRussianRules(liczba != 1);
        String serviceUrl = random == true ? goodNewsUrl : badNewsUrl;
        ResponseEntity<MessageDTO> response = restTemplate
            .getForEntity(serviceUrl, MessageDTO.class);
        return response.getBody().getMessage();
    }
    
}
