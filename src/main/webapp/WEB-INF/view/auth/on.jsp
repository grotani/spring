<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 했을때</h1>
	${loginUser}님 반갑습니다
	<a href="${pageContext.request.contextPath }/logout">로그아웃</a>
</body>
</html>