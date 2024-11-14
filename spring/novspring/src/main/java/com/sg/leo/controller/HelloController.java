package com.sg.leo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

		@GetMapping("/img")
		public String img(){
			System.out.println("이미지 파일이 요청");
			return "redirect:image/dog.jpg";
		}
		
		@GetMapping("/jsp")
		public String jsp(Model model) {
			System.out.println("jsp 파일이 요청");
			model.addAttribute("username"+"이 콘텐츠 주인 고재원");
			return "hellojsp2";
		
		}
}