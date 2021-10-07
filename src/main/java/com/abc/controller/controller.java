package com.abc.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.controller.dto.Info;
import com.abc.service.PrintService;


@RestController
//@RequiredArgsConstructor
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
	private TestService testService;
=======
 */
	private final PrintService printService;
>>>>>>> ff0106d (PrintService 생성)
	
	public controller(TestService testService) {
		this.testService = testService;
	}

	@RequestMapping("hi/{name}")
	public String hi(@PathVariable(value = "name") String name, @RequestBody Info info) {
		
		String msg = "안녕하세요, "+name+"님 !";
		
		System.out.println("이름 : "+info.getName());
		System.out.println("나이 : "+info.getAge());
		System.out.println("키 : "+info.getHeight());
		
		System.out.println("깃 연결 완료!");
		
		System.out.println("여기는 마스터!");
		System.out.println("여기는 feature");
		
<<<<<<< HEAD
=======
		String serviceResponse = printService.service(info);
		System.out.println(">>>"+serviceResponse);
		
>>>>>>> ff0106d (PrintService 생성)
		return msg;
	}
}
