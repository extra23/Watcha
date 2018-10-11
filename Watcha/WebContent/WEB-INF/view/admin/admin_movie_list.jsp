<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
	
		#container {background-color: rgb(250, 250, 250); border-radius: 20px; width: calc(100% - 260px); float: right; padding: 30px; margin: 20px; margin-left: -10px; margin-right: 25px;}
		#container * {font-family: a찐빵M;}
	
		#moviePageTable {width: 90%; margin: auto;}
		#moviePageTable, #moviePageTable tr, th, td {border: 1px solid black; border-collapse: collapse;}
		#moviePageTable td, #moviePageTable th, #moviePageTable tr {padding: 10px; text-align: center;}
		#moviePageTable thead {background-color: rgb(255, 153, 51);}
		
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>
	
	<jsp:include page="/WEB-INF/view/layout/left.jsp" flush="false"></jsp:include>
	
	<div id="container">
	
		<h1>영화 목록</h1>
		
		<hr>
	
		<table id="moviePageTable">
		
			<colgroup>
				<col width="10%"/>
				<col width="*"/>
				<col width="30%"/>
			</colgroup>
			
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>관리</th>
				</tr>
			</thead>
		
			<tbody>
				<c:forEach var="moviePre" items="${moviePage.moviePreList}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td><a href="admin_movie?movieId=${moviePre.movieId}">${moviePre.title}</a></td>
						<td>
							<a href="admin_movie_modify">[수정]</a>
							<a href="admin_movie_delete">[삭제]</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
		
		<div id="pagination">
			
		</div>
	
	</div>
	
</body>
</html>