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

<body >

<div class="container">
  <h2>List Table</h2>

  <table class="table">
    <thead>
      <tr>
        <th>번호</th>
        <th>이름</th>
        <th>제목</th>
        <th>내용</th>
        <th>히트</th>
        <th>날짜</th>
      </tr>
    </thead>
    <c:forEach items="${pasingList}" var="dao">
    <tbody>
      <tr>
        <td>${dao.bId}</td>
        <td>${dao.bName}</td>
        <td>
        	<c:forEach begin="1" end="${dao.bIndent}">[re]</c:forEach>
        	<a href="content_view?bId=${dao.bId}">${dao.bTitle}</a></td>
        <td>${dao.bContent}</td>
        <td>${dao.bHit}</td>
        <td>${dao.bDate}</td>
      </tr>
	
    </tbody>
    </c:forEach>
  
    <tr>
    	<td colspan="6"><a href="write">글작성</a></td>
    
    </tr>
    
    
    <!-- 페이징 링크 걸때 링크에 대한 개념이 제대로 이해x , list말고 계속 model에서 넘어오는 변수를 설정했음
    페이징 가운데 처리   <tr class="col-sm-3 text-center">로 맞춤 -->
    <tr class="col-sm-3 text-center">
    	<td colspan="6">
			<c:if test="${pageMake.prev}">
				<a href="list${pageMake.makeQuery(pageMake.startPage-1)}"> 이전 </a>
			</c:if>
        	
        	<c:forEach begin="${pageMake.startPage}" end="${pageMake.endPage}" var="idx">
        		<a href="list${pageMake.makeQuery(idx)}">${idx}</a>
        	</c:forEach>
        	
			<c:if test="${pageMake.next && pageMake.endPage > 0}">
				<a href="list${pageMake.makeQuery(pageMake.endPage +1)}"> 다음 </a>
			</c:if>
		</td>    
    </tr>
   
  </table>
  	
</div>
	
</body>
</html>
