package com.abc.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{

    private ResponseType error;
    private String detailMessage;

    public CustomException(ResponseType responseType, String detailMessage){
        super(responseType.getMessage());
        this.error = responseType;
        this.detailMessage = detailMessage;
    }
}
