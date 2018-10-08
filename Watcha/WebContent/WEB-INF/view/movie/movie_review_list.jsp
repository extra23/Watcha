<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>movie_review_list</title>
	<style>
	
		#movieReviewList {background-color: white; margin: 20px; margin-left: -10px; margin-right: 30px; margin-top: 5px; min-width: calc(100% - 1075px); border-radius: 20px; padding: 20px; float: right;}
		#movieReviewList * {font-family: a찐빵M;}
		
		table, tr, td {padding: 10px;}
		
		#star-td {padding-bottom: 16px;}
	
	</style>
</head>
<body>

	<div id="movieReviewList">
	
		<!--  리뷰가 없을 때 보여줄 화면-->
		<c:if test="${!reviewPage.hasReviews()}">
			<div style="text-align: center;">현재 등록된 리뷰가 없습니다.</div>
		</c:if>
		
		<!-- 게시글이 있을 때 보여줄 화면 -->
		<table id="movieReviewTable">
			<c:forEach var="review" items="${reviewPage.reviewList}">
				<tr>
					<td>
						${authUser.memberName}&nbsp;&nbsp;
						<div id="star-div-${review.star}" style="overflow: hidden; display: inline-block; position: relative; top: 4px;"><img src="images/starRed.png" width="102.5"></div>
					</td>
				</tr>
				<tr>
					<td colspan="2">${review.review}</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
		
		<!-- 페이지네이션 -->
		
	</div>
	
	<script>
	
		<c:forEach var="review" items="${reviewPage.reviewList}">
			var star = <c:out value="${review.star}"/>
			if(star == 0.5){
				document.getElementById('star-div-0.5').style.width = "7%";
			}else if(star == 1.0){
				document.getElementById('star-div-1.0').style.width = "13%";
			}else if(star == 1.5){
				document.getElementById('star-div-1.5').style.width = "20%";
			}else if(star == 2.0){
				document.getElementById('star-div-2.0').style.width = "26%";
			}else if(star == 2.5){
				document.getElementById('star-div-2.5').style.width = "33%";
			}else if(star == 3.0){
				document.getElementById('star-div-3.0').style.width = "39%";
			}else if(star == 3.5){
				document.getElementById('star-div-3.5').style.width = "46%";
			}else if(star == 4.0){
				document.getElementById('star-div-4.0').style.width = "52%";
			}else if(star == 4.5){
				document.getElementById('star-div-4.5').style.width = "59%";
			}else if(star == 5.0){
				document.getElementById('star-div-5.0').style.width = "64%"
			}
		</c:forEach>
	
	</script>

</body>
</html>