package com.abc.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseType {

    SUCCESS("0000", "성공"),
    WRONG_PARAMETER("9000", "파라미터를 확인해주세요")
    ;

    private final String code;
    private final String message;
}
