<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
	
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>

	<!-- 게시글이 없을 때 -->
	<c:if test="${!moviePage.hasMoviePres()}">
		
	</c:if>

</body>
</html>