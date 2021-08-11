
package com.rrules.services;

import com.rrules.model.MessageDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RandomMessageServiceImpl implements RandomMessageService {

    public RandomMessageServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @Value("${news.service.url.bad}")
    String badNewsUrl;
    
    @Value("${news.service.url.good}")
    String goodNewsUrl;  

    RestTemplate restTemplate;
    
    ResponseEntity<MessageDTO> response; 

    public ResponseEntity<MessageDTO> findCorrectMessage(boolean whichMessage){
        String serviceUrl = whichMessage == true ? goodNewsUrl : badNewsUrl;
        response = restTemplate.getForEntity(serviceUrl, MessageDTO.class);
        return response;
    }

}
