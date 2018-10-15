<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<style>
		
		body {
			background: url("images/background2.jpg") no-repeat center center fixed;
			-webkit-background-size: cover;
			-moz-background-size: cover;
			-o-background-size: cover;
			background-size: cover;
		}
		
		#container {background-color: rgb(250, 250, 250); border-radius: 20px; width: calc(100% - 260px); float: right; padding: 30px; margin: 20px; margin-left: -10px; margin-right: 25px;}
		#container * {font-family: a찐빵M;}
		
		#review {margin: auto;}
		#review, #review tr, #review td {border: 1px solid black; border-collapse: collapse;}
		#review tr, #review td {padding: 15px;}
		#review thead {background-color: rgb(255, 153, 51); font-weight: bold; text-align: center;}
	
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
	<meta charset="UTF-8">
	<title>POTATO::리뷰 수정</title>
</head>
<body>
	
	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>

	<jsp:include page="/WEB-INF/view/layout/left.jsp" flush="false"></jsp:include>

	<div id="container">
	
		<h1>
			리뷰 수정&nbsp;&nbsp;
			<sub>
				<a href="member_review_list?pageNo=${param.pageNo}">[리뷰 목록]</a>&nbsp;&nbsp;
				<a href="member_review_delete?pageNo=${param.pageNo}&no=${param.no}">[삭제]</a>&nbsp;&nbsp;
			</sub>
		</h1>
		
		<hr>
	
		<form action="member_review_modify?no=${param.no}" method="post">

			<input type="hidden" name="no" value="${reviewData.reviewId}">

			<table id="review">
				
				<thead>
				<tr>
					<td>리뷰</td>
					<td>별점</td>
				</tr>
				</thead>

				<tbody>
				<tr>
					<td><textarea rows="5" cols="30" name="review" style="resize: none;">${review.review}</textarea></td>
					<td>
						<div id="gray-star">
							<c:forEach begin="1" end="10" var="i">
								<div id="star-rating" onclick="resize(${i})"></div>
							</c:forEach>
							<div id="red-star" onclick="resize(0)">
								<img src="images/starRed2.png">
							</div>
						</div>
						<input type="hidden" name="star" id="star-value" value="0">
					</td>
				</tr>
				</tbody>

			</table>
			
			<br>
			
			<div style="text-align: center;"><input type="submit" value="수정" onclick="modify()"></div>
		
		</form>
	
	</div>

	<script>
	
		function resize(i){
			var per = (i) * 10;
			document.getElementById('red-star').style.width = per + '%';
			document.getElementById('star-value').value = 0.5 * i;
		}
		
		var star = <c:out value="${review.star}"/>
		
		if(star == 0.5){
			document.getElementById("red-star").style.width = "10%";
		}else if(star == 1.0){
			document.getElementById("red-star").style.width = "20%";
		}else if(star == 1.5){
			document.getElementById("red-star").style.width = "30%";
		}else if(star == 2.0){
			document.getElementById("red-star").style.width = "40%";
		}else if(star == 2.5){
			document.getElementById("red-star").style.width = "50%";
		}else if(star == 3.0){
			document.getElementById("red-star").style.width = "60%";
		}else if(star == 3.5){
			document.getElementById("red-star").style.width = "70%";
		}else if(star == 4.0){
			document.getElementById("red-star").style.width = "80%";
		}else if(star == 4.5){
			document.getElementById("red-star").style.width = "90%";
		}else if(star == 5.0){
			document.getElementById("red-star").style.width = "100%";
		}
		
		function modify(){
			alert("리뷰가 수정되었습니다.");
		}
	
	</script>
	
</body>
</html>