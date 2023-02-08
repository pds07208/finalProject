<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/info.jsp</title>
</head>
<body>
<h1>나의 정보 조회</h1>
<%
// //String id = "id" 세션값 가져오기
// String id=(String)session.getAttribute("id");
// //MemberDAO 객체생성
// MemberDAO dao=new MemberDAO();
// // 리턴할형MemberDTO getMember(String id)
// // 메서드 정의
// // MemberDTO dto =디비작업주소.getMember(id) 메서드 호출
// MemberDTO dto=dao.getMember(id);
	%>
아이디 : ${dto.id }<br>
비밀번호 : ${dto.pass }<br>
이름 : ${dto.name }<br>
가입날짜 : ${dto.date }<br>
<a href="${pageContext.request.contextPath }/member/main">main.jsp 이동</a>
</body>
</html>



