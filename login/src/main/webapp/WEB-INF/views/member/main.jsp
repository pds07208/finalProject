<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/main.jsp</title>
</head>
<body>
<%
// String id=(String)session.getAttribute("id");
// // id가 null(세션값이 없으면 ) loginForm.jsp 이동
// if(id==null){
// 	response.sendRedirect("loginForm.jsp");
// }
%>
<c:if test="${empty sessionScope.id}">
	<c:redirect url="/member/login"></c:redirect>
</c:if>
<h1>메인 화면</h1>
${sessionScope.id}님 로그인 하셨습니다.
<a href="${pageContext.request.contextPath }/member/logout">로그아웃</a><br>
<a href="${pageContext.request.contextPath }/member/info">정보조회</a><br>
<a href="${pageContext.request.contextPath }/member/update">정보수정</a><br>
<a href="${pageContext.request.contextPath }/member/delete">정보삭제</a><br>
<!-- admin 사용자만 보이게 설정 
    문자열 비교 => 문자열.equals(문자열)
    id null이면 equals 사용못함-->
  <c:if test="${ !( empty sessionScope.id )}">
  	<c:if test="${ sessionScope.id eq 'admin'}">
  		<a href="${pageContext.request.contextPath }/member/list">회원목록</a><br>
  	</c:if>
  </c:if>  
<%
// if(id != null){
// 	if(id.equals("admin")){
		%>
<%-- 		<a href="${pageContext.request.contextPath }/member/list">회원목록</a><br> --%>
		<%
// 	}
// }

// if(id!=null){
	%>
<%-- <a href="${pageContext.request.contextPath }/board/write">글쓰기</a><br>	 --%>
	<%
// }
%>
<c:if test="${ !( empty sessionScope.id )}">
<a href="${pageContext.request.contextPath }/board/write">글쓰기</a><br>
</c:if>

<a href="${pageContext.request.contextPath }/board/list">글목록</a><br>
</body>
</html>

