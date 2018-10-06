<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>movie_review.jsp</title>
	<style>
	
		#movieReview {background-color: white; margin: 20px; margin-left: -10px; margin-right: 30px; min-width: calc(100% - 1075px); border-radius: 20px; padding: 20px; float: right;}
	
	</style>
</head>
<body>

	<div id="movieReview">
		<form action="movie_review_list" method="post">
			${authUser.memberName}<br>
			<input type="number" name="star" placeholder="별점">
			<textarea rows="5" cols="30" name="review">${param.review}</textarea>
			<input type="submit" value="리뷰등록">
		</form>
	</div>
	
	<br>
	
	<%-- <div id="selectReview">
		<!--  리뷰가 없을 때 보여줄 화면-->
			<c:if test="${reviewPage.hasReviews() }">
			리뷰가 없습니다.
			</c:if>
		
		<table border="1">
		
			<!-- 게시글이 있을 때 보여줄 화면 -->
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
	
	</div> --%>

</body>
</html>