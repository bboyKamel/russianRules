
package com.rrules.controllers;

import com.rrules.services.RandomMessageServiceImpl;
import com.rrules.services.RussianRouletteServiceImpl;
import com.rrules.web.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NewsServiceController {
    
    @Value("${bad.news.service.url}")
    String badNewsUrl;
    
    @Value("${good.news.service.url}")
    String goodNewsUrl;
    
    @Autowired
    RussianRouletteServiceImpl rRouletteService;
    
    @Autowired
    RandomMessageServiceImpl randomMessageService;
    
    @Autowired
    RestTemplate restTemplate;
    
    @GetMapping(path = "/news", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity randomNews() {        
        String message = randomMessageService.randomMessage(rRouletteService.secondRevolver());        
    return new ResponseEntity(message, HttpStatus.OK);
    }
    
    @GetMapping(path = "/news/good", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity goodNews() {        
        ResponseEntity<MessageDTO> response = restTemplate
            .getForEntity(goodNewsUrl, MessageDTO.class);        
    return new ResponseEntity(response.getBody().getMessage(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/news/bad", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity badNews() {        
        ResponseEntity<MessageDTO> response = restTemplate
            .getForEntity(badNewsUrl, MessageDTO.class);        
    return new ResponseEntity(response.getBody().getMessage(), HttpStatus.OK);
    }
}
