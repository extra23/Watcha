<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie_review.jsp</title>
</head>
<body>
<form action="write_review" method="post">
<input type="number" name="memberId" value="${param.memberId }">
<input type="number" name="star" placeholder="별점">
<textarea rows="5" cols="30" name="review" >${param.review }</textarea>

<input type="submit" value="리뷰등록">
</form>

</body>
</html>