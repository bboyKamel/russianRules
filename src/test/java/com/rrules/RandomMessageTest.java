
package com.rrules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import com.rrules.services.RandomMessageServiceImpl;
import com.rrules.model.MessageDTO;
import com.rrules.model.NewsType;
import com.rrules.services.RandomMessageService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.mockito.Mockito;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;

@RunWith(MockitoJUnitRunner.class)
public class RandomMessageTest {
    
    public RandomMessageService randomMessageService;   

    @Value("${news.service.url.good}")
    String goodNewsUrl;
    
    @Value("${news.service.url.bad}")
    String badNewsUrl;    
    
    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp(){
       randomMessageService = new RandomMessageServiceImpl(badNewsUrl, goodNewsUrl, restTemplate);
    }
    
    @Test
    public void contextLoads() throws Exception {
	assertNotNull(randomMessageService);
    } 

    @Test
    public void shouldReturnGoodMessage(){
        
        final String goodNews = "dobra wiadomosc";
        
        Mockito.when(restTemplate.getForEntity(goodNewsUrl, MessageDTO.class))
                .thenReturn(new ResponseEntity(new MessageDTO(null, "dobra wiadomosc", null), null, HttpStatus.OK));
        
        String goodResponse = randomMessageService.findCorrectMessage(NewsType.GOOD)
                .getBody()
                .getMessage();

        assertEquals(goodNews, goodResponse);    
    }
    
    @Test
    public void shouldReturnBadMessage(){     

        final String badNews = "ZLA WIADOMOSC";   

        Mockito.when(restTemplate.getForEntity(badNewsUrl, MessageDTO.class))
                .thenReturn(new ResponseEntity(new MessageDTO(null, "ZLA WIADOMOSC", null), null, HttpStatus.OK));                       

        String badResponse = randomMessageService.findCorrectMessage(NewsType.BAD)
                .getBody()
                .getMessage();       

        assertEquals(badNews, badResponse);    
    }

//    @Test
//    private void correctRandomize() {
        //         "{ \"endpoint\":\"url\" , \"message\":\"good\" }, \"timestamp\": null }",
//    }
}
