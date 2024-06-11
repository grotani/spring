<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
<!-- 부트스트랩 CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        padding-top: 20px;
    }
    .table-img {
        width: 100px;
        height: auto;
    }
    .pagination {
        justify-content: center;
    }
    .btn-pink {
            background-color: #FFB2D9;
            color: white;
        }
    .btn-yellow {
        background-color: #FFBB00;
        color: black;
    }
</style>
</head>
<body>
<div class="container">
    <h1 class="mb-4">Board List</h1>
    <div class="row mb-3">
        <div class="col-md-6">
            
        <div>
        	<a href="${pageContext.request.contextPath}/addBoard" class="btn btn-yellow">게시글 등록</a>
    	</div>
        </div>
        
    </div>
    <table class="table table-bordered table-hover">
        <thead class="thead-light">
            <tr>
                <th>Article No</th>
                <th>Title</th>
                <th>Content</th>
                <th>Original Name</th>
                <th>Image</th>
                <th>Create Date</th>
                <th>Update Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="a" items="${list}">
                <tr>
                    <td>${a.articleNo}</td>
                    <td>
                    	<a href="${pageContext.request.contextPath}/boardOne?articleNo=${a.articleNo}">
                   			 ${a.articleTitle}
                   		</a>
                    </td>
                    <td>${a.articleContent}</td>
                    <td>${a.originalName}</td>
                    <td>
                        <img src="${pageContext.request.contextPath}/img/${a.fileName}" class="table-img">
                    
                    </td>
                    <td>${a.createDate }</td>
                    <td>${a.updateDate }</td>
                </tr>        
            </c:forEach>
        </tbody>
    </table>
 	<div class="mb-4">
        <c:if test="${currentPage > 1}">
            <a href="${pageContext.request.contextPath}/boardList?currentPage=${currentPage-1}" class="btn btn-secondary">
                이전
            </a>
        </c:if>
        <c:if test="${currentPage < lastPage}">
            <a href="${pageContext.request.contextPath}/boardList?currentPage=${currentPage+1}" class="btn btn-secondary">
                다음
            </a>
        </c:if>
	</div>
	<div class="mb-4">
	    <form action="${pageContext.request.contextPath}/boardList" method="get" class="form-inline">
	        <input type="text" name="searchWord" class="form-control mr-2" placeholder="검색">
	        <button type="submit" class="btn btn-pink">검색</button>
	    </form>
    </div>
<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
