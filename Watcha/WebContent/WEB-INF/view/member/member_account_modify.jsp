<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>modifyForm.jsp</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
	
		#container {float: right; width: calc(100% - 260px); background-color: rgb(250, 250, 250); border-radius: 20px; padding: 10px; margin: 20px; margin-left: -10px; margin-right: 25px; text-align: center; min-height: 405px;}
	
		#h1 {font-family: BomBaramOTF; margin-top: 85px;}
		
		#container form * {font-family: a찐빵M;}
		input {text-align: center;}
		span {font-size: 10px; font-family: a찐빵M;}
	
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>
	
	<jsp:include page="/WEB-INF/view/layout/left.jsp" flush="false"></jsp:include>

	<div id="container">
	
		<h1 id="h1">비밀번호 수정</h1>
		
		<br>
		
		<form action="member_account_modify" method="post">
			
			<c:if test="${errors.samePwd}"><span>바꾸려는 비밀번호가 현재 비밀번호와 같습니다.</span></c:if>
			
			<p>
				<input type="password" name="oldPwd" placeholder="현재 비밀번호">
				<c:if test="${errors.oldPwd }">현재 비밀번호를 입력해주세요</c:if>
				<c:if test="${errors.wrongOldPwd }">잘못된 비밀번호 입니다.</c:if>
			</p>
			
			<p>
				<input type="password" name="newPwd" placeholder="새로운 비밀번호">
				<c:if test="${errors.newPwd }">새로운 비밀번호를 입력해 주세요</c:if>
			</p>
			
			<p>
				<input type="text" name="memberName" value="${authUser.memberName}">
			</p>
			
			<p>
				<input type="submit" value="비밀번호/이름 변경">
			</p>
			
		</form>
	
	</div>
	
</body>
</html>