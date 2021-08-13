
package com.rrules;

import com.rrules.services.RandomMessageServiceImpl;
import com.rrules.model.MessageDTO;
import com.rrules.model.NewsType;
import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class RandomMessageTest {
    
    @InjectMocks
    public RandomMessageServiceImpl randomMessageService;
    
    @Mock
    public RestTemplate restTemplate;   
    
    @Mock
    ResponseEntity<MessageDTO> responseEntity;
    
    @Test
    public void contextLoads() throws Exception {
	assertThat(randomMessageService).isNotNull();
    }    
    
    @Test
    private void correctRandomize() {
        //         "{ \"endpoint\":\"url\" , \"message\":\"good\" }, \"timestamp\": null }",
    }
    
    @Test
    public void shouldReturnGoodMessage(){
        
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<MessageDTO> goodResponseEntity = new ResponseEntity<>(
            new MessageDTO("", "dobra wiadomosc", new Date()),
            header, 
            HttpStatus.OK
        );
        
        final String goodNews = "dobra wiadomosc";
        
        randomMessageService = new RandomMessageServiceImpl(restTemplate);
       
        Mockito.when(randomMessageService.findCorrectMessage(NewsType.GOOD)).thenReturn(goodResponseEntity);
        
        String goodResponse = randomMessageService.findCorrectMessage(NewsType.GOOD).getBody().getMessage();

        assertEquals(goodNews, goodResponse);
    
    }
    
    @Test
    public void shouldReturnBadMessage(){
        
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<MessageDTO> badResponseEntity = new ResponseEntity<>(
            new MessageDTO("", "ZLA WIADOMOSC", new Date()),
            header, 
            HttpStatus.OK
        );
        
        randomMessageService = new RandomMessageServiceImpl(restTemplate);        

        final String badNews = "ZLA WIADOMOSC";   

        Mockito.when(randomMessageService.findCorrectMessage(NewsType.BAD)).thenReturn(badResponseEntity);        

        String badResponse = randomMessageService.findCorrectMessage(NewsType.BAD).getBody().getMessage();       

        assertEquals(badNews, badResponse);
    
    }

}
