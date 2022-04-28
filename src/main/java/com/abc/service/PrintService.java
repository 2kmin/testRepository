package com.abc.service;

import com.abc.controller.dto.Info;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PrintService {

	public String service(Info info) {

		System.out.println(">>> PrintService");
		log.info("{}님의 정보 [나이 : {}][키 : {}]", info.getName(), info.getAge(), info.getHeight());

		log.info("마스터입니다.");

		log.info("마스터라구요");

		log.info("0428 마스터 커밋");

		log.info("0428 마스터 커밋 분기 이후");

		log.info("0428 테스트 브랜치 커밋");

		log.info("0428 마스터 커밋 분기 이후");

		log.info("conflict 해결 마스터 -> 테스트");
		
//		rebase master on to test 하면 테스트가 마스터에 리베이스됌

		log.info("여기는 expect-conflict-2");

		log.info("입니다.!");

		return "PrintService";
	}

}
