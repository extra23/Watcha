<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>POTATO::회원가입</title>
	<style>

		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
 
 		#body {position: absolute; left: 50%; top: 50%; transform: translate(-50%, -50%); -webkit-transform: translate(-50%, -50%);}
 
 		#famousLineMovieTitle {color: white; font-family: a스케치고딕; text-align: center; float: right;}
 		#famousLine {font-size: 50px;}
 		#movieTitle {font-size: 30px;}
 
 		#join * {font-family: a찐빵M;}
		#join {background-color: rgb(240, 240, 240, 0.6); text-align: center; border-radius: 15px; border: 1px solid lightgray; clear: both;}
	 	#join input, #cancelButton {height: 30px; width: calc(100% - 10%); border-radius: 3px; border-width: 0px; padding: 5px; text-align: center;}
		#createButton {background-color: rgb(65, 65, 65); color: white; cursor: pointer;}
		#cancelButton {cursor: pointer;}
		#join span {color: red; font-size: 12px;}

	</style>
</head>
<body>

	<div id="body">
	
		<div id="famousLineMovieTitle">
			<p id="famousLine">"There's no place like home."</p>
			<p id="movieTitle">- 영화 &lt;The Wizard of Oz&gt;</p>
		</div>
		
		<div id="join">
		
			<p>
				<h1>회원가입</h1>
			</p>
		
			<form action="join" method="post">
			
				<p>
					<input type="text" name="memberName" placeholder="User Name" value="${param.memberName}" autocomplete=off><br>
					<c:if test="${errors.memberName}"><span>User Name을 입력해주세요.</span></c:if>
				</p>
				
				<p>
					<input type="text" name="userId" placeholder="ID" value="${param.userId}" autocomplete=off><br>
					<c:if test="${errors.userId}"><span>ID를 입력해주세요.</span></c:if>
					<c:if test="${errors.duplicatedId}"><span>이미 등록된 ID 입니다.</span></c:if>
				</p>
				
				<p>
					<input type="password" name="password" placeholder="Password" value="${param.password}" autocomplete=off><br>
					<c:if test="${errors.password}"><span>Password를 입력해주세요.</span></c:if>
				</p>
				
				<p>
					<input type="password" name="confirmPassword" placeholder="Confirm Password" value="${param.confirmPassword}" autocomplete=off><br>
					<c:if test="${errors.confirmPassword}"><span>Password를 다시 한 번 입력해주세요.</span></c:if>
				</p>
				
				<p>
					<input type="submit" value="Create a Account" id="createButton" autocomplete=off>
				</p>
				
				<p>
					<input type="button" value="No, Thank you." id="cancelButton" onclick="location.href='login'">
				</p>
			
			</form>
		
		</div>
		
	</div>

</body>
</html>