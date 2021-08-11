
package com.rrules.web;

import java.util.Date;

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

    public String getEndpoint() {
        return endpoint;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }   
       
}
