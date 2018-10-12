<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
		
		#container {background-color: rgb(250, 250, 250); border-radius: 20px; width: calc(100% - 260px); float: right; padding: 30px; margin: 20px; margin-left: -10px; margin-right: 25px;}
		#container * {font-family: a찐빵M;}
		
		#newMovieDataTable {width: 90%; margin: auto;}
		#newMovieDataTable, #newMovieDataTable tr, #newMovieDataTable td {border: 1px solid black; border-collapse: collapse; padding: 10px; text-align: center;}
		.thead {font-weight: bold; background-color: rgb(255, 153, 51);}
		#newMovieDataTable input {text-align: center; width: 98%;}
		#newMovieDataTable select {width: 98%;}
		#newMovieDataTable textarea {width: 98%;}
		#submitButton {width: 300px; height: 30px; margin: auto; font-weight: bold;}
		#newMovieDataTable span {color: red; font-size: 10px;}
	
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/layout/top.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/view/layout/left.jsp"></jsp:include>

	<div id="container">
	
		<h1>새로운 영화 등록</h1>
		
		<hr>
	
		<form action="admin_movie_write" method="post">
		
			<table id="newMovieDataTable">
			
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
					<td colspan="6">
						<input type="text" name="title" placeholder="title" value="${param.title}"><br>
						<c:if test="${errors.title}"><span>제목을 입력해주세요.</span></c:if>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" class="thead">제목 (영어)</td>
					<td colspan="6"></td>
				</tr>
				
				<tr>
					<td class="thead">장르</td>
					<td>
						<select name="genreId">
							<option value="" selected disabled></option>
							<c:forEach var="movieGenre" items="${movieGenreList}">
								<c:if test="${param.genreId eq movieGenre.genreId}">
									<option value="${movieGenre.genreId}" selected="selected">${movieGenre.genreName}</option>
								</c:if>
								<c:if test="${not (param.genreId eq movieGenre.genreId)}">
									<option value="${movieGenre.genreId}">${movieGenre.genreName}</option>
								</c:if>
							</c:forEach>
						</select>
						<c:if test="${errors.genreId}"><span>장르를 선택해주세요.</span></c:if>
					</td>
					<td class="thead">개봉년도</td>
					<td>
						<input type="text" name="releaseDate" placeholder="releaseDate" value="${param.releaseDate}"><br>
						<c:if test="${errors.releaseDate}"><span>개봉년도를 입력해주세요.</span></c:if>
					</td>
					<td class="thead">상영시간</td>
					<td><input type="text" name="time" placeholder="time" value="${param.time}"></td>
					<td class="thead">상영등급</td>
					<td> <%-- 버튼 형식으로 만들어 볼까?? --%>
						<input type="text" name="rate" placeholder="rate" value="${param.rate}">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" class="thead">감독</td>
					<td colspan="2"><input type="text" name="director" placeholder="director" value="${param.director}"></td>
					<td colspan="2" class="thead">배우</td>
					<td colspan="2"><input type="text" name="actor" placeholder="actor" value="${param.actor}"></td>
				</tr>
				
				<tr>
					<td colspan="2" class="thead">줄거리</td>
					<td colspan="6"><textarea rows="30" cols="100" name="plot" placeholder="plot">${param.plot}</textarea></td>
				</tr>
				
				<tr>
					<td colspan="4" class="thead">포스터</td>
					<td colspan="4" class="thead">트레일러</td>
				</tr>
				<tr>
					<td colspan="4">
						<input type="text" name="imageName" placeholder="Image Name" value="${param.imageName}">
					</td>
					<td colspan="4">
						<input type="text" name="trailer" placeholder="trailer" value="${param.trailer}">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" class="thead">명대사</td>
					<td colspan="6"><input type="text" name="famousLine" placeholder="famousLine" value="${param.famousLine}"></td>
				</tr>
				
				<tr>
					<td colspan="2" class="thead">검색어</td>
					<td colspan="2"></td>
					<td colspan="2"><input type="text" name="searchWord2" placeholder="검색어" value="${param.searchWord2}"></td>
					<td colspan="2"><input type="text" name="searchWord3" placeholder="검색어" value="${param.searchWord3}"></td>
				</tr>
				
			</table>
			
			<br>
			
			<div style="text-align: center;">
				<input type="submit" value="등록" id="submitButton">
			</div>
		
		</form>
		
	</div>

</body>
</html>