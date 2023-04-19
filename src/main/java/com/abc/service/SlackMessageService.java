package com.abc.service;

import com.abc.controller.dto.SlackMessageRequest;
import com.abc.controller.dto.SlackMessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class SlackMessageService {

    private static final String DEFAULT_ICON = ":avocado:";
    private static final String URL = "https://hooks.slack.com/services/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";

    public SlackMessageResponse send(SlackMessageRequest slackMessageRequest){

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> request = new HashMap<>();
        request.put("username", slackMessageRequest.getName());
        request.put("text", slackMessageRequest.getMessage());
        request.put("icon_emoji", DEFAULT_ICON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(request);

        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.POST, entity, String.class);

        log.info(">>>> response = "+response);

        return null;
    }
}
