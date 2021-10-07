package com.abc.service;

import org.springframework.stereotype.Service;

import com.abc.controller.dto.Info;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PrintService {

	public String service(Info info) {

		System.out.println(">>> PrintService");
		log.info("{}님의 정보 [나이 : {}][키 : {}]", info.getName(), info.getAge(), info.getHeight());

		return "PrintService";
	}

}
