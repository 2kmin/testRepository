package com.abc.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.controller.dto.Info;
import com.abc.service.TestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class controller {

	private TestService testService;
	
	@RequestMapping("hi/{name}")
	public String hi(@PathVariable(value = "name") String name, @RequestBody Info info) {
		
		String msg = "안녕하세요, "+name+"님 !";
		
		System.out.println("이름 : "+info.getName());
		System.out.println("나이 : "+info.getAge());
		System.out.println("키 : "+info.getHeight());
		
		System.out.println("깃 연결 완료!");
		
		System.out.println("여기는 마스터!");
		System.out.println("여기는 feature");
		
		String serviceResponse = testService.service();
		System.out.println(">>>"+serviceResponse);
		return "hi!";
	}
}
