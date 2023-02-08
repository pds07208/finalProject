package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

public interface BoardService {
	//추상메서드 
	// 리턴할형 없음 insertBoard(BoardDTO 주소값 저장하는 변수) 메서드 정의
	public void insertBoard(BoardDTO dto);
	
	// List<BoardDTO> 리턴할형 getBoardList(PageDTO dto) 메서드 정의
	public List<BoardDTO> getBoardList(PageDTO dto);
	
//	int count=boardService.getBoardCount();
	public int getBoardCount();

	public void updateReadcount(int num);

	public BoardDTO getBoard(int num);

	
	
}
