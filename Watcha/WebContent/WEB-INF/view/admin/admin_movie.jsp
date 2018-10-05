<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
	
		<h1>영화 한편 정보</h1>
	
		<form>
	
			<p>
				<input type="text" name="title" placeholder="title" value="${movieData.moviePre.title}">
			</p>
			
			<p>
				<input type="text" name="time" placeholder="time" value="${movieData.moviePre.time}">
			</p>
			
			<p>
				<input type="text" name="releaseDate" placeholder="releaseDate" value="${movieData.moviePre.releaseDate}">
			</p>
			
			<p>
				<input type="text" name="rate" placeholder="rate" value="${movieData.moviePre.rate}">
			</p>
			
			<p>
				<input type="text" name="famousLine" placeholder="famousLine" value="${movieData.moviePre.famousLine}">
			</p>
			
			<p>
				<input type="file" name="image" value="${movieData.moviePre.image}">
			</p>
			
			<p>
				<input type="text" name="director" placeholder="director" value="${movieData.movieDetail.director}">
			</p>
			
			<p>
				<input type="text" name="actor" placeholder="actor" value="${movieData.movieDetail.actor}">
			</p>
			
			<p>
				<input type="text" name="genreId" placeholder="genreId" value="${movieData.movieDetail.genreId}">
			</p>
			
			<p>
				<textarea rows="30" cols="100" name="plot" placeholder="plot">${movieData.movieDetail.plot}</textarea>
			</p>
			
			<p>
				<input type="text" name="trailer" placeholder="trailer" value="${movieData.movieDetail.trailer}">
			</p>
		
			<p>
				<input type="submit" value="수정" formaction="admin_modify">
			</p>
			
			<p>
				<input type="submit" value="삭제" formaction="admin_delete">
			</p>
		
		</form>
	
	</div>

</body>
</html>