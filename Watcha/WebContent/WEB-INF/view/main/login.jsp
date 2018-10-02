<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
		
		#logo {text-align: center; margin-top: 40px;}
		#logo img {border-radius: 100%; margin: 10px; width: 300px;}
		
		#login * {font-family: a찐빵M; width: 200px; margin: auto;}
		#login {text-align: center;}
		#login input {height: 25px; width: 100%; border-radius: 3px; border-width: 0px; padding: 5px; margin: 8px;}
		#createSubmit {background-color: rgb(65, 65, 65); color: white;}
	
	</style>
</head>
<body>
	
	<div id="logo">
		<img src="images/overaction.gif" title="못찾겟어... 배고파... 맛있는거어어어어어어어어어!!!!!">
	</div>
	
	<div id="login">
	
		<form action="login" method="post">
	
			<p>
				<input type="text" name="userId" placeholder="userId">
			</p>
			
			<p>
				<input type="password" name="password" placeholder="password">
			</p>
			
			<p>
				<input type="submit" value="LOG IN" id="loginSubmit">
			</p>
			
			<p>
				<input type="submit" value="Create a Account" formaction="join" formmethod="get" id="createSubmit">
			</p>
	
		</form>
	
	</div>

</body>
</html>