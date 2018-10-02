<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>

		* {font-family: a찐빵M;}

		body {background: url("background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
 
		#join {background-color: rgb(240, 240, 240, 0.6); width: calc(100% - 75%); text-align: center; border-radius: 15px; border: 1px solid lightgray; padding: 20px; position: relative; left: calc(100% - 35%); top: 90px;}
	 	#join input {height: 30px; width: calc(100% - 10%); border-radius: 3px; border-width: 0px; padding: 5px;}
		#createButton {background-color: rgb(65, 65, 65); color: white;}

	</style>
</head>
<body>

	<div id="famousLine"></div>
	
	<div id="join">
	
		<p>
			<h1>회원가입</h1>
		</p>
	
		<form action="join" method="post">
		
			<p>
				<input type="text" name="memberName" placeholder="User Name">
			</p>
			
			<p>
				<input type="text" name="userId" placeholder="ID">
			</p>
			
			<p>
				<input type="password" name="password" placeholder="Password">
			</p>
			
			<p>
				<input type="password" name="confirmPassword" placeholder="Confirm Password">
			</p>
			
			<p>
				<input type="submit" value="Create a Account" id="createButton">
			</p>
			
			<p>
				<input type="submit" value="No, Thank you." id="cancelButton" formaction="login" formmethod="get">
			</p>
		
		</form>
	
	</div>

</body>
</html>