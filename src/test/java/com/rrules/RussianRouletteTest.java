
package com.rrules;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.rrules.model.NewsType;
import com.rrules.services.RussianRouletteService;
import com.rrules.services.RussianRouletteServiceImpl;

import org.junit.Test;

public class RussianRouletteTest {
    
    RussianRouletteService rr = new RussianRouletteServiceImpl();
    
    @Test
    public void contextLoads() throws Exception {
	assertNotNull(rr);
    }  
    
//    @Test
//    public void shouldReturnCorrectTypeTest() {
//        assertSame(rr.randomSpin(), instanceOf(NewsType.class));
//    }
    
    @Test
    public void shouldReturnOneInFiveProbabilityTest() {

        int countBad = 0;
        
        for(int i=0; i < 1000; i++){
            if (rr.randomSpin().equals(NewsType.BAD)) countBad++;
        }
        
        assertTrue(countBad >= 150 && countBad <= 200);
    }

}
