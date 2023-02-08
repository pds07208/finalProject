package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.BoardDAO;
import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

@Service
public class BoardServiceImpl implements BoardService{
	//자동 객체생성 부모=자식
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardDTO dto) {
		// name,subject,content
		// num,readcount,date
		// num = max(num) + 1 
		if(boardDAO.getMaxNum()==null) {
			//글이 없는 경우
			dto.setNum(1);
		}else {
			//글이 있는 경우
			dto.setNum(boardDAO.getMaxNum()+1);
		}
		
		dto.setReadcount(0);
		dto.setDate(new Timestamp(System.currentTimeMillis()));
		
		//메서드 호출
		boardDAO.insertBoard(dto);
	}

	@Override
	public List<BoardDTO> getBoardList(PageDTO dto) {
		// startRow 구하기
		int startRow=(dto.getCurrentPage()-1)*dto.getPageSize()+1;
		// endRow 구하기
		int endRow=startRow+dto.getPageSize()-1;
		
		// 디비 limit startRow-1 
		dto.setStartRow(startRow-1);
		dto.setEndRow(endRow);
		
		return boardDAO.getBoardList(dto);
	}

	@Override
	public int getBoardCount() {
		return boardDAO.getBoardCount();
	}

	//조회수
	@Override
	public void updateReadcount(int num) {
		
	}
	
	// 글가져오기 메서드 호출
	@Override
	public BoardDTO getBoard(int num) {
		 
		return null;
	}

}
