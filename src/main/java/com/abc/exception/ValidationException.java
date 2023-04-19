package com.abc.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@Getter
@Slf4j
public class ValidationException extends RuntimeException{

    private ResponseType error;
    private String detailMessage;

    public ValidationException(String message){
        super(message);
    }

    public ValidationException(ResponseType error, String detailMessage, String id) {
        this.error = error;
        this.detailMessage = detailMessage;
        log.error("[ValidationException] {} has validation exceptions", id);
    }
}
