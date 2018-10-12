<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_review!!d!!</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}

		#memberReviewList {background-color: rgb(250, 250, 250); border-radius: 20px; width: calc(100% - 260px); float: right; padding: 30px; margin: 20px; margin-left: -10px; margin-right: 25px;}
		#memberReviewList * {font-family: a찐빵M;}

		#review{width: 100%; margin: auto;}
		#review, #review tr, th, td {border: 1px solid black; border-collapse: collapse;}
		#review td, #review th, #review tr {padding: 10px; text-align: center;}
		#review thead {background-color: rgb(255, 153, 51);}
		
		#star-td {
			padding-bottom: 16px;
		}

		#star {
			font-size: 10px;
			color: rgb(255, 0, 128);
		}

		
	</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>
	
	<jsp:include page="/WEB-INF/view/layout/left.jsp" flush="false"></jsp:include>

	<div id="memberReviewList">

		<!--  리뷰가 없을 때 보여줄 화면-->
		<c:if test="${!reviewPage.hasReviews()}">
			<div style="text-align: center;">현재 등록된 리뷰가 없습니다.</div>
		</c:if>

		<!-- 게시글이 있을 때 보여줄 화면 -->
		<table id="review">

<%-- 			<colgroup>
				<col width="20%"/>
				<col width="*"/>
				<col width="5%"/>
				<col width="10"/>
				<col width="10"/>
				<col width="10"/>
			</colgroup> --%>
			
			<thead>		
				<tr>
					<th>영화</th>
					<th>리뷰</th>
					<th>별점</th>
					<th>작성일</th>
					<th>수정일</th>
					<th>관리</th>
				</tr>
			</thead>
	
			<tbody>
				<c:forEach var="reviewData" items="${reviewPage.reviewList}">
					<tr>
						<td>${reviewData.title}</td>
						<td>${reviewData.review}</td>
						<td id="star-td">
							<div id="star-div-${reviewData.star}" style="overflow: hidden; display: inline-block; position: relative; top: 4px;">
								<img src="images/starRed2.png" width="102.5">
							</div>
							<span id="star">${reviewData.star}</span>
						</td>
						<td>${reviewData.wdate}</td>
						<td>${reviewData.udate}</td>
						<td>
							<a href="member_review_modify?no=${reviewData.reviewId}">[수정]</a>
							<a href="member_review_delete?no=${reviewData.reviewId}">[삭제]</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>


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
	</div>

</body>
</html>