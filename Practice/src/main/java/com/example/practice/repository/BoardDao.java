package com.example.practice.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.practice.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
    private SqlSession sqlSession;
	
    public List<BoardVo> selectBoardList() {
    	System.out.println("DAO 시작");
        List<BoardVo> boardList = sqlSession.selectList("postgres.getBoardList");
        System.out.println(boardList);
        System.out.println("DAO 끝");
        return boardList;
    }
}