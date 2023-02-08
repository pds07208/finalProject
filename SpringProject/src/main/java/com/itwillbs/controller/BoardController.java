package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.BoardService;


@Controller
public class BoardController {
	//자동으로 객체생성  부모=자식
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)	
	public String write() {
		// 기본 이동방식 : 주소변경 없이 이동 
		return "board/writeForm";
	}//
	
	@RequestMapping(value = "/board/writePro", method = RequestMethod.POST)	
	public String writePro(BoardDTO dto) {
		System.out.println("BoardController writePro() ");
		// 글쓰기 메서드 호출()
		boardService.insertBoard(dto);
		// 이동방식 : 주소변경 하면서 이동 
	    // response.sendRedirect() 이동
		return "redirect:/board/list";
	}//
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)	
	public String list(Model model, HttpServletRequest request) {
		// http://localhost:8080/myweb/board/list
		// http://localhost:8080/myweb/board/list?pageNum=2
		// 한 화면에 보여줄 글 개수 설정 (10개 설정)
		int pageSize=10;
		// 현 페이지 번호 파라미터값 가져오기
		String pageNum=request.getParameter("pageNum");
		// 페이지 번호가 없으면 => "1" 설정
		if(pageNum==null){
		 	pageNum="1";
		}
		// pageNum => 정수형 currentPage
		int currentPage=Integer.parseInt(pageNum);
		// PageDTO 객체생성
		PageDTO dto=new PageDTO();
		// set 메서드 호출
		dto.setPageSize(pageSize);
		dto.setPageNum(pageNum);
		dto.setCurrentPage(currentPage);
		
		// 디비작업 메서드 호출
		// List<BoardDTO> 리턴할형 getBoardList(PageDTO dto) 메서드 정의
		// List<BoardDTO> boardList =dao.getBoardList(dto);
		List<BoardDTO> boardList=boardService.getBoardList(dto);
		
		//페이징 작업
		// 전체 게시판 글의 개수 가져오기
		// select count(*) from board  
		int count=boardService.getBoardCount();
		int pageBlock=10; 
		int startPage=(currentPage-1)/pageBlock*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		int pageCount = count/pageSize+(count%pageSize==0 ? 0 : 1);
		if(endPage > pageCount){
	 	   endPage=pageCount;
	    }
		dto.setCount(count);
		dto.setPageBlock(pageBlock);
		dto.setStartPage(startPage);
		dto.setEndPage(endPage);
		dto.setPageCount(pageCount);
		
		// model 담아서 이동
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDto", dto);
		
		// 기본 이동방식 : 주소변경 없이 이동 
		return "board/list";
	}//
	
	
	@RequestMapping(value = "/board/content", method = RequestMethod.GET)	
	public String content(HttpServletRequest request,Model model) {
		// /board/content?num=2
		int num=Integer.parseInt(request.getParameter("num"));
		// 조회수 증가
		boardService.updateReadcount(num);
		// 메서드 호출
		BoardDTO dto = boardService.getBoard(num);
		// model 데이터 담기
		model.addAttribute("dto", dto);		
		// 기본 이동방식 : 주소변경 없이 이동 
		return "board/content";
	}//
	
}//
