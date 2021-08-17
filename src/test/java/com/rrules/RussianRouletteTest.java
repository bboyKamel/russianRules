
package com.rrules;

import com.rrules.model.NewsType;
import com.rrules.services.RussianRouletteService;
import com.rrules.services.RussianRouletteServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class RussianRouletteTest {
    
    RussianRouletteService rr = new RussianRouletteServiceImpl();
    
    @Test
    public void contextLoads() throws Exception {
	assertThat(rr).isNotNull();
    }  
    
    @Test
    public void shouldReturnCorrectTypeTest() {
        assertThat(rr.randomSpin()).isExactlyInstanceOf(NewsType.class);
    }
    
    @Test
    public void shouldReturnOneInFiveProbabilityTest() {

        int countBad = 0;
        
        for(int i=0; i < 1000; i++){
            if (rr.randomSpin().equals(NewsType.BAD)) countBad++;
        }
        
        assertTrue(countBad >= 150 && countBad <= 200);
    }

}
