<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}

		#container {background-color: rgb(250, 250, 250); border-radius: 20px; width: calc(100% - 260px); float: right; padding: 30px; margin: 20px; margin-left: -10px; margin-right: 25px; text-align: center;}
		#container * {font-family: a찐빵M;}

	</style>
<meta charset="UTF-8">
<title>POTATO::리뷰 삭제</title>
</head>
<body>
	
	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>
	
	<jsp:include page="/WEB-INF/view/layout/left.jsp" flush="false"></jsp:include>

	<div id="container">
		<h1>
			리뷰 삭제&nbsp;&nbsp;
			<sub>
				<a href="member_review_list?pageNo=${param.pageNo}">[리뷰 목록]</a>&nbsp;&nbsp;
				<a href="member_review_modify?pageNo=${param.pageNo}&no=${param.no}">[수정]</a>&nbsp;&nbsp;
			</sub>
		</h1>
		<hr>
		<form action="member_review_delete?no=${param.no}" method="post">
			<input type="password" name="password" placeholder="비밀번호"><br>
					<c:if test="${errors.password}"><span>Password를 입력해주세요.</span></c:if>
					<c:if test="${errors.idOrPasswordNotMatch}"><span>Password가 일치하지 않습니다.</span></c:if>
			<input type="submit" value="삭제" onclick="deleteAlert()">
		</form>
	</div>
	
	<script>
		function deleteAlert(){
			alert("리뷰가 삭제되었습니다.ㅜㅜ");
		}
	</script>
	
</body>
</html>