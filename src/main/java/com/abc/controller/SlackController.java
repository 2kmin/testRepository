package com.abc.controller;

import com.abc.controller.dto.SlackMessageRequest;
import com.abc.controller.dto.SlackMessageResponse;
import com.abc.exception.ResponseType;
import com.abc.exception.ValidationException;
import com.abc.service.SlackMessageService;
import com.abc.util.LogUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/slack")
public class SlackController {

    private final SlackMessageService slackMessageService;

    @PostMapping("/send")
    public SlackMessageResponse sendSlackMsg(@RequestBody @Valid SlackMessageRequest slackMessageRequest,
                                             BindingResult bindingResult){

        log.info("[{}] REQUEST - <{}>", LogUtil.getPrefix(), slackMessageRequest);

        if(bindingResult.hasErrors()){
            List<String> errorList = new ArrayList<>();
            for(ObjectError error : bindingResult.getAllErrors()){
                errorList.add(error.getDefaultMessage());
            }
            throw new ValidationException(ResponseType.WRONG_PARAMETER, errorList.toString(), slackMessageRequest.getId());
        }

        return slackMessageService.send(slackMessageRequest);
    }

    }
