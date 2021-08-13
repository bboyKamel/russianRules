
package com.rrules.services;

import com.rrules.model.MessageDTO;
import com.rrules.model.NewsType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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
 
    public ResponseEntity<MessageDTO> findCorrectMessage(NewsType whichMessage){
        String serviceUrl = whichMessage == NewsType.GOOD ? goodNewsUrl : badNewsUrl;
        response = restTemplate.getForEntity(serviceUrl, MessageDTO.class);
        return response;
    }

}
