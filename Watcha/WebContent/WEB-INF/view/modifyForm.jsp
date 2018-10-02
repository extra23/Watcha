<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>modifyForm.jsp</title>
</head>
<body>
	<h1>비밀번호 수정 페이지입니다.</h1>
	<form action="modify" method="post">
		<c:if test="${errors.samePwd}">바꾸려는 비밀번호가 현재 비밀번호와 같습니다.</c:if>
		<p>
			현재 비밀번호 <input type="password" name="oldPwd" placeholder="현재 비밀번호">
			<c:if test="${errors.oldPwd }">현재 비밀번호를 입력해주세요</c:if>
			<c:if test="${errors.wrongOldPwd }">잘못된 비밀번호 입니다.</c:if>
		</p>
		<p>
			바꿀 비밀번호 <input type="password" name="newPwd" placeholder="새로운 비밀번호">
			<c:if test="${errors.newPwd }">새로운 비밀번호를 입력해 주세요</c:if>
		</p>
		<input type="submit" value="비밀번호 변경">
	</form>
</body>
</html>