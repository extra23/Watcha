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
	
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/layout/top.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/view/layout/left.jsp"></jsp:include>

	<div id="container">
	
		<h1>새로운 영화 등록 페이지</h1>
	
		<form action="admin_movie_write" method="post">
		
			<p>
				<input type="text" name="title" placeholder="title">
			</p>
			
			<p>
				<input type="text" name="time" placeholder="time">
			</p>
			
			<p>
				<input type="text" name="releaseDate" placeholder="releaseDate">
			</p>
			
			<p>
				<input type="text" name="rate" placeholder="rate">
			</p>
			
			<p>
				<input type="text" name="famousLine" placeholder="famousLine">
			</p>
			
			<p>
				<input type="file" name="image">
			</p>
			
			<p>
				<input type="text" name="director" placeholder="director">
			</p>
			
			<p>
				<input type="text" name="actor" placeholder="actor">
			</p>
				
<!-- 			<p>
				<input type="text" name="genreId" placeholder="genreId">
			</p> -->
			
			<p>
				<select name="movieGenre">
					<c:forEach var="movieGenre" items="${movieGenreList}">
						<option value="${movieGenre.genreId}">${movieGenre.genreName}</option>
					</c:forEach>
				</select>
			</p>
			
			<p>
				<textarea rows="30" cols="100" name="plot" placeholder="plot"></textarea>
			</p>
			
			<p>
				<input type="text" name="trailer" placeholder="trailer">
			</p>
			
			<p>
				<input type="submit" value="등록">
			</p>
		
		</form>
		
	</div>

</body>
</html>