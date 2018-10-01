<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form action="account" method="post">
<p>
	<input type="text" name="userId" value="${param.userId }" placeholder="아이디">
	<c:if test="${errors.userId }">ID를 입력하세요</c:if>
	<c:if test="${errors.duplicateId }">이미 사용중인 아이디입니다.</c:if>
</p>
<p>
	<input type="text" name="memberName" value="${param.memberName }" placeholder="이름">
	<c:if test="${errors.memberName }">이름을 입력하세요</c:if>
</p>
<p>
	<input type="password" name="password" value="${param.password }" placeholder="비밀번호">
	<c:if test="${errors.password }">비밀번호를 입력하세요</c:if>
</p>
<p>
	<input type="password" name="confirmPassword" value="${param.confirmPassword }" placeholder="비밀번호">
	<c:if test="${errors.confirmPassword }">비밀번호 확인을 입력하세요</c:if>
	<c:if test="${errors.notMatch }">비밀번호와 일치하지 않습니다</c:if>
</p>
<input type="submit" value="가입">	
</body>
</html>