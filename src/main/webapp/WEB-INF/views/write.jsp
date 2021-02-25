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
		<h2>Write</h2>
		<form action="${pageContext.request.contextPath}/board/write_add"
			method="post">

			<table class="table">

				<tr class="row">
					<th class="col-xm-4">이름</th>
					<td class="col-xs-8"><input type="text" name="bName"></td>
				</tr>

				<tr class="row">
					<th class="col-xm-4">제목</th>
					<td class="col-xs-8"><input type="text" name="bTitle"></td>
				</tr>

				<tr class="row">
					<th class="col-xm-4">내용</th>
					<td class="col-xs-8"><textarea rows="10" name="bContent"></textarea></td>
				</tr>
			
				<tr class="row">
					<td><button type="submit" class="btn btn-outline-info">작성</button></td>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>
