
package com.rrules;

import com.rrules.services.RandomMessageService;
import com.rrules.services.RandomMessageServiceImpl;
import com.rrules.web.MessageDTO;
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
    public RandomMessageService randomMessageService;
    
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
        
    }
    
    @Test
    public void shouldReturnCorrectMessage(){
        
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        responseEntity = new ResponseEntity<>(
//         "{ \"endpoint\":\"url\" , \"message\":\"good\" }, \"timestamp\": null }",
            new MessageDTO("", "", new Date()),
            header, 
            HttpStatus.OK
        );
        
        randomMessageService = new RandomMessageServiceImpl(restTemplate);
//        randomMessageService.setGoodNewsUrl("");
//        randomMessageService.setBadNewsUrl("");
//        randomMessageService.setResponse(responseEntity);
        
        final String goodNews = "dobra wiadomosc";
        final String badNews = "ZLA WIADOMOSC";
        
        Mockito.when(randomMessageService.findCorrectMessage(true)).thenReturn(goodNews);
        Mockito.when(randomMessageService.findCorrectMessage(false)).thenReturn(badNews);
        
        String goodResponse = randomMessageService.randomMessage(true);
        String badResponse = randomMessageService.randomMessage(false);
        System.out.println(goodResponse);
        assertEquals(goodNews, goodResponse);
        assertEquals(badNews, badResponse);
    
    }

}
