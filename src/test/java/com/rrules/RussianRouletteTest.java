
package com.rrules;

import com.rrules.services.RussianRouletteService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RussianRouletteTest {
    
    @Autowired
    RussianRouletteService rRouletteService;
    
    @Test
    public void contextLoads() throws Exception {
	assertThat(rRouletteService).isNotNull();
    }
    
    @Test
    public void shouldChangeLastResult(){
        
        final boolean isGoodNews = true;
        final boolean russianShot = false;
        
        rRouletteService.checkRussianRules(isGoodNews);
        rRouletteService.checkRussianRules(isGoodNews);
        rRouletteService.checkRussianRules(isGoodNews);
        rRouletteService.checkRussianRules(isGoodNews);
        rRouletteService.checkRussianRules(isGoodNews);
        boolean result = rRouletteService.checkRussianRules(isGoodNews);

        assertEquals(russianShot, result);
    }
    
}
