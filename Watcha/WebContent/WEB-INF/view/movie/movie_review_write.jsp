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
		
		#star-rating-outer {
			height: 39px;
		}
		
		#star-rating-inner {
			width: 0;
			overflow: hidden;
			position: relative;
			top: -46px;
			z-index: 3;
			-ms-user-select: none; 
   			-moz-user-select: -moz-none;
   			-khtml-user-select: none;
   			-webkit-user-select: none;
   			user-select: none;
		}
		
		#star-rating-inner-image {
			z-index: 3;
		}
		
	</style>
</head>
<body>

	<div id="movieReviewWrite">

		<form action="movie" method="post">

			<div id="star-rating-outer">
				<canvas id="canvas" width="205" height="39"></canvas>
				<div id="star-rating-inner">
					<img id="star-rating-inner-image" src="images/starRed.png">
				</div>
			</div>
			<input type="hidden" name="star" id="starInput" value="0">
			</p>

			<p style="text-align: center">
				<textarea rows="3" cols="85" name="review" style="font-size: 12px;">${param.review}</textarea>
			</p>

			<p>
				<input type="submit" value="리뷰등록" style="width: 47.85%; font-size: 12px;">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="초기화" style="width: 47.85%; font-size: 12px;">
			</p>

		</form>

	</div>

	<script>
		
		var widthArr = [ 21, 41, 62, 82, 103, 123, 144, 164, 184, 205 ];

		var index = 0;
		var star = 0;

		function event() {

			document.getElementById("star-rating-inner").style.width = widthArr[index]
					+ "px";

			document.getElementById("starInput").value = 0.5 * (index + 1);

			index += 1;

		}

		var context = canvas.getContext("2d");
		var img = new Image();
		img.src = "images/starGray.png";
		img.addEventListener("load", function() {
			context.drawImage(img, 0, 0);
		})

		canvas.onclick = function() {
			event();
		}

		document.getElementById("star-rating-inner").onclick = function() {
			document.getElementById("star-rating-inner").style.width = 0;
			index = 0;
			document.getElementById("starInput").value = 0;
		}
		
	</script>

</body>
</html>