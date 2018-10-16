<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>POTATO::회원 정보 수정</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
	
		#container {float: right; width: calc(100% - 260px); background-color: rgb(250, 250, 250); border-radius: 20px; padding: 10px; margin: 20px; margin-left: -10px; margin-right: 25px; text-align: center; min-height: 405px;}
	
		#h1 {font-family: BomBaramOTF; margin-top: 85px;}
		
		#container form * {font-family: a찐빵M;}
		#container input {text-align: center;}
		#container span {font-size: 8px; font-family: a찐빵M; color: red;}
	
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>
	
	<jsp:include page="/WEB-INF/view/layout/left.jsp" flush="false"></jsp:include>

	<div id="container">
	
		<h1 id="h1">비밀번호 수정</h1>
		
		<br>
		
		<form action="member_account_modify" method="post" name="fr">
			
			<p>
				<input type="password" name="oldPwd" placeholder="현재 비밀번호"><br>
				<c:if test="${errors.oldPwd}"><span>현재 비밀번호를 입력해주세요</span></c:if>
				<c:if test="${errors.wrongOldPwd}"><span>잘못된 비밀번호 입니다.</span></c:if>
			</p>
			
			<p>
				<input type="password" name="newPwd" placeholder="새로운 비밀번호"><br>
				<c:if test="${errors.newPwd}"><span>새로운 비밀번호를 입력해 주세요</span></c:if>
				<c:if test="${!errors.newPwd && !errors.oldPwd && errors.samePwd}"><span>바꾸려는 비밀번호가 현재 비밀번호와 같습니다.</span></c:if>
			</p>
				
			<p>
				<input type="text" name="memberName" value="${authUser.memberName}">
			
			<p>
				<input type="submit" value="비밀번호/이름 변경">
			</p>
			
		</form>
	
	</div>
	
	<script>
	
		if("${modifyFlag}" > 0){
			alert("수정되었습니다.");
		}
	
	</script>
	
</body>
</html>