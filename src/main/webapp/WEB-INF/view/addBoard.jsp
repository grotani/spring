<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Board</title>
<!-- 부트스트랩 CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        padding-top: 20px;
    }
    .container {
        max-width: 600px;
    }
</style>
</head>
<body>
<div class="container">
    <h1 class="mb-4">Add Board</h1>
    <form action="${pageContext.request.contextPath}/addBoard" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="boardTitle">Board Title</label>
            <input type="text" class="form-control" id="boardTitle" name="boardTitle" required>
        </div>
        <div class="form-group">
            <label for="boardContent">Board Content</label>
            <textarea class="form-control" id="boardContent" name="boardContent" rows="3" required></textarea>
        </div>
        <div class="form-group">
            <label for="boardFile">Board File</label>
            <input type="file"  class="form-control-file" id="boardFile" name="boardFile" multiple="multiple">
        </div>
        <button type="submit" class="btn btn-primary">등록</button>
    </form>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
