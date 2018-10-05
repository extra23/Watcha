<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		
		.dropdown-menu {
		    position: absolute;
		    top: 100%;
		    left: -23px;
		    z-index: 1000;
		    display: none;
		    float: left;
		    min-width: 100px;
		    padding: 5px 0 5px 0px;
		    margin: 5px 0 0 0;
		    font-size: 14px;
		    text-align: left;	
		    list-style: none;	
		    background-color: #fff;
		    -webkit-background-clip: padding-box;
		    background-clip: padding-box;
		    border: 1px solid #ccc;
		    border: 1px solid rgba(0,0,0,.15);
		    border-radius: 4px;
		    -webkit-box-shadow: 0 6px 12px rgba(0,0,0,.175);
		    box-shadow: 0 6px 12px rgba(0,0,0,.175);
		}
		
		#topHr {border: 0px; clear: both;}
		
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
		
			<c:if test="${authUser.memberRate eq 0}">
				<li><a href="admin_member">회원 관리</a></li>
				<li><a href="admin_movie_write">영화 추가</a></li>
				<li><a href="admin_movie_list">영화 관리</a></li>
				<li><a href="admin_review">리뷰 관리</a></li>
				<li class="divider"></li>
			</c:if>
		
			<li><a href="member_account_modify" onclick="return check()">계정 관리</a></li>
			<li><a href="member_account_delete">회원 탈퇴</a></li>
			<li><a href="member_like">보고싶어요</a></li>
			<li><a href="member_review">리뷰</a>
			<li class="divider"></li>
			<li><a href="logout">로그아웃</a></li>
			
		</ul>

	</div>
	
	<hr id="topHr">
	
	<script>
	
		function check(){
			var password = prompt("비밀번호를 다시 한 번 입력해주세요.");
			if("${authUser.password}" == password){
				return true;
			}else{
				return false;
			}
		}
	
	</script>

</body>
</html>