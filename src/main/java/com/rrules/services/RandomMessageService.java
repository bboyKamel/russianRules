
package com.rrules.services;

import com.rrules.model.MessageDTO;
import com.rrules.model.NewsType;
import org.springframework.http.ResponseEntity;

public interface RandomMessageService {
    
    public ResponseEntity<MessageDTO> findCorrectMessage(NewsType russianShot);    

}
