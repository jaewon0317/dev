package com.sg.leo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class RestPractice {
	
	@RequestMapping("/hello")
	public String hello() {
		return "/hello Response, from Spring RestPractice 11월 4일";
	}

	@GetMapping("/get")
	public String get( ) {
		return "/get Response, from Spring RestPractice 11월 4일";
	}
	
	@GetMapping("/getchk/{variable}")
	public String getchk(@PathVariable String variable) {
		return "/getchk Response 11월 4일" + " variable=" + variable;
	}

	@GetMapping("/getparam")
	public String getparam(String name, String email) {
		return "/getparam name = "+ name + ", email=" + email;
	}
	
}
