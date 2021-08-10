
package com.rrules.services;

import com.rrules.web.MessageDTO;
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
    
//    @Autowired
//    RussianRouletteService rRouletteService;

//    public RandomMessageService(RestTemplate restTemplate) {        
//        this.restTemplate = restTemplate;
//    }   

    public String randomMessage(boolean russianRoulette) {        
//      boolean randomMessage = rRouletteService.checkRussianRules(firsRevolver()); 
        return findCorrectMessage(russianRoulette);
    }
    
    public String findCorrectMessage(boolean whichMessage){
        System.out.println(whichMessage);
        String serviceUrl = whichMessage ? goodNewsUrl : badNewsUrl;
        response = restTemplate.getForEntity(serviceUrl, MessageDTO.class);
        return response.getBody().getMessage();
    }

    public String getBadNewsUrl() {
        return badNewsUrl;
    }

    public void setBadNewsUrl(String badNewsUrl) {
        this.badNewsUrl = badNewsUrl;
    }

    public String getGoodNewsUrl() {
        return goodNewsUrl;
    }

    public void setGoodNewsUrl(String goodNewsUrl) {
        this.goodNewsUrl = goodNewsUrl;
    }

    public ResponseEntity<MessageDTO> getResponse() {
        return response;
    }

    public void setResponse(ResponseEntity<MessageDTO> response) {
        this.response = response;
    }
    
    

}
