<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</style>
<meta charset="UTF-8">
<title>POTATO::리뷰 수정</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>

	<jsp:include page="/WEB-INF/view/layout/left.jsp" flush="false"></jsp:include>

	<form action="member_review_modify?no=${param.no}" method="post">
		<input type="hidden" name="no" value="${reviewData.reviewId}">

		<table id="review">

				<tr>
					<td>리뷰</td>
					<td><textarea rows="5" cols="30" name="text" value="${reviewData.review}">
					</textarea></td>
				</tr>
				<tr>
					<td>별점</td>
					<td>
				<div id="gray-star">
				<c:forEach begin="1" end="10" var="i">
					<div id="star-rating" onclick="resize(${i})"></div>
				</c:forEach>
				<div id="red-star" onclick="resize(0)">
					<img src="images/starRed2.png">
				</div>
			</div>
					</td>
				</tr>

		</table>
		<input type="submit" value="수정">
	</form>

	<script>
		<c:forEach var="review" items="${reviewPage.reviewList}">
		var star = <c:out value="${review.star}"/>
		if (star == 0.5) {
			document.getElementById('star-div-0.5').style.width = "11px";
		} else if (star == 1.0) {
			document.getElementById('star-div-1.0').style.width = "21px";
		} else if (star == 1.5) {
			document.getElementById('star-div-1.5').style.width = "31px";
		} else if (star == 2.0) {
			document.getElementById('star-div-2.0').style.width = "42px";
		} else if (star == 2.5) {
			document.getElementById('star-div-2.5').style.width = "52px";
		} else if (star == 3.0) {
			document.getElementById('star-div-3.0').style.width = "62px";
		} else if (star == 3.5) {
			document.getElementById('star-div-3.5').style.width = "72px";
		} else if (star == 4.0) {
			document.getElementById('star-div-4.0').style.width = "83px";
		} else if (star == 4.5) {
			document.getElementById('star-div-4.5').style.width = "93px";
		} else if (star == 5.0) {
			document.getElementById('star-div-5.0').style.width = "103px"
		}
		</c:forEach>
	</script>
</body>
</html>