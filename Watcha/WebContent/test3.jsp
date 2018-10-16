<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form>
		<textarea id="testText" rows="5" cols="30" onkeyup="return lengthCheck()"></textarea>
	</form>
	<div id="length"></div>
	
	<script>
	
		function lengthCheck(){
			
			var text = document.getElementById("testText").value;

			document.getElementById("length").innerHTML = text.length;
			
		}
	
	</script>

</body>
</html>