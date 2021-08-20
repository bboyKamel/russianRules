
package com.rrules.services;

import com.rrules.model.MessageDTO;
import com.rrules.model.NewsType;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.AllArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
public class RandomMessageServiceImpl implements RandomMessageService {
    
    @Value("${news.service.url.bad}")
    String badNewsUrl;    
    
    @Value("${news.service.url.good}")
    String goodNewsUrl;  

    RestTemplate restTemplate;
 
    @Cacheable("news")
    public ResponseEntity<MessageDTO> findCorrectMessage(NewsType whichMessage){
        System.out.println("news finding");
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject log = new JSONObject();
        log.put("username", "user");
        log.put("password", "pass");

        String passLog = "{\"username\":\"user\",\"password\":\"pass\"}";
        
 
        
//        LoginCredentials log = new LoginCredentials("username", "pass");
        System.out.println(passLog);
        HttpEntity<String> request = new HttpEntity<String>(passLog/*log.toJSONString()*/, headers);
        
        restTemplate.postForEntity("http://localhost:8080/login", request, MessageDTO.class);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(RandomMessageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String serviceUrl = whichMessage.equals(NewsType.GOOD) ? goodNewsUrl : badNewsUrl;
        System.out.println(serviceUrl);
        
        MessageDTO messageDTO = restTemplate.getForObject(serviceUrl, MessageDTO.class);
        
        System.out.println(messageDTO.getMessage());
        
        return restTemplate.getForEntity(serviceUrl, MessageDTO.class);        
       
    }

}
