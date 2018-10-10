<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보고싶어요 페이지</title>
	<style>
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
		#nonLike {text-align: center; position: absolute; left: 50%; top: 50%; transform: translate(-50%, -50%); -webkit-transform: translate(-50%, -50%);}
	
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>
	<jsp:include page="/WEB-INF/view/layout/left.jsp" flush="false"></jsp:include>
	
	<!-- 보고싶어요 한 영화가 없을 때 -->
	<c:if test="${!likePage.hasLikes()}">   
		<div id="nonLike">
			<img src="images/overaction2.jpg">
			<h2 style="font-family: a찐빵M; color: white;">보고싶은 영화 없어!!</h2>	
		</div>
	</c:if>   
	
	<!-- 영화가 있을 때 -->
	<div id="likePage">
		<c:forEach var="like" items="${likePage.likeList }">
			<div id="like">
				<div class="row">
  					<div class="col-sm-6 col-md-4">
    					<div class="thumbnail">
      						<img src="..." alt="...">
      						<div class="caption">
        						<h3>Thumbnail label</h3>
       							<span>${moviePre.releaseDate}년</span>&nbsp;&nbsp;
								<c:if test="${moviePre.rate eq 0}">
									<span>전체연령가</span>&nbsp;&nbsp;
								</c:if>
								<c:if test="${not (moviePre.rate eq 0)}">
									<span>${moviePre.rate}세</span>&nbsp;&nbsp;
								</c:if>
								<span>${moviePre.time}분</span>
							</p>
								<p id="buttonGroup">
								<a href="movie?movieId=${moviePre.movieId}" class="btn btn-primary" role="button" style="background-color: rgb(255, 153, 51); border-width: 0px;">상세보기</a> 
								<a href="like_write?pageNo=${param.pageNo}&genreId=${param.genreId}&no=${moviePre.movieId}" class="btn btn-default" role="button"><img src="images/heart.png" width="20px;"></a>
							</p>
							</div>
    						</div>
  						</div>
					</div>
				
				</div>			
			</div>
		</c:forEach>
	</div>
	
		
</body>
</html>