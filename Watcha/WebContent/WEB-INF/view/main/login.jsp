<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	
		body {background: url("background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}

		div {text-align: center;}
		
		
	
	</style>
</head>
<body>
	
	<div>
		<img src="overaction.gif" title="못찾겟어... 배고파... 맛있는거어어어어어어어어어!!!!!">
	</div>
	
	<div>
	
		<form action="login" method="post">
	
			<p>
				<input type="text" name="userId" placeholder="userId">
			</p>
			
			<p>
				<input type="password" name="password" placeholder="password">
			</p>
			
			<p>
				<input type="submit" value="LOG IN">
			</p>
			
			<p>
				<input type="submit" value="Create a Account" formaction="join" formmethod="get">
			</p>
	
		</form>
	
	</div>

</body>
</html>