<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
	
		#container {background-color: rgb(250, 250, 250); border-radius: 20px; width: calc(100% - 260px); float: right; padding: 30px; padding-bottom: 50px; margin: 20px; margin-left: -10px; margin-right: 25px;}
		#container * {font-family: a찐빵M;}
		
		#movieDataTable {width: 90%; margin: auto;}
		#movieDataTable, #movieDataTable tr, #movieDataTable td {border: 1px solid black; border-collapse: collapse; text-align: center; padding: 10px;}
		.thead {background-color: rgb(255, 153, 51); font-weight: bold;}
	
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/layout/top.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/view/layout/left.jsp"></jsp:include>
	
	<div id="container">
	
		<h1>영화 한편 정보&nbsp;&nbsp;<sub><a href="admin_movie_list?pageNo=${param.pageNo}">[목록으로]</a></sub></h1>
	
		<hr>
		
		<table id="movieDataTable">
			
			<colgroup>
				<col width="13%"/>
				<col width="12%"/>
				<col width="13%"/>
				<col width="12%"/>
				<col width="13%"/>
				<col width="12%"/>
				<col width="13%"/>
				<col width="12%"/>
			</colgroup>
		
			<tr>
				<td colspan="2" class="thead">제목 (한글)</td>
				<td colspan="6">${movieData.moviePre.title}</td>
			</tr>
			
			<tr>
				<td colspan="2" class="thead">제목 (영어)</td>
				<td colspan="6"></td>
			</tr>
			
			<tr>
				<td class="thead">장르</td>
				<td>
					<c:forEach var="movieGenre" items="${movieGenreList}">
						<c:if test="${movieGenre.genreId eq movieData.moviePre.genreId}">${movieGenre.genreName}</c:if>
					</c:forEach>
				</td>
				<td class="thead">개봉년도</td>
				<td>${movieData.moviePre.releaseDate}년</td>
				<td class="thead">상영시간</td>
				<td>${movieData.moviePre.time}분</td>
				<td class="thead">상영등급</td>
				<td>
					<c:if test="${movieData.moviePre.rate eq 0}">전체 연령가</c:if>
					<c:if test="${not(movieData.moviePre.rate eq 0)}">${movieData.moviePre.rate}세</c:if>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" class="thead">감독</td>
				<td colspan="2">${movieData.movieDetail.director}</td>
				<td colspan="2" class="thead">배우</td>
				<td colspan="2">${movieData.movieDetail.actor}</td>
			</tr>
			
			<tr>
				<td colspan="2" class="thead">줄거리</td>
				<td colspan="6">${movieData.movieDetail.plot}</td>
			</tr>
			
			<tr>
				<td colspan="4" class="thead">포스터</td>
				<td colspan="4" class="thead">트레일러</td>
			</tr>
			<tr>
				<td colspan="4">
					<img src="poster/${movieData.moviePre.imageName}" width="260" height="373"><br><br>
					${movieData.moviePre.imageName}
				</td>
				<td colspan="4">
					<iframe width="480" height="280" src="${movieData.movieDetail.trailer}" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe><br><br>
					${movieData.movieDetail.trailer}
				</td>
			</tr>
			
			<tr>
				<td colspan="2" class="thead">명대사</td>
				<td colspan="6">${movieData.moviePre.famousLine}</td>
			</tr>
			
			<tr>
				<td colspan="2" class="thead">검색어</td>
				<td colspan="2">${movieData.moviePre.searchWord1}</td>
				<td colspan="2">${movieData.moviePre.searchWord2}</td>
				<td colspan="2">${movieData.moviePre.searchWord3}</td>
			</tr>
		
		</table>
	
	</div>

</body>
</html>