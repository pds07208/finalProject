<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/insertForm.jsp</title>
</head>
<body>
<h1>회원가입</h1>
<!-- http://localhost:8080/myweb/member/insert -->

<!-- 루트 /member/insertPro -->
<!-- http://localhost:8080/member/insertPro -->

<!-- 현위치  member/insertPro -->
<!-- http://localhost:8080/myweb/member/member/insertPro -->

<!-- 프로젝트명/member/insertPro -->
<!-- http://localhost:8080/myweb/member/insertPro -->
<%-- 프로젝트명 <%=request.getContextPath() %> --%>

<form action="${pageContext.request.contextPath }/member/insertPro" method="post">
아이디 : <input type="text" name="mem_id"><br>
비밀번호 : <input type="password" name="mem_pass"><br>
전화번호 : <input type="text" name="mem_phone"><br>
이름 : <input type="text" name="mem_name"><br>
닉네임 : <input type="text" name="mem_nname"><br>
이메일 : <input type=email name="mem_email"><br>
주소 : <input type="text" name="mem_address"><br>
<!-- 계좌번호 : <input type="text" name="mem_account"><br> -->
<input type="submit" value="회원가입">
</form>
</body>
</html>




