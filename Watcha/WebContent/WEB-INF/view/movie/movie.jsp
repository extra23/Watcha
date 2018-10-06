<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<title>Insert title here</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
	
		#movieData {background-color: rgb(240, 240, 240); margin: 20px; border-radius: 20px; padding: 40px; width: 1000px; display: inline-block;}
		#movieTitle {font-family: BomBaramOTF; font-size: 40px;}
		#moviePre {font-family: a찐빵M;}
		#movieTrailer {text-align: center;}
		#movieDirector, #movieActor, .moviePlot {font-family: a찐빵M;}
	
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>

	<div id="movieData">
	
		<p id="movieTitle">
			${movieData.moviePre.title}
		</p>
		
		<p id="moviePre">
			<span>${movieData.moviePre.releaseDate}년</span>&nbsp;&nbsp;
			<span>${movieData.moviePre.rate}세</span>&nbsp;&nbsp;
			<span>${movieData.moviePre.time}분</span>&nbsp;&nbsp;
			<span>
				<c:forEach var="movieGenre" items="${movieGenreList}">
					<c:if test="${movieData.movieDetail.genreId eq movieGenre.genreId}">
						${movieGenre.genreName}
					</c:if>
				</c:forEach>
			</span>
		</p>
		
		<br>
		
		<p id="movieTrailer">
			<iframe width="885" height="498" src="${movieData.movieDetail.trailer}" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
		</p>
		
		<br>
		
		<p id="movieDirector">
			<span><b>감독 : </b></span>
			<span>${movieData.movieDetail.director}</span>
		</p>
		
		<p id="movieActor">
			<span><b>배우 : </b></span>
			<span>${movieData.movieDetail.actor}</span>
		</p>
		
		<br>
		
		<p class="moviePlot">
			<span><b>줄거리 : </b></span><br>
			<div class="moviePlot"><u:pre value="${movieData.movieDetail.plot}"></u:pre></div>
		</p>
	
	</div>
	
	<jsp:include page="/WEB-INF/view/movie/movie_review.jsp" flush="false"></jsp:include>

</body>
</html>