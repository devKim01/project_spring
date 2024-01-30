package com.example.productVue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productVue.repository.BoardEntity;
import com.example.productVue.repository.BoardRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
//@RequiredArgsConstructor
@Slf4j
@Transactional
public class BoardService {
	@Autowired
	private final BoardRepository boardRepository;
	
	public BoardService(BoardRepository boardRepository) {
		System.out.println("서비스 생성자");
		this.boardRepository = boardRepository;
	}
	
	public List<BoardEntity> getBoardList() {
		System.out.println("서비스 ");
		List<BoardEntity> list = boardRepository.findAll();
		return list;
	}
//	/**
//     * 게시글 목록 가져오기
//     */
//	public List<BoardDTO> getBoardList(){
//		List<BoardEntity> boardEntities = boardRepository.findAll();
//		List<BoardDTO> dtos = new ArrayList<>();
//		
//		for(BoardEntity entity : boardEntities) {
//			BoardDTO dto = BoardDTO.builder()
//                    .idx(entity.getIdx())
//                    .author(entity.getAuthor())
//                    .title(entity.getTitle())
//                    .contents(entity.getContents())
//                    .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
//                    .build();
//
//            dtos.add(dto);
//		}
//		return dtos;
//	}
//	
//	/**
//     * 게시글 가져오기
//     */
//	public BoardDTO getBoard(Long id) {
//        BoardEntity entity = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
//        return BoardDTO.builder()
//                .idx(entity.getIdx())
//                .title(entity.getTitle())
//                .contents(entity.getContents())
//                .author(entity.getAuthor())
//                .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
//                .build();
//    }
//	
//	/**
//     * 게시글 등록
//     */
//    public BoardEntity create(BoardDTO boardDTO) {
//        BoardEntity entity = BoardEntity.builder()
//                .title(boardDTO.getTitle())
//                .contents(boardDTO.getContents())
//                .author(boardDTO.getAuthor())
//                .createdAt(LocalDateTime.now())
//                .build();
//        return boardRepository.save(entity);
//    }
//
//    /**
//     * 게시글 수정
//     */
//    public BoardEntity update(BoardDTO boardDTO) {
//        BoardEntity entity = boardRepository.findById(boardDTO.getIdx()).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
//        entity.setTitle(boardDTO.getTitle());
//        entity.setContents(boardDTO.getContents());
//        return boardRepository.save(entity);
//    }
//
//    /**
//     * 게시글 삭제
//     */
//    public void delete(Long id) {
//        BoardEntity entity = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
//        boardRepository.delete(entity);
//    }
}
