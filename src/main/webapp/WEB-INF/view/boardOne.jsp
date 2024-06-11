<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardOne</title>
<!-- Bootstrap CSS 추가 -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        padding: 20px;
    }
    h1 {
        margin-bottom: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        padding: 10px;
        border: 1px solid #dee2e6;
    }
    th {
        background-color: #f8f9fa;
    }
    .btn-custom {
        margin-right: 10px;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>BoardOne</h1>
        <table class="table table-bordered">
            <tr>
                <th>articleNo</th>
                <td>${board.articleNo}</td>
            </tr>
            <tr>
                <th>articleTitle</th>
                <td>${board.articleTitle}</td>
            </tr>
            <tr>
                <th>articleContent</th>
                <td>${board.articleContent}</td>
            </tr>
            <tr>
                <th>createDate</th>
                <td>${board.createDate}</td>
            </tr>
            <tr>
                <th>updateDate</th>
                <td>${board.updateDate}</td>
            </tr>
            <tr>
                <th>fileNo</th>
                <td>${board.fileNo}</td>
            </tr>
            <tr>
                <th>fileName</th>
                <td><a href="${pageContext.request.contextPath}/img/${board.fileName}" download="${board.originalName}">${board.fileName}</a></td>
            </tr>
            <tr>
                <th>originalName</th>
                <td>${board.originalName}</td>
            </tr>
        </table>
        <div class="mb-3">
            <a href="${pageContext.request.contextPath}/removeBoard?articleNo=${board.articleNo}" class="btn btn-danger btn-custom">삭제</a>
            <a href="${pageContext.request.contextPath}/modifyBoardArticle?articleNo=${board.articleNo}" class="btn btn-secondary btn-custom">게시글 수정</a>       
            <a href="${pageContext.request.contextPath}/modifyFile?fileNo=${board.fileNo}" class="btn btn-primary">파일수정</a>
        </div>
    </div>
    <!-- Bootstrap JS 추가 (선택사항) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
