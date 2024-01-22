package com.shanep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 컨트롤러를 명시하는 어노테이션
@RequestMapping("/test") // url 경로설정 //localhost:8088/test로 접근
public class testcontrolller {
	
	@GetMapping("/test") // localhostL8088/test/test로 접근
   public String getRequest(Model model){
       model.addAttribute("Hello SpringBoot2342342342!!"); // 해당 경로로 요청이 들어오면 문자열 형태 그대로 반환
       return "index/index";
  }
   
   @GetMapping("/board")
   public String getBoardList(){
       return "view/board/board"; // board.html 파일 경로매핑
   }
}