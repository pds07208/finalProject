<%@page import="board.BoardDAO"%>
<%@page import="board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// board/updatePro.jsp
// request 한글처리
request.setCharacterEncoding("utf-8");
// request 정보 가져오기
// num name subject content 파라미터 가져와서 변수에 저장
int num=Integer.parseInt(request.getParameter("num"));
String name=request.getParameter("name");
String subject=request.getParameter("subject");
String content=request.getParameter("content");

// BoardDTO 객체생성
BoardDTO dto=new BoardDTO();
// set메서드호출 num name subject content 저장
dto.setNum(num);
dto.setName(name);
dto.setSubject(subject);
dto.setContent(content);

// 수정작업
// BoardDAO 객체생성
BoardDAO dao=new BoardDAO();
// 리턴할형없음 updateBoard(BoardDTO 변수)메서드 정의 
// 디비작업 주소를 통해서 updateBoard(BoardDTO 주소값) 호출
dao.updateBoard(dto);
// list.jsp 이동
response.sendRedirect("list.jsp");
%>