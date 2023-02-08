<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/content.jsp</title>
</head>
<body>
<h1>글내용</h1>
<%
// // content.jsp?num=1
// int num=Integer.parseInt(request.getParameter("num"));
// // 객체생성 기억장소 할당=> dao 기억장소 주소 저장
// BoardDAO dao=new BoardDAO();
// // 조회수 증가 readcount 1증가
// // update board set readcount=readcount+1 where num=?
// // 리턴할형없음 updateReadcount(int num)	메서드 정의
// // dao주소를 통해서  updateReadcount(num) 메서드 호출
// dao.updateReadcount(num);
// // BoardDTO 리턴할형  getBoard(int num)메서드 정의
// // dao주소를 통해서 메서드 호출 => 리턴할형 BoardDTO
// BoardDTO dto=dao.getBoard(num); 
%>
<table border="1">
<tr><td>글번호</td><td>${dto.num}</td></tr>
<tr><td>작성자</td><td>${dto.name}</td></tr>
<tr><td>등록일</td><td>${dto.date}</td></tr>
<tr><td>조회수</td><td>${dto.readcount}</td></tr>
<tr><td>제목</td><td>${dto.subject}</td></tr>
<tr><td>글내용</td><td>${dto.content}</td></tr>
<tr><td colspan="2">
<%
//세션값 가져오기
String id=(String)session.getAttribute("id");
// 글쓴이와 로그인(세션값) 일치하면 => 글수정,글삭제 버튼 보이기
// if(dto.getName().equals(id)){
	%>
<input type="button" value="글수정" 
onclick="location.href='updateForm.jsp?num=<%//=dto.getNum()%>'">
<input type="button" value="글삭제" 
onclick="location.href='delete.jsp?num=<%//=dto.getNum()%>'">	
	<%
// }
%>

<c:if test="${dto.name eq sessionScope.id }">
<input type="button" value="글수정" 
onclick="location.href='${pageContext.request.contextPath }/board/update?num=${dto.num}'">
<input type="button" value="글삭제" 
onclick="location.href='${pageContext.request.contextPath }/board/delete?num=${dto.num}'">
<input type="button" value="글목록" 
onclick="location.href='${pageContext.request.contextPath }/board/list'">

</c:if>


</td></tr>
</table>
</body>
</html>


