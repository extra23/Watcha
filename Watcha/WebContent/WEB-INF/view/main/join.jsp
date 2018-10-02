<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>

		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
 
 		#famousLineMovieTitle {float: left; color: white; font-family: a스케치고딕; position: fixed; top: 200px; left: 100px; text-align: center;}
 		#famousLine {font-size: 50px;}
 		#movieTitle {font-size: 30px;}
 
 		#join * {font-family: a찐빵M;}
		#join {background-color: rgb(240, 240, 240, 0.6); width: calc(100% - 75%); text-align: center; border-radius: 15px; border: 1px solid lightgray; padding: 20px; float: right; margin-right: 60px; margin-top: 85px;}
	 	#join input, #cancelButton {height: 30px; width: calc(100% - 10%); border-radius: 3px; border-width: 0px; padding: 5px;}
		#createButton {background-color: rgb(65, 65, 65); color: white;}

	</style>
</head>
<body>

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
				<input type="button" value="No, Thank you." id="cancelButton" onclick="location.href='login'">
			</p>
		
		</form>
	
	</div>

</body>
</html>