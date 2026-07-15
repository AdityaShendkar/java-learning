package com.exceptionhandling.productentity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private LocalDateTime timeStamp;
    private String errorMessage;
    private String errorDetails;
    private String errorCode;

    public ErrorResponse(String errorMessage,
                         String errorDetails,
                         String errorCode) {

        this.timeStamp = LocalDateTime.now();
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
        this.errorCode = errorCode;
    }


}
