
package com.rrules.services;

import com.rrules.model.MessageDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RandomMessageServiceImpl implements RandomMessageService {

    public RandomMessageServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @Value("${bad.news.service.url}")
    String badNewsUrl;
    
    @Value("${good.news.service.url}")
    String goodNewsUrl;  

    RestTemplate restTemplate;
    
    ResponseEntity<MessageDTO> response; 

    public ResponseEntity<MessageDTO> findCorrectMessage(boolean whichMessage){
        String serviceUrl = whichMessage == true ? goodNewsUrl : badNewsUrl;
        response = restTemplate.getForEntity(serviceUrl, MessageDTO.class);
        return response;
    }

}
