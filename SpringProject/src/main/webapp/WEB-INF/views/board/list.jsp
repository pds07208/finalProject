<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/list.jsp</title>
</head>
<body>
<h1>글목록</h1>
<%
// //사용 => BoardDAO 기억장소 할당(객체생성)
// BoardDAO dao=new BoardDAO();
// // List<BoardDTO> 리턴할형 getBoardList()메서드 정의

// // 한 화면에 보여줄 글 개수 설정 (10개 설정)
// int pageSize=3;
// System.out.println("pageSize="+pageSize);
// // http://localhost:8080/JspProject/board/list.jsp
// // http://localhost:8080/JspProject/board/list.jsp?pageNum=1
// // 현 페이지 번호 파라미터값 가져오기
// String pageNum=request.getParameter("pageNum");
// // 페이지 번호가 없으면 => "1" 설정
// if(pageNum==null){
// 	pageNum="1";
// }
// System.out.println("pageNum="+pageNum);
// //pageNum => 정수형 숫자 변경
// int currentPage=Integer.parseInt(pageNum);
// // 최근글 위로 정렬(num 기준으로 내림차순)
// // 구간값 가져오기 limit 시작행, 글개수
// // select * from board order by num desc limit 1,10
// // select * from board order by num desc limit 11,10
// // select * from board order by num desc limit 21,10
// // 시작행 알고리즘(계산식)으로 구하기
// // currentPage  pageSize => startRow
// //     1           10    => (1-1)*10+1=>0*10+1=> 0+1=>1
// //     2           10    => (2-1)*10+1=>1*10+1=>10+1=>11
// //     3           10    => (3-1)*10+1=>2*10+1=>20+1=>21
// int startRow=(currentPage-1)*pageSize+1;
// System.out.println("startRow="+startRow);
// //끝행 알고리즘(계산식)으로 구하기
// // startRow  pageSize => endRow
// //     1          10   =>   1+10-1=>10
// //    11          10   =>  11+10-1=>20
// //    21          10   =>  21+10-1=>30
// int endRow=startRow+pageSize-1;
// System.out.println("endRow="+endRow);

// //dao주소를 통해서 메서드 호출
// //여러글을 저장하는 List배열변수=dao.getBoardList();
// // List<BoardDTO> boardList =dao.getBoardList();
// //여러글을 저장하는 List배열변수=dao.getBoardList(시작행,글개수);
// List<BoardDTO> boardList =dao.getBoardList(startRow,pageSize);

// // 전체 게시판 글의 개수 가져오기
// // select count(*) from board
// int count=dao.getBoardCount();
// System.out.println("count="+count);
%>
<a href="${pageContext.request.contextPath }/member/main">메인페이지</a><br>
<a href="${pageContext.request.contextPath }/board/write">글쓰기</a><br>
<table border="1">
<tr><td>번호</td><td>글쓴이</td><td>제목</td>
    <td>등록일</td><td>조회수</td></tr>
<c:forEach var="dto" items="${boardList }">
<tr><td>${dto.num}</td>
    <td>${dto.name}</td>
    <td>
    <a href="${pageContext.request.contextPath }/board/content?num=${dto.num}">
    ${dto.subject}</a>
    </td>
    <td>${dto.date}</td>
    <td>${dto.readcount}</td></tr>    	
</c:forEach>
</table>
<br>

<%
// //한 화면에 보여줄 페이지 개수 설정(10개 페이지) 
// int pageBlock=3; 
// // currentPage      pageBlock => startPage
// //    1 ~ 10(0~9)      10    =>    (0~9)/10*10+1=>0*10+1=> 0+1=> 1
// //   11 ~ 20(10~19)    10    =>  (10~19)/10*10+1=>1*10+1=>10+1=>11
// //   21 ~ 30(20~29)    10    =>  (20~29)/10*10+1=>2*10+1=>20+1=>21
// int startPage=(currentPage-1)/pageBlock*pageBlock+1;
// System.out.println("startPage="+startPage);
// // startPage pageBlock => endPage
// //     1        10     =>   10
// //     11       10     =>   20
// //     21       10     =>   30
// int endPage=startPage+pageBlock-1;
// // 글이 있는 페이지만 보이기 1~10  => 1~2
// // 전체 페이지 개수 구하기  
// // 20개 글 / 10 글개수 나머지 0 => 2 페이지 + 나머지 없으면 0 
// // 15개 글 / 10 글개수 나머지 5 => 1 페이지 + 나머지 있으면 1 
// int pageCount = count/pageSize
//                 +(count%pageSize==0 ? 0 : 1);
// System.out.println("pageCount="+pageCount);
// if(endPage > pageCount){
// 	endPage=pageCount;
// }
// System.out.println("endPage="+endPage);

// 10페이지 이전 
// if(startPage > pageBlock){
	%>
<%-- <a href="list.jsp?pageNum=<%//=startPage-pageBlock%>">[10페이지 이전] </a> --%>
	<%	
// }

// 이전 currentPage-1
// if(currentPage > 1){
	%>
<%-- 	<a href="list.jsp?pageNum=<%=currentPage-1%>">[1페이지 이전] </a> --%>
	<%
// }

// for(int i=startPage;i<=endPage;i++){
	%>
<%-- 	<a href="list.jsp?pageNum=<%//=i%>"><%//=i %></a> --%>
	<%
// }

// 다음 currentPage+1
// if(currentPage < pageCount){
	%>
<%-- 	<a href="list.jsp?pageNum=<%=currentPage+1%>">[1페이지 다음]</a> --%>
	<%
// }

//10페이지 다음 
// if(endPage < pageCount){
	%>
<%-- 	<a href="list.jsp?pageNum=<%//=startPage+pageBlock%>">[10페이지 다음]</a> --%>
	<%
// }
%>

<c:if test="${pageDto.startPage > pageDto.pageBlock }">
<a href="${pageContext.request.contextPath }/board/list?pageNum=${pageDto.startPage - pageDto.pageBlock}">[10페이지 이전] </a>
</c:if>
 
<c:forEach var="i" begin="${pageDto.startPage }" end="${pageDto.endPage }" step="1">
<a href="${pageContext.request.contextPath }/board/list?pageNum=${i}">${i}</a> 
</c:forEach>

<c:if test="${pageDto.endPage < pageDto.pageCount}">
<a href="${pageContext.request.contextPath }/board/list?pageNum=${pageDto.startPage + pageDto.pageBlock}">[10페이지 다음] </a>
</c:if>

</body>
</html>



