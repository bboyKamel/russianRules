
package com.rrules.web;

import java.util.Date;

public class MessageDTO {

    public MessageDTO() {
    }
    
    String endpoint;
    String message;
    Date timestamp;

    public MessageDTO(String endpoint, String message, Date timestamp) {
        this.endpoint = endpoint;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
       
}
