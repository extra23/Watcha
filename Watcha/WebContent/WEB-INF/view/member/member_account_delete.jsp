<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_account_delete</title>
<style>
body {
	background: url("images/background2.jpg") no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

#container {
	float: right;
	width: calc(100% - 260px);
	background-color: rgb(250, 250, 250);
	border-radius: 20px;
	padding: 10px;
	margin: 20px;
	margin-left: -10px;
	margin-right: 25px;
}

span {
	font-size: 15px;
	font-family: a찐빵M;
	color: red;
}

#container2 {
	display: none;
	float: right;
	width: calc(100% - 260px);
	background-color: rgb(250, 250, 250);
	border-radius: 20px;
	padding: 10px;
	margin-left: -10px;
	margin-right: 25px;
}
</style>
</head>
<body>



	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>

	<jsp:include page="/WEB-INF/view/layout/left.jsp" flush="false"></jsp:include>

	<div id="container">

		<h1>회원 탈퇴 페이지입니다.</h1>


		<p>
			<button onclick="return checkOut()">계정삭제</button>
		</p>

	</div>

	<form action="member_account_delete" method="post">

		<div id="container2">


			<h1>정말 탈퇴할거야??</h1>

			<img src="images/overaction2.jpg">

			<p>
				<input type="password" name="password">
			</p>


			<!-- 비밀번호 확인하는거 만들기 -->

			<c:if test="${errors.emptyPassword} }">
				<span>비밀번호를 입력하지 않았습니다.</span>
			</c:if>
			<c:if test="${errors.wrongPwd }">
				<span>입력한 비밀번호가 계정의 비밀번호와 다릅니다. 다시 입력해주세요</span>
			</c:if>

			<input type="submit" value="계정 삭제">
	</form>
	</div>
	<script>
	
		function checkOut() {
			document.getElementById("container2").style.display="block";
			return true;
		}
	
	</script>
</body>
</html>