package com.abc.controller;

import com.abc.controller.dto.SlackMessageRequest;
import com.abc.exception.ResponseType;
import com.abc.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.abc.controller.dto.Info;
import com.abc.service.PrintService;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/test")
public class controller {

	private final PrintService printService;

	@PostMapping("/slack")
	public String sendSlackMsg(@RequestBody @Valid SlackMessageRequest slackMessageRequest,
							   BindingResult bindingResult){

		if (bindingResult.hasErrors()) {
			List<String> errorList = new ArrayList<>();
			for(ObjectError error : bindingResult.getAllErrors()){
				errorList.add(error.getDefaultMessage());
			}
			throw new ValidationException(ResponseType.WRONG_PARAMETER, errorList.toString(), slackMessageRequest.getId());
//				throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
// 				throw new CustomException(ErrorCode.WRONG_PARAMETER, bindingResult.getFieldError().getDefaultMessage());
//				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());
//				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorList.toString());
		}

		try {
			log.info(">>> REQUEST DATA : " + slackMessageRequest);

		}catch (Exception e){
			log.error("슬랙 메세지 전송 실패!");
			e.printStackTrace();
			return "FAIL";
		}
		log.error("슬랙 메세지 전송 성공!");
		return "ok";
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

		System.out.println("충돌 유발!");

		String serviceResponse = printService.service(info);
		System.out.println(">>>"+serviceResponse);
		
		return msg;
	}

	@GetMapping("/my-api")
	public ResponseEntity<String> myApi(@RequestParam("param1") String param1,
										@RequestParam("param2") String param2) {
		// 파라미터와 로직에 따라 응답을 생성
		if ("value1".equals(param1)) {
			// HttpStatus를 200이 아닌 다른 값으로 설정하고, 메시지에 원하는 값을 설정
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Invalid param1 value");
		} else {
			// 응답에 새로운 파라미터와 값을 추가하여 응답
			String result = "Result: " + param1 + " - " + param2;
			return ResponseEntity.ok().header("Custom-Header", "CustomValue").body(result);
		}
	}

}
