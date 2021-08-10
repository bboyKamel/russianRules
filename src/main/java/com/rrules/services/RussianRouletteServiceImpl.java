
package com.rrules.services;


public class RussianRouletteServiceImpl implements RussianRouletteService {

    public RussianRouletteServiceImpl() {
    }
    
    boolean value = true;
    int count = 0;
    
    public boolean checkRussianRules(boolean news) {
        if(news == value) {
            count++;
        } else {
            count = 0;
            value = news;
        };
    return count >= 6 ? !news : news;
    }
    
    public boolean firsRevolver(){
        int random = (int)(Math.random() * 2);
        return random != 1;
    }
    
    public boolean secondRevolver(){
        int random = (int)(Math.random() * 6);
        return random != 1;
    }
    
}
