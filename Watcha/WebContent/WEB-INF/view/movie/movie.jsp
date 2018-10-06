<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
	
		#movieData {background-color: rgb(240, 240, 240); margin: 20px; border-radius: 20px; padding: 30px;}
		#movieTitle {font-family: BomBaramOTF; font-size: 30px;}
	
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/layout/top.jsp"></jsp:include>

	<div id="movieData">
	
		<p id="movieTitle">
			${movieData.moviePre.title}
		</p>
		
		<p>
			<span>${movieData.moviePre.releaseDate}</span>
			<span>${movieData.moviePre.rate}</span>
			<span>${movieData.moviePre.time}</span>
			<span>
				<c:forEach var="movieGenre" items="${movieGenreList}">
					<c:if test="${movieData.movieDetail.genreId eq movieGenre.genreId}">
						${movieGenre.genreName}
					</c:if>
				</c:forEach>
			</span>
		</p>
	
	</div>

</body>
</html>