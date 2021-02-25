<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<title>List</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>

<body text="center">

	<div class="container">
		<h2>Content</h2>
		<form action="${pageContext.request.contextPath}/board/modify" method="post">
			<c:forEach items="${content}" var="dao">
			<input type="hidden" name="bId" value="${dao.bId}">
			
			<table class="table">
				<tr class="row">
					<th class="col-xm-4">번호</th>
					<td class="col-xs-8">${dao.bId}</td>
				</tr>

				<tr class="row">
					<th class="col-xm-4">이름</th>
					<td class="col-xs-8"><input type="text" name="bName" value="${dao.bName}"></td>
				</tr>

				<tr class="row">
					<th class="col-xm-4">제목</th>
					<td class="col-xs-8"><input type="text" name="bTitle" value="${dao.bTitle}"></td>
				</tr>

				<tr class="row">
					<th class="col-xm-4">내용</th>
					<td class="col-xs-8"><textarea rows="10" name="bContent">${dao.bContent}</textarea></td>
				</tr>

				<tr class="row">
					<td><button type="submit" class="btn btn-outline-info">수정</button>
					<a href="${pageContext.request.contextPath}/board/list?bId=${dao.bId}" class="btn btn-outline-success" role="button">목록 보기</a> 
						<a href="${pageContext.request.contextPath}/board/delete?bId=${dao.bId}" class="btn btn-outline-success" role="button">삭제</a> 
						<a href="${pageContext.request.contextPath}/board/reply?bId=${dao.bId}" class="btn btn-outline-danger" role="button">댓글 달기</a>
					</td>
				</tr>
			

			</table>
			</c:forEach>
		</form>
	</div>

</body>
</html>
