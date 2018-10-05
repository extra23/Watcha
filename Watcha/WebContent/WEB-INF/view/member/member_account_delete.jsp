<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_account_delete</title>
</head>
<body>
	
	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>
	
	<jsp:include page="/WEB-INF/view/layout/left.jsp" flush="false"></jsp:include>
	
	<div id="container">
	<form action="member_account_delete" method="post">
	

	<h1>회원 탈퇴 페이지입니다.</h1>
	
	<p>
	<input type="password" name="password" placeholder="비밀번호를 입력하세요">
	</p>
	
	
	<!-- 비밀번호 확인하는거 만들기 -->
	
	<p>
	<input type="submit" value="계정 삭제">
	</p>
	
	</form>
	</div>
</body>
</html>