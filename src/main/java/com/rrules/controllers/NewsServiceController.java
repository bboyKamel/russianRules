
package com.rrules.controllers;

import com.rrules.services.RandomMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsServiceController {
    
    @Value("${bad.news.service.url}")
    String badNewsUrl;
    
    @Value("${good.news.service.url}")
    String goodNewsUrl;
    
    @Autowired
    RandomMessageService randomMessageService;
    
    @GetMapping(path = "/news", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity randomNews() {        
        String message = randomMessageService.randomMessage();        
    return new ResponseEntity(message, HttpStatus.OK);
    }
}
