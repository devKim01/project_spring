package com.example.productorderserver.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.productorderserver.dto.MemberResponseDTO;
import com.example.productorderserver.dto.MemberSaveRequestDTO;
import com.example.productorderserver.service.MemberService;
import com.example.productorderserver.validator.CheckEmailValidator;

import jakarta.validation.Valid;





@Controller
@RequestMapping("/")
public class GetController {
	private final MemberService memberService;
	private final CheckEmailValidator checkEmailValidator;
	
	@GetMapping("/")
	public String Home() {
		return "home";
	}
//	public ModelAndView getIndex() {
//		ModelAndView mav = new ModelAndView("/layout/defaultLayout");
//		System.out.println("main 호출");
//		return mav;
//	}
	
	
	@GetMapping("main")
	public ModelAndView getMain() {
		ModelAndView mav = new ModelAndView("/mainPage");
		String text = "12312412312";
		mav.addObject("data", text);
		return mav;
	}
	
	@GetMapping("login")
	public ModelAndView postMethodName() {
		//TODO: process POST request
		ModelAndView mav = new ModelAndView("/user/loginUser");
		return mav;
	}
	
	@GetMapping("members/new")
	public String createMemberForm() {
		return "member/createMemberForm";
	}
	
	@PostMapping("members/new")
	public String createMember(@Valid MemberSaveRequestDTO memberSaveRequestDTO, Errors errors, Model model) {
		//TODO: process POST request
		if(errors.hasErrors()) {
			model.addAttribute("dto", memberSaveRequestDTO);
			
			Map<String, String> validatorResult = memberService.validateHandling(errors);
			
			for(String key : validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
			}
			//회원가입페이지
			return "member/createMemberForm";
		}
		
		Long memberId = memberService.join(memberSaveRequestDTO);
		return "home";
	}
	
	/* 유효성 검증*/
	@InitBinder
	public void validatorBinder(WebDataBinder binder) {
		binder.addValidators(checkEmailValidator);
	}
	
	/* 회원 목록 */
	@GetMapping("members")
	public String members(Model model) {
		List<MemberResponseDTO> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "member/memberList";
	}
	
	
}
