<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_review!!d!!</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
		#th {font-family: BomBaramOTF; margin-top: 85px; color:white;}
		#container {background-color: rgb(250, 250, 250); border-radius: 20px; width: calc(100% - 260px); float: right; padding: 30px; margin: 20px; margin-left: -10px; margin-right: 25px;}
		#container * {font-family: a찐빵M;}
		input {text-align: center; color:white;}
		span {font-size: 10px; font-family: a찐빵M; color:white;}

		#review{width: 90%; margin: auto;}
		#review, #review tr, th, td {border: 1px solid black; border-collapse: collapse;}
		#review td, #review th, #review tr {padding: 10px; text-align: center;}
		#review thead {background-color: rgb(255, 153, 51);}
		
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
	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>
	
	<jsp:include page="/WEB-INF/view/layout/left.jsp" flush="false"></jsp:include>
<table id="review">

			<colgroup>
				<col width="10%"/>
				<col width="*"/>
				<col width="30%"/>
			</colgroup>
	<thead>		
	<tr>
		<th>영화</th>
		<th>작성자</th>
		<th>리뷰</th>
		<th>별점</th>
	</tr>
	</thead>
	<tr>
		<td>${MovieDetailDAO.movieId}</td>
		<td>${authUser.memberName}</td>
		<td>${review.review}</td>
		<td>${review.star}</td>
	</tr>
		
	<tr>
		<td colspan="2">
		<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo }"/>
		
		<c:if test="${AuthUser.memberId == AuthUser.userId}">
			<a href="modify?no=${WatchaReview.reviewId }">[수정]</a>
			<a href="delete?no=${WatchaReview.reviewId }">[삭제]</a>
		</c:if>
		</td>
	</tr>	
</table>

</body>
</html>