<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	
		#gray-star {background: url("images/starGray.png") no-repeat; display: inline-block; width: 205px; height: 39px; z-index: 0;}
	
		#star-rating {position: relative; height: 39px; width: 10%; float: left;}
	
		#red-star {display: inline-block; width: 0; overflow: hidden; position: relative; top: -39px; z-index: 2;}
	
	</style>
</head>
<body>

	<div id="gray-star">
		<c:forEach begin="1" end="10" var="i">
			<div id="star-rating" onclick="resize(${i})"></div>
		</c:forEach>
		<div id="red-star" onclick="resize(0)">
			<img src="images/starRed2.png">
		</div>
	</div>
	
	<script>
	
		function resize(i){
			var per = (i) * 10;
			document.getElementById('red-star').style.width = per + '%';
		}
	
	</script>

</body>
</html>