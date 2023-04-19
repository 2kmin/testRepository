package com.abc.controller.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SlackMessageRequest {

    @NotNull(message = "id 누락")
    private String id;

    @NotEmpty(message = "name 누락")
    private String name;

    @NotEmpty(message = "message 누락")
    @Size(max = 10, message = "message too long!")
    private String message;
}
