
package com.rrules.model;

import java.util.Date;
import lombok.Getter;

@Getter
public class MessageDTO {

    public MessageDTO() {
    }
    
    private String endpoint;
    private String message;
    private Date timestamp;

    public MessageDTO(String endpoint, String message, Date timestamp) {
        this.endpoint = endpoint;
        this.message = message;
        this.timestamp = timestamp;
    }       
}
