<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>modifyForm.jsp</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
	
		span {color: red; font-size: 10px; font-family: a찐빵M;}
	
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/layout/top.jsp"></jsp:include>

	<h1 style="color:white">비밀번호 수정 페이지입니다.</h1>
	
	<form action="modify" method="post">
		
		<c:if test="${errors.samePwd}"><span>바꾸려는 비밀번호가 현재 비밀번호와 같습니다.</span></c:if>
		
		<p>
			현재 비밀번호 <input type="password" name="oldPwd" placeholder="현재 비밀번호">
			<c:if test="${errors.oldPwd }">현재 비밀번호를 입력해주세요</c:if>
			<c:if test="${errors.wrongOldPwd }">잘못된 비밀번호 입니다.</c:if>
		</p>
		
		<p>
			바꿀 비밀번호 <input type="password" name="newPwd" placeholder="새로운 비밀번호">
			<c:if test="${errors.newPwd }">새로운 비밀번호를 입력해 주세요</c:if>
		</p>
		
		<p>
			이름 <input type="text" name="memberName" value="${authUser.memberName}">
		</p>
		
		<p>
			<input type="submit" value="비밀번호/이름 변경">
		</p>
		
	</form>
	
</body>
</html>