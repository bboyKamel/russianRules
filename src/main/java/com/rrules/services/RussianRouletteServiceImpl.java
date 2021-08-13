
package com.rrules.services;

import com.rrules.model.NewsType;


public class RussianRouletteServiceImpl implements RussianRouletteService {    

    public NewsType randomSpin(){
        int random = (int)(Math.random() * 6);
        return random != 1 ? NewsType.GOOD : NewsType.BAD;
    }
    
}
