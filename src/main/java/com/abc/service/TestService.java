package com.abc.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {

	public String service() {
		
		System.out.println("여기는 TestService.service");
		
		return "hi im service!";
	}
}
