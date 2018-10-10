<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_review</title>
</head>
<body>
<table id="review">
	<tr>
		<th>영화</th>
		<td>${MovieDetailDAO.movieId}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${AuthUser.memberId}</td>
	</tr>
	<tr>
		<th>리뷰</th>
		<td>${review.review}</td>
	</tr>	
	<tr>
		<th>별점</th>
		<td>${review.star}</td>
	</tr>	
	<tr>
		<td colspan="2">
		<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo }"/>
		<a href="movie_review_list?pageNo=${pageNo }">[돌아가기]</a>
		<c:if test="${AuthUser.memberId == AuthUser.userId}">
			<a href="modify?no=${Member.memberId }">[수정]</a>
			<a href="delete?no=${Member.memberId }">[삭제]</a>
		</c:if>
		</td>
	</tr>	
</table>
<!-- dd -->

</body>
</html>