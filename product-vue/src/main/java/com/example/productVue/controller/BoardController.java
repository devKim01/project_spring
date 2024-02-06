package com.example.productVue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.productVue.dto.BoardDTO;
import com.example.productVue.repository.BoardEntity;
import com.example.productVue.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Controller
//@RequiredArgsConstructor
@AllArgsConstructor 
@Slf4j
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/board/list")
	@CrossOrigin(origins = "http://localhost:8081/")
	public List<BoardDTO> boardList() {
		System.out.println(boardService.getBoardList().get(0).toString());
		return boardService.getBoardList();	
	}
	
//	@GetMapping("/board/list")
//	@CrossOrigin(origins = "http://localhost:8081/")
//	public List<BoardEntity> boardList() {
//		System.out.println("controller 시작");
//		System.out.println(boardService.getBoardList().get(0).toString());
//		System.out.println("controller 끝");
////		System.out.println(boardService.getBoardList().get(1).toString());
////		System.out.println(boardService.getBoardList().get(2).toString());
//		return boardService.getBoardList();	}
	
//	@GetMapping("/board/{id}")
//	public BoardDTO getBoard(@PathVariable Long id) {
//		return boardService.getBoard(id);
//	}
//	
//	@PostMapping("/board")
//    public BoardEntity create(@RequestBody BoardDTO boardDTO) {
//        return boardService.create(boardDTO);
//    }
//
//    @PatchMapping("/board")
//    public BoardEntity update(@RequestBody BoardDTO boardDTO) {
//        return boardService.update(boardDTO);
//    }
//
//    @DeleteMapping("/board/{id}")
//    public void delete(@PathVariable Long id) {
//        boardService.delete(id);
//    }

}
