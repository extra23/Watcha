<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>movie_review_list</title>
	<style>
		
		#movieReviewList {
			background-color: white;
			margin: 20px;
			margin-left: -10px;
			margin-right: 30px;
			margin-top: 5px;
			min-width: calc(100% - 1075px);
			border-radius: 20px;
			padding: 30px;
			float: right;
		}

		#movieReviewList * {
			font-family: a찐빵M;
		}

		table, tr, td {
			padding: 8px;
		}

		#writer {
			font-weight: bold;
			font-size: 20px;
		}

		#star-td {
			padding-bottom: 16px;
		}

		#star {
			font-size: 10px;
			color: rgb(255, 0, 128);
		}

		#ReviewListPagination {
			text-align: center;
			margin: -10px;
		}
		
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
					<td><span id="writer">${authUser.memberName}</span>&nbsp;&nbsp;
						<div id="star-div-${review.star}"
							style="overflow: hidden; display: inline-block; position: relative; top: 4px;">
							<img src="images/starRed.png" width="102.5">
						</div>&nbsp;
						<span id="star">${review.star}</span>
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
		<c:if test="${reviewPage.hasReviews()}">
			<div id="ReviewListPagination">
				<nav>
					<ul class="pagination">
						<c:if
							test="${reviewPage.totalPages > 5 && reviewPage.currentPage > 4}">
							<li><a href="movie?movieId=${param.movieId}&pageNo=1" aria-label="Previous">
									<span aria-hidden="true">&lt;&lt;</span>
							</a></li>
						</c:if>
						<c:if test="${reviewPage.currentPage > 2}">
							<li>
								<a href="movie?movieId=${param.movieId}&pageNo=${reviewPage.currentPage - 2}" aria-label="Previous">
									<span aria-hidden="true">&lt;</span>
								</a>
							</li>
						</c:if>
						<c:forEach var="pageNo" begin="${reviewPage.startPage}" end="${reviewPage.endPage}">
							<c:if test="${reviewPage.currentPage eq pageNo}">
								<li class="active"><a href="movie?movieId=${param.movieId}&pageNo=${pageNo}">${pageNo}</a></li>
							</c:if>
							<c:if test="${not (reviewPage.currentPage eq pageNo)}">
								<li><a href="movie?movieId=${param.movieId}&pageNo=${pageNo}">${pageNo}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${reviewPage.totalPages > 1 && reviewPage.currentPage < reviewPage.totalPages - 1}">
							<li>
								<a href="movie?movieId=${param.movieId}&pageNo=${reviewPage.currentPage + 2}" aria-label="Next"> 
									<span aria-hidden="true">&gt;</span>
								</a>
							</li>
						</c:if>
						<c:if test="${reviewPage.totalPages > 5 && reviewPage.currentPage < reviewPage.totalPages - 2}">
							<li>
								<a href="movie?movieId=${param.movieId}&pageNo=${reviewPage.totalPages}" aria-label="Next"> 
									<span aria-hidden="true">&gt;&gt;</span>
								</a>
							</li>
						</c:if>
					</ul>
				</nav>
			</div>
		</c:if>

	</div>

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