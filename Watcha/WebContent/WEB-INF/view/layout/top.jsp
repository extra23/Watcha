<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	
	<meta charset="UTF-8">
	<title>Insert title here</title>

	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

	<style>

		#logo {
			float: left;
			margin: 15px;
		}

		#logo img {
			border-radius: 100%;
			width: 50px;
		}

		#title {
			float: left;
			font-family: a스케치고딕;
			margin: 10px;
			margin-left: -3px;
			padding-top: 4px;
			font-size: 40px;
			color: white;
		}

		#user {
			float: right;
			color: white;
			font-family: a찐빵M;
			margin: 24px;
		}
		
		hr {border: 0px; clear: both;}
		
	</style>
	
</head>
<body>

	<div id="logo">
		<a href="movieList"><img src="images/overaction.gif"></a>
	</div>

	<div id="title">POTATO</div>

	<div id="user" class="btn-group">

		<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">${authUser.memberName}&nbsp;&nbsp;<span class="caret"></button>

		<ul class="dropdown-menu" role="menu">
			<li><a href="modify" onclick="return check()">계정 관리</a></li>
			<li><a href="like">보고싶어요</a></li>
			<li><a href="review">리뷰</a>
			<li class="divider"></li>
			<li><a href="logout">로그아웃</a></li>
		</ul>

	</div>
	
	<hr>
	
	<script>
	
		function check(){
			var password = prompt("비밀번호를 다시 한 번 입력해주세요.");
			if("${authUser.password}".equals(password)){
				return true;
			}
		}
	
	</script>

</body>
</html>