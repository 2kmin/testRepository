package com.abc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.controller.dto.Info;
import com.abc.service.PrintService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@Slf4j
public class controller {
/*
 *  1. @RequiredArgsConstructor, 변수 final 선언으로 의존성을 주입
 *   
 *  2. private TestService testService; 위에 @Autowired 로 개별로 의존성 주입
 *  
 *  3. 	public controller(TestService testService) {
 *		this.testService = testService;
 *		}
<<<<<<< HEAD
 *  
 */
	private final PrintService printService;
	

	@RequestMapping("hi/{name}")
	public String hi(@PathVariable(value = "name") String name, @RequestBody Info info) {
		
		String msg = "안녕하세요, "+name+"님 !";

		System.out.println("이름 : "+info.getName());
		System.out.println("나이 : "+info.getAge());
		System.out.println("키 : "+info.getHeight());
		
		System.out.println("깃 연결 완료!");
		
		System.out.println("여기는 마스터!");
		System.out.println("여기는 feature");

		System.out.println("충돌 유발!");

		String serviceResponse = printService.service(info);
		System.out.println(">>>"+serviceResponse);
		
		return msg;
	}
}
