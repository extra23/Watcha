<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>POTATO::로그인</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
		
		#body {position: absolute; left: 50%; top: 50%; transform: translate(-50%, -50%); -webkit-transform: translate(-50%, -50%);}
		
		#logo {text-align: center;}
		#logo img {border-radius: 100%; margin: 10px; margin-left: -5px; width: 300px;}
		
		#title {text-align: center; font-family: a스케치고딕; color: white; font-size: 180px;}
		
		#login * {font-family: a찐빵M; text-align: center;}
		#login input {height: 25px; width: 200px; border-radius: 3px; border-width: 0px; padding: 5px;}
		#loginSubmit {cursor: pointer;}
		#createSubmit {background-color: rgb(65, 65, 65); color: white; cursor: pointer;}
		
		span {color: red; font-size: 10px;}
	
	</style>
</head>
<body>
	
	<div id="body">
	
		<div id="logo">
			<img src="images/overaction.gif">
		</div>
		
		<div id="title">POTATO</div>
		
		<div id="login">
		
			<form action="login" method="post">
		
				<p>
					<input type="text" name="userId" placeholder="ID" autocomplete=off><br>
					<c:if test="${errors.userId}"><span>ID를 입력해주세요.</span></c:if>
					<c:if test="${errors.idOrPasswordNotMatch}"><span>ID가 일치하지 않습니다.</span></c:if>
				</p>
				
				<p>
					<input type="password" name="password" placeholder="Password"><br>
					<c:if test="${errors.password}"><span>Password를 입력해주세요.</span></c:if>
					<c:if test="${errors.idOrPasswordNotMatch}"><span>Password가 일치하지 않습니다.</span></c:if>
				</p>
				
				<p>
					<input type="submit" value="LOG IN" id="loginSubmit">
				</p>
				
				<p>
					<input type="submit" value="Create a Account" formaction="join" formmethod="get" id="createSubmit">
				</p>
		
			</form>
	
		</div>
		
	</div>

</body>
</html>