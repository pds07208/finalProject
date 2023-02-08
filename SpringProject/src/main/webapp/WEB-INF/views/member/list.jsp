<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/list.jsp</title>
</head>
<body>
<h1>회원목록</h1>
<c:if test="${ empty sessionScope.id }">
	<c:redirect url="/member/login"/>
</c:if>
<c:if test="${ ! empty sessionScope.id }">
	<c:if test="${ sessionScope.id ne 'admin'}">
		<c:redirect url="/member/main" />
	</c:if>
</c:if>
<%
// //세션값 가져오기
// String id=(String)session.getAttribute("id");
// if(id==null){
// 	//세션값이 없으면 => loginForm.jsp
// 	response.sendRedirect("loginForm.jsp");
// }else{
// 	//세션값이 있으면 => admin 아니면 => main.jsp
// 	if( ! (id.equals("admin")) ){
// 		response.sendRedirect("main.jsp");
// 	}
// }

// //디비작업 기능 => MemberDAO
// // 사용 => MemberDAO 기억장소 할당(객체생성)
// MemberDAO dao=new MemberDAO();
// // dao주소를 통해서 메서드 호출
// // 여러명을 저장하는 List배열변수=dao.getMemberList();
// // List memberList =dao.getMemberList();
// List<MemberDTO> memberList =dao.getMemberList();
// System.out.println("전달 받은 배열 주소 : "+memberList);

// // //5단계 : 배열저장 for (select)
%>
<table border="1">
<tr><td>아이디</td><td>비밀번호</td>
    <td>이름</td><td>가입날짜</td></tr>
    
<c:forEach var="dto" items="${memberList}">
<tr><td>${dto.id}</td>
    <td>${dto.pass}</td>
    <td>${dto.name}</td>
    <td>${dto.date}</td></tr>    	
</c:forEach>
  
</table>
<a href="${pageContext.request.contextPath }/member/main">main.jsp 이동</a>
</body>
</html>