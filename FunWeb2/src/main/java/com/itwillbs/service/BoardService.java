package com.itwillbs.service;

import java.util.List;

import com.itwillbs.dao.BoardDAO;

import com.itwillbs.domain.BoardDTO;

public class BoardService {

	// 리턴할 형 없음  insertBoard(BoardDTO boardDTO) 메서드 정의
	
	public void insertBoard(BoardDTO boardDTO) {
		
		//처리
		boardDTO.setReadcount(0);
		
		//BoardDAO 객체 생성
		BoardDAO boardDAO=new BoardDAO();
		
		//insertBoard 메서드 호출
		
		boardDAO.insertBoard(boardDTO);
		
		
		
	}
	
	public List<BoardDTO> getBoardList(int startRow, int pageSize){
		
		//BoardDAO 객체 생성
		BoardDAO boardDAO=new BoardDAO();
		
		//getBoardList 메서드 호출
		
		List<BoardDTO> boardList=boardDAO.getBoardList(startRow, pageSize);
		return boardList;
		
		//리턴할형 int getBoardCount() 메서드 정의 
	
	}
	
	
	public int getBoardCount() {
		BoardDAO boardDAO=new BoardDAO();
		int count=boardDAO.getBoardCount();
		
		return count;
	}
}
