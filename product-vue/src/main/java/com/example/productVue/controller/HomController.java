package com.example.productVue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomController {
	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
}
