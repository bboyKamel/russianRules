
package com.rrules.services;


public class RussianRouletteServiceImpl implements RussianRouletteService {    

    public boolean randomSpin(){
        int random = (int)(Math.random() * 6);
        return random != 1;
    }
    
}
