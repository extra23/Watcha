<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>movie_review.jsp</title>
	<style>

		#movieReviewWrite {
			background-color: white;
			margin: 20px;
			margin-left: -10px;
			margin-right: 30px;
			min-width: calc(100% - 1075px);
			border-radius: 20px;
			padding: 30px;
			padding-top: 20px;
			padding-bottom: 10px;
			float: right;
			z-index: 1;
		}
		
		#movieReviewWrite * {
			font-family: a찐빵M;
		}
		
		#gray-star {
			background: url("images/starGray.png") no-repeat; 
			display: inline-block; 
			width: 205px; 
			height: 39px; 
			z-index: 0;
		}
	
		#star-rating {
			position: relative; 
			height: 39px; 
			width: 10%; 
			float: left;
			display: inline-block;
		}
	
		#red-star {
			display: inline-block; 
			width: 0; 
			overflow: hidden; 
			position: relative; 
			top: -39px; 
			z-index: 2;
		}
		
		#star-value {display: inline-block;}
		
	</style>
</head>
<body>

	<div id="movieReviewWrite">

		<form action="movie?movieId=${param.movieId}" method="post">

			<div id="gray-star">
				<c:forEach begin="1" end="10" var="i">
					<div id="star-rating" onclick="resize(${i})"></div>
				</c:forEach>
				<div id="red-star" onclick="resize(0)">
					<img src="images/starRed2.png">
				</div>
			</div>
			
			<input type="hidden" name="star" id="star-value">

			<p style="text-align: center; margin-top: -28px;">
				<textarea rows="3" cols="125" name="review" style="font-size: 12px;">${param.review}</textarea>
			</p>

			<p>
				<input type="submit" value="리뷰등록" style="width: 48.5%; font-size: 12px;">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="초기화" style="width: 49%; font-size: 12px;">
			</p>

		</form>

	</div>
	
	<script>
	
		function resize(i){
			var per = (i) * 10;
			document.getElementById('red-star').style.width = per + '%';
			document.getElementById('star-value').value = 0.5 * i;
		}
	
	</script>

</body>
</html>