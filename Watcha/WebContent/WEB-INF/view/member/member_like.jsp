<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보고싶어요 페이지</title>
</head>
<body>

	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>
	<jsp:include page="/WEB-INF/view/layout/left.jsp" flush="false"></jsp:include>
	
	<!-- 보고싶어요 한 영화가 없을 때 -->
	<c:if test="${!likePage.hasLikes()}"></c:if>
		<div id="nonLike">
			<img src="images/overaction2.jpg">
			<h2 style="font-family: a찐빵M; color: white;">보고싶은 영화 없어!!</h2>	
		</div>

</body>
</html>