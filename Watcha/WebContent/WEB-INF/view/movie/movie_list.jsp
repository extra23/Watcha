<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
	
		#nonMoviePre {text-align: center; position: absolute; left: 50%; top: 50%; transform: translate(-50%, -50%); -webkit-transform: translate(-50%, -50%);}
	
		#moviePage {text-align: center;}
		#moviePre {width: 300px; display: inline-block; margin: 20px;}
		#col-md-4 {width: 100%;}
		#movieTitle {font-family: BomBaramOTF;}
		#movieInfo, #buttonGroup {font-family: a찐빵M;}
	
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>
	
	

	<!-- MoviePre가 없을 때 adaf-->
	<c:if test="${!moviePage.hasMoviePres()}">
		<div id="nonMoviePre">
			<img src="images/overaction2.jpg">
			<h2 style="font-family: a찐빵M; color: white;">영화 정보 없어!!</h2>
		</div>
	</c:if>

	<!-- MoviePre가 있을 때 -->
	<div id="moviePage">
		<c:forEach var="moviePre" items="${moviePage.moviePreList}">
			<div id="moviePre">
				<div class="col-sm-6 col-md-4" id="col-md-4">
					<div class="thumbnail">
						<img src="poster/${moviePre.imageName}" alt="영화 포스터">
						<div class="caption">
							<h3 id="movieTitle">${moviePre.title}</h3>
							<p id="movieInfo">
								<span>${moviePre.releaseDate}년</span>&nbsp;&nbsp;
								<span>${moviePre.rate}세</span>&nbsp;&nbsp;
								<span>${moviePre.time}분</span>
							</p>
							<p id="buttonGroup">
								<a href="movie?no=${moviePre.movieId}" class="btn btn-primary" role="button" style="background-color: rgb(255, 153, 51); border-width: 0px;">상세보기</a> 
								<a href="#" class="btn btn-default" role="button"><img src="images/heart.png" width="20px;"></a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	
	<!-- 페이지네이션 -->
<%-- 	<div id="pagination">
		<nav>
			<ul class="pagination">
				<c:if test="${moviePage.startPage > 5}">
					<li>
						<a href="movie_list?pageNo=${moviePage.startPage - 5}" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
				</c:if>
				<c:forEach var="pageNo" begin="${moviePage.startPage}" end="${moviePage.endPage}">
					<c:if test="${param.pageNo eq pageNo}"><li><a href="movie_list?pageNo=${pageNo}">${pageNo}</a></li></c:if>
					<c:if test="${not param.pageNo eq pageNo}"><li><a href="movie_list?pageNo=${pageNo}">${pageNo}</a></li></c:if>
				</c:forEach>
				<c:if test="${moviePage.endPage < moviePage.totalPages}">
					<li>
						<a href="movie_list?pageNo=${moviePage.startPage + 5}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
			</ul>
		</nav>
	</div> --%>
	
	<div id="MovieListPagination">
		<nav>
  			<ul class="pagination">
  	  			<li>
  	    			<a href="movie_list?pageNo=${moviePage.startPage - 5}" aria-label="Previous">
  	      				<span aria-hidden="true">&laquo;</span>
  	    			</a>
  	  			</li>
  	  			<li><a href="#">1</a></li>
  	  			<li><a href="#">2</a></li>
  	  			<li><a href="#">3</a></li>
  	  			<li><a href="#">4</a></li>
  	  			<li><a href="#">5</a></li>
  	  			<c:forEach var="pageNo" begin="${moviePage.startPage}" end="${moviePage.endPage}">
  	  				<li><a href="">${pageNo}</a></li>
  	  			</c:forEach>
  	  			<li>
  	    			<a href="#" aria-label="Next">
  	      				<span aria-hidden="true">&raquo;</span>
  	    			</a>
  	  			</li>
  			</ul>
		</nav>
	</div>

</body>
</html>