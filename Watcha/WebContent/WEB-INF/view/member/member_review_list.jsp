<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_review</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
		#th {font-family: BomBaramOTF; margin-top: 85px;}
		#container form * {font-family: a찐빵M;}
		input {text-align: center;}
		span {font-size: 10px; font-family: a찐빵M;}
	</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>
	
	<jsp:include page="/WEB-INF/view/layout/left.jsp" flush="false"></jsp:include>
<table id="review">
	<tr>
		<th>영화</th>
		<th>작성자</th>
		<th>리뷰</th>
		<th>별점</th>
	</tr>
	<tr>
		<td>${MovieDetailDAO.movieId}</td>
		<td>${authUser.memberId}</td>
		<td>${review.review}</td>
		<td>${review.star}</td>
	</tr>
		
	<tr>
		<td colspan="2">
		<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo }"/>
		
		<c:if test="${AuthUser.memberId == AuthUser.userId}">
			<a href="modify?no=${Member.memberId }">[수정]</a>
			<a href="delete?no=${Member.memberId }">[삭제]</a>
		</c:if>
		</td>
	</tr>	
</table>

</body>
</html>