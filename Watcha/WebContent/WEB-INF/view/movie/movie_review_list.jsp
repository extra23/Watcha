<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>movie_review_list</title>
	<style>
	
		#movieReviewList {background-color: white; margin: 20px; margin-left: -10px; margin-right: 30px; margin-top: 5px; min-width: calc(100% - 1075px); border-radius: 20px; padding: 20px; float: right;}
	
	</style>
</head>
<body>

	<div id="movieReviewList">
	
		<!--  리뷰가 없을 때 보여줄 화면-->
		<c:if test="${!reviewPage.hasReviews()}">
			<div style="text-align: center; font-family: a찐빵M;">현재 등록된 리뷰가 없습니다.</div>
		</c:if>
		
		<!-- 게시글이 있을 때 보여줄 화면 -->
		<table border="1">
			<c:forEach var="review" items="${reviewPage.reviewList}">
				<tr>
					<td>작성자 ${authUser.memberName}</td>
					<td>별점 ${review.star}</td>
				</tr>
				<tr>
					<td colspan="2">리뷰 내용: ${review.review}</td>
				</tr>
			</c:forEach>
		</table>
		
	</div>

</body>
</html>