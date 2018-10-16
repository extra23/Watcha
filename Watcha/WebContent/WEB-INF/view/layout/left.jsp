<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<style>
	
		#menu {background-color: rgb(255, 153, 51, 0.8); border-radius: 10px; width: 200px; font-family: a찐빵M; font-size: 18px; padding: 10px; margin: 20px; float: left;}

		#menu h3 {text-align: center;}
		.menuHr {border: 1px solid white; margin: 10px;}
		
		#menu ul {list-style: none;}
		#menu a {text-decoration: none; color: rgb(100, 100, 100);}
		#menu a:hover {text-decoration: none; color: rgb(100, 100, 100);}
		
	</style>
</head>
<body>

	<div id="menu">
		
		<c:if test="${authUser.memberRate eq 0}">
			
			<h3>관리자 메뉴</h3>
			<hr class="menuHr">
			<ul>
<!-- 				<li><a href="admin_member">회원 관리</a></li> -->
				<li><a href="admin_movie_write">영화 추가</a></li>
				<li><a href="admin_movie_list">영화 관리</a></li>
<!-- 				<li><a href="admin_review">리뷰 관리</a></li> -->
			</ul>
			
			<br>
			
		</c:if>
		
		<h3>회원 메뉴</h3>
		<hr class="menuHr">
		<ul>
			<li><a href="member_account_modify" onclick="return left_check()">계정 관리</a></li>
			<li><a href="member_account_delete">회원 탈퇴</a></li>
			<li><a href="member_like">보고싶어요</a></li>
			<li><a href="member_review_list">리뷰</a>
		</ul>
	
	</div>
	
	<script>
	
		function left_check(){
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