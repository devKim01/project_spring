package com.example.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.practice.service.BoardService;
import com.example.practice.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/main") //
    public String getBoardList(Model model){
    	System.out.println("컨트롤러 시작");
        List<BoardVo> boardList =  boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        System.out.println("컨트롤러 끝");
        return "home"; // board.html 파일 경로매핑
    }

}
