package com.example.practice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.practice.service.BoardService;
import com.example.practice.vo.BoardVo;




@Controller // 컨트롤러를 명시하는 어노테이션
@RequestMapping("/test") // url 경로설정 //localhost:8080/test로 접근
public class TestController {
	@Autowired
    private BoardService boardService;   
	
	@GetMapping("/test") // localhostL8088/test/test로 접근
   public String getRequest(Model model){
		System.out.println("test컨트롤러 시작");
	   model.addAttribute("greeting", "Hello, world!");
	   System.out.println("test컨트롤러 끝");
       return "index"; // index.html 파일 경로매핑

  }
   
  @GetMapping(value = "/home")
  public String getBoardList(Model model){
	  System.out.println("test보드 컨트롤러 시작");
      List<BoardVo> boardList =  boardService.getBoardList();
      model.addAttribute("boardList", boardList);
      System.out.println("test보드 컨트롤러 시작");
      return "home"; // board.html 파일 경로매핑
  }
  

}