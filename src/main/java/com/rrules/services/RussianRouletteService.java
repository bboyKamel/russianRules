
package com.rrules.services;


public class RussianRouletteService {

    public RussianRouletteService() {
    }
    
    boolean value = false;
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
    
}
