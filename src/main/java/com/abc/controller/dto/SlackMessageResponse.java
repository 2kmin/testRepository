package com.abc.controller.dto;

import com.abc.exception.ResponseType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SlackMessageResponse {

    private String code;
    private String message;
    private String detailMessage;

    public static SlackMessageResponse success(){
        return SlackMessageResponse.builder()
                .code(ResponseType.SUCCESS.getCode())
                .message(ResponseType.SUCCESS.getMessage())
                .build();
    }

    public static SlackMessageResponse fail(ResponseType responseType, String detailMessage){
        return SlackMessageResponse.builder()
                .code(responseType.getCode())
                .message(responseType.getMessage())
                .detailMessage(detailMessage)
                .build();
    }
}
