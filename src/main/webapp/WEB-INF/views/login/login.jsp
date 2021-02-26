
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   <title>메이페이지</title>
</head>

<body>

<h1>메인페이지</h1>

<!-- 로그인 하지 않은 모든 사용자(로그인 중인 사용자에게는 보이지 않음) -->
<sec:authorize access="isAnonymous()">
   <p><a href="<c:url value="/login/loginForm" />">로그인</a></p>
</sec:authorize>

<!-- 로그인 중인 사용자  -->
<sec:authorize access="isAuthenticated()">
   <form:form action="${pageContext.request.contextPath}/logout" method="post">
       <input type="submit" value="로그아웃" />
   </form:form>
   <p><a href="<c:url value="/loginInfo" />">로그인 정보 확인 방법3 가지</a></p>
</sec:authorize>

<sec:authorize access="hasRole('admin')" > 관리자 페이지 </sec:authorize>

<h3>
    [<a href="<c:url value="/user/userForm" />">회원가입</a>]
    <!--  c:url 절대 경로 만들어줌 <c:url value="/user/userForm" /> = ${pageContext.request.contextPath}/user/userForm -->
    [<a href="<c:url value="/user/userHome" />">유저 홈</a>]
    [<a href="<c:url value="/admin/adminHome" />">관리자 홈</a>]
</h3>
</body>
</html>