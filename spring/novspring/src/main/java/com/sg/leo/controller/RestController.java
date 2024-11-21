package com.sg.leo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.sg.leo.domain.User;
@org.springframework.web.bind.annotation.RestController

public class RestController {
	@GetMapping("/jblog")
	public User httpGet() {
		User finduser = User.builder().id(1).password("222").email("mad@b").build();
		return finduser;
		}

	@PostMapping("/jblog")
	public String httpPost(@RequestBody User user) {
		return "Post 요청 처리" + user.toString();
	}
	@PutMapping("/jblog")
	public String httpPut() {
		return "Put 요청처리";
	}
	
	@DeleteMapping("/jblog")
	public String httpDelete(@RequestParam int id) {
		return "Delete request processed id: " + id;
	}
	
}//RestController
