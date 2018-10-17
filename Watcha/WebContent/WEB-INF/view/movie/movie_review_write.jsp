<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		
		#movieReviewWrite span {color: red; font-size: 12px;}
		
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

		<form action="movie?pageNo=${param.pageNo}&genreId=${param.genreId}&movieId=${param.movieId}&submitFlag=write" method="post">

			<div id="gray-star">
				<c:forEach begin="1" end="10" var="i">
					<div id="star-rating" onclick="resize(${i})"></div>
				</c:forEach>
				<div id="red-star" onclick="resize(0)">
					<img src="images/starRed2.png">
				</div>
			</div>
			
			<input type="hidden" name="star" id="star-value" value="0">

			<p style="text-align: center; margin-top: -28px; margin-bottom: 0;">
				<textarea rows="3" cols="125" name="review" maxlength="249" style="font-size: 12px; resize: none; margin-bottom: 0;" onkeyup="lengthCheck()">${param.review}</textarea>
				<div id="reviewLength" style="text-align: right; font-size: 12px; margin-right: 5px;">0 / 250</div>
			</p>

			<p>
				<input type="submit" value="리뷰등록" style="width: 48.5%; font-size: 12px;" onclick="return starCheck()">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="초기화" style="width: 49%; font-size: 12px;" onclick="return starReset()">
			</p>

		</form>
		
		<c:if test="${errors.review}"><span>※ review 내용을 입력해주세요.</span></c:if>

	</div>
	
	<script>
	
		function resize(i){
			var per = (i) * 10;
			document.getElementById('red-star').style.width = per + '%';
			document.getElementById('star-value').value = 0.5 * i;
		}
		
		function lengthCheck(){
			document.getElementById('reviewLength').innerHTML = document.getElementsByName('review')[0].value.length + " / 250";
		}
		
		function starCheck(){
			var star = document.getElementById('star-value').value;
			if(star == 0.0){
				if(confirm('현재 별점이 0.0점 입니다. 그대로 입력하시겠습니까?')){
					return true;
				}else {
					return false;
				}
			}
		}
		
		function starReset(){
			resize(0)
			return true;
		}
	
	</script>

</body>
</html>