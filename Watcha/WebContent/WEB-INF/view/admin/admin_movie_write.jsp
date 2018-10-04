<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

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
			<input type="text" name="image" placeholder="image">
		</p>
		
		<p>
			<input type="text" name="director" placeholder="director">
		</p>
		
		<p>
			<input type="text" name="actor" placeholder="actor">
		</p>
		
		<p>
			<input type="text" name="genreId" placeholder="genreId">
		</p>
		
		<p>
			<textarea rows="50" cols="50" name="plot" placeholder="plot"></textarea>
		</p>
		
		<p>
			<input type="text" name="trailer" placeholder="trailer">
		</p>
		
		<p>
			<input type="submit" value="등록">
		</p>
	
	</form>

</body>
</html>