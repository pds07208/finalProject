<%@page import="board.BoardDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// board/writePro.jsp
// 글쓰기 폼에서 입력한 내용을 서버에 전달하면 
// 내장객체 request에 저장
// request 한글처리
request.setCharacterEncoding("utf-8");
// request name,subject,content 파라미터 가져와서 변수에 저장
String name=request.getParameter("name");
String subject=request.getParameter("subject");
String content=request.getParameter("content");

// 패키지board 파일이름BoardDTO 자바 클래스 만들기
// 멤버변수 num,name,subject,content,readcount,date
// set() get() 메서드 정의

// BoardDTO객체생성(기억장소 할당)
BoardDTO dto=new BoardDTO();
// set메서드 호출 파라미터값 저장
dto.setName(name);
dto.setSubject(subject);
dto.setContent(content);
// 현시스템 날짜시간
dto.setDate(new Timestamp(System.currentTimeMillis()));
//조회수 0 설정
dto.setReadcount(0);
// 글번호 num => BoardDAO에서 작업


// 패키지board 파일이름BoardDAO 자바 클래스 만들기
// BoardDAO 객체생성(기억장소 할당)
BoardDAO dao=new BoardDAO();
// 리턴할형 없음 insertBoard(BoardDTO 주소값 저장하는 변수) 메서드 정의 
// BoardDAO주소.insertBoard(BoardDTO 주소)메서드 호출
dao.insertBoard(dto);
//글목록
response.sendRedirect("list.jsp");
%>



