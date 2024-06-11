<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Article</title>
<!-- Bootstrap CSS 추가 -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>게시글 수정</h1>
        <form action="${pageContext.request.contextPath}/modifyBoardArticle" method="post">
            <div class="form-group">
    	        <label for="articleNo">게시번호:</label>
    	        <input type="text"  class="form-control" name="articleNo" value="${boardArticle.articleNo}" readonly="readonly">
            </div>
            <div class="form-group">
                <label for="articleTitle">제목:</label>
                <input type="text" class="form-control"  name="articleTitle" value="${boardArticle.articleTitle}">
            </div>
            <div class="form-group">
                <label for="articleContent">내용:</label>
                <textarea class="form-control" name="articleContent" rows="5">${boardArticle.articleContent}</textarea>
            </div>
            <button type="submit" class="btn btn-primary">수정</button>
        </form>
    </div>
    <!-- Bootstrap JS 추가 (선택사항) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
