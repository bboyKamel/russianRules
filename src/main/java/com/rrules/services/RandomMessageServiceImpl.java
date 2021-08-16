
package com.rrules.services;

import com.rrules.model.MessageDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RandomMessageServiceImpl implements RandomMessageService {
    
    @Value("${news.service.url.bad}")
    String badNewsUrl;    
    
    @Value("${news.service.url.good}")
    String goodNewsUrl;  

    RestTemplate restTemplate;
    
    ResponseEntity<MessageDTO> response;

    public RandomMessageServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
 
    @Cacheable("news")
    public ResponseEntity<MessageDTO> findCorrectMessage(boolean whichMessage){
        System.out.println("news finding");
        String serviceUrl = whichMessage ? goodNewsUrl : badNewsUrl;
        response = restTemplate.getForEntity(serviceUrl, MessageDTO.class);
        return response;
    }

}
