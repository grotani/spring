<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>현재 접속자 : ${currentCnt}</h1>
	<h1>로그인 안 했을때</h1>
	<form method="post" action="./login">
		<div>
			id : <input type="text" name="id">
		</div>
		
		<div>
			pw : <input type="password" name="pw">
		</div>
		<button>로그인</button>
	</form>
</body>
</html>