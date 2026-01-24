package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class IndexController {
	@GetMapping("/helloHtml")
	public String testHelloHtml(Model model){
		model.addAttribute("hello", "你好");
		return "index";
	}
}
