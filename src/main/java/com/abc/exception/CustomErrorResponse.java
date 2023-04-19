package com.abc.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomErrorResponse{
    private int errorCode;
    private String message;
    private String detailMessage;
}