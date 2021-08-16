
package com.rrules;

import com.rrules.services.RussianRouletteService;
import com.rrules.services.RussianRouletteServiceImpl;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class RussianRouletteTest {
    
    @Test
    public void shouldReturnOneInFiveProbabilityTest() {
        
        RussianRouletteService rr = new RussianRouletteServiceImpl();
        
        int countBad = 0;
        
        for(int i=0; i < 1000; i++){
            if (rr.randomSpin() == false) countBad++;
        }
        System.out.println(countBad);
        assertTrue(countBad >= 150 && countBad <= 200);
    }
    

}
