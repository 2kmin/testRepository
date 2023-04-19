package com.abc.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {

    private String timeStamp;
    private ResponseType responseType;
//    private List<String> detailMessage;
    private String detailMessage;
}
