<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		
		#movieDataModifyTable {width: 90%; margin: auto;}
		movieDataModifyTable, #movieDataModifyTable tr, #movieDataModifyTable td {border: 1px solid black; border-collapse: collapse; text-align: center; padding: 10px;}
		.thead {background-color: rgb(255, 153, 51); font-weight: bold;}
		#movieDataModifyTable input {text-align: center; width: 98%;}
		#movieDataModifyTable select {width: 98%;}
		#movieDataModifyTable textarea {width: 98%;}
		#submitButton {width: 300px; height: 30px; margin: auto; font-weight: bold;}
	
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>
	
	<jsp:include page="/WEB-INF/view/layout/left.jsp" flush="false"></jsp:include>
	
	<div id="container">
	
		<h1>
			영화 정보 수정&nbsp;&nbsp;
			<sub>
				<a href="admin_movie_list?pageNo=${param.pageNo}">[영화 목록]</a>&nbsp;&nbsp;
				<a href="admin_movie?pageNo=${param.pageNo}&movieId=${param.movieId}">[영화 정보]</a>&nbsp;&nbsp;
				<a href="admin_movie_delete?pageNo=${param.pageNo}&movieId=${param.movieId}">[삭제]</a>
			</sub>
		</h1>
		
		<hr>
		
		<form action="admin_movie_modify?pageNo=${param.pageNo}&movieId=${param.movieId}" method="post">
		
			<table id="movieDataModifyTable">
			
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
					<td colspan="6"><input type="text" name="title" value="${movieData.moviePre.title}"></td>
				</tr>
				
				<tr>
					<td colspan="2" class="thead">제목 (영어)</td>
					<td colspan="6"></td>
				</tr>
				
				<tr>
					<td class="thead">장르</td>
					<td>
						<select name="genreId">
							<c:forEach var="movieGenre" items="${movieGenreList}">
								<option value="${movieGenre.genreId}">${movieGenre.genreName}</option>
							</c:forEach>
						</select>
					</td>
					<td class="thead">개봉년도</td>
					<td><input type="text" name="releaseDate" value="${movieData.moviePre.releaseDate}"></td>
					<td class="thead">상영시간</td>
					<td><input type="text" name="time" value="${movieData.moviePre.time}"></td>
					<td class="thead">상영등급</td>
					<td>
						<input type="text" name="rate" value="${movieData.moviePre.rate}">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" class="thead">감독</td>
					<td colspan="2"><input type="text" name="director" value="${movieData.movieDetail.director}"></td>
					<td colspan="2" class="thead">배우</td>
					<td colspan="2"><input type="text" name="actor" value="${movieData.movieDetail.actor}"></td>
				</tr>
				
				<tr>
					<td colspan="2" class="thead">줄거리</td>
					<td colspan="6"><textarea rows="30" cols="100" name="plot">${movieData.movieDetail.plot}</textarea></td>
				</tr>
				
				<tr>
					<td colspan="4" class="thead">포스터</td>
					<td colspan="4" class="thead">트레일러</td>
				</tr>
				<tr>
					<td colspan="4">
						<img src="poster/${movieData.moviePre.imageName}" width="260" height="373"><br><br>
						<input type="text" name="imageName" value="${movieData.moviePre.imageName}">
					</td>
					<td colspan="4">
						<iframe width="480" height="280" src="${movieData.movieDetail.trailer}" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe><br><br>
						<input type="text" name="trailer" value="${movieData.movieDetail.trailer}">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" class="thead">명대사</td>
					<td colspan="6"><input type="text" name="famousLine" value="${movieData.moviePre.famousLine}"></td>
				</tr>
				
				<tr>
					<td colspan="2" class="thead">검색어</td>
					<td colspan="2">${movieData.moviePre.searchWord1}</td>
					<td colspan="2"><input type="text" name="searchWord2" placeholder="검색어" value="${movieData.moviePre.searchWord2}"></td>
					<td colspan="2"><input type="text" name="searchWord3" placeholder="검색어" value="${movieData.moviePre.searchWord3}"></td>
				</tr>
				
			</table>
			
			<br>
			
			<div style="text-align: center;">
				<input type="submit" value="수정" id="submitButton">
			</div>
		
		</form>
	
	</div>

</body>
</html>