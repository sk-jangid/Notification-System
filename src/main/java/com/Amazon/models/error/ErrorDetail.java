package com.Amazon.models.error;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/* 
 * 
Not Necessary With respect to this Project right Now 
 *
*/
@Data
public class ErrorDetail {
    
    public String message;
    public String property;
    public ErrorDetail(
            @JsonProperty("message") String message,
            @JsonProperty("property") String property) {
        this.message = message;
        this.property = property;
    }
    

}
