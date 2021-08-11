
package com.rrules.services;

import com.rrules.web.MessageDTO;
import org.springframework.http.ResponseEntity;

public interface RandomMessageService {
    
    public ResponseEntity<MessageDTO> findCorrectMessage(boolean russianShot);
    
//    public ResponseEntity<MessageDTO> randomMessage(boolean russianRoulette);
}
