
package com.rrules.services;

import com.rrules.model.MessageDTO;
import org.springframework.http.ResponseEntity;

public interface RandomMessageService {
    
    public ResponseEntity<MessageDTO> findCorrectMessage(boolean russianShot);    

}
