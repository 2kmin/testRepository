package com.abc.exception;

import com.abc.controller.dto.SlackMessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public SlackMessageResponse handleValidationException(ValidationException e) {
        log.error("[CustomExceptionHandler.handleValidationException] >>> " + e.getDetailMessage());
        return SlackMessageResponse.fail(e.getError(), e.getDetailMessage());
    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(ValidationException.class)
//    @ResponseBody
//    public ErrorResponse handleValidationException(ValidationException e){
//        log.error("[CustomExceptionHandler.handleValidationException] >>> "+e.getDetailMessage());
//        return ErrorResponse.builder()
//                .timeStamp(new Date().toString())
//                .responseType(e.getError())
//                .detailMessage(e.getDetailMessage().toString())
//                .build();
//    }

//    @ExceptionHandler(CustomException.class)
//    public CustomErrorResponse handleCustomException(CustomException e){
//        log.error("CustomException! "+e);
//
//        return CustomErrorResponse.builder()
//                .errorCode(e.getError().getCode())
//                .message(e.getMessage())
//                .detailMessage(e.getDetailMessage())
//                .build();
//    }
//
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    @ResponseBody
//    public String handleHttpMessageNotReadableException(HttpMessageNotReadableException e, final HttpServletRequest request) {
//        log.error("handleHttpMessageNotReadableException>>> "+e);
//        log.error("url: {}, message: {}", request.getRequestURI(), e.getMessage(), e);
//
//        return "파라미터명을 확인해주세요!";
//    }
}
