<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify File</title>
<!-- 부트스트랩 CSS 추가 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">파일 수정</h1>
        <form action="${pageContext.request.contextPath}/modifyBoard" method="post" enctype="multipart/form-data" class="mt-4">
            <input type="hidden" name="articleNo" value="${articleNo}">
            <input type="hidden" name="fileNo" value="${fileNo}">
            <div class="form-group">
                <label for="fileName">파일 이름:</label>
                <p class="form-control-plaintext" id="fileName">${fileName}</p>
            </div>
            <div class="form-group">
                <label for="file">수정할 파일:</label>
                <input type="file" class="form-control-file" id="file" name="file">
            </div>
            <button type="submit" class="btn btn-primary">파일 수정</button>
        </form>
    </div>

    <!-- 부트스트랩과 jQuery 추가 -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
