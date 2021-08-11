
package com.rrules.controllers;

import com.rrules.services.RandomMessageService;
import com.rrules.services.RussianRouletteService;
import com.rrules.model.MessageDTO;
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
    
    @Value("${news.service.url.bad}")
    String badNewsUrl;
    
    @Value("${news.service.url.good}")
    String goodNewsUrl;
    
    @Autowired
    RussianRouletteService rRouletteService;
    
    @Autowired
    RandomMessageService randomMessageService;
    
    @Autowired
    RestTemplate restTemplate;
    
    @GetMapping(path = "/news", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity randomNews() {        
        String message = randomMessageService.findCorrectMessage(rRouletteService.randomSpin()).getBody().getMessage();        
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
