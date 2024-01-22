package com.example.productorderserver.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class GetController {
	
	@GetMapping("/")
	public String getIndex(Model model) {
		String text = "9999";
		model.addAttribute("data", text);
		return "/index";
	}
	@GetMapping("/main")
	public ModelAndView getMain() {
		ModelAndView mav = new ModelAndView("/mainPage");
		String text = "12312412312";
		mav.addObject("data", text);
		return mav;
	}
}
