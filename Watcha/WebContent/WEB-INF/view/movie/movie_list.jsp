<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>POTATO::영화 목록</title>
	<style>
	
		body {background: url("images/background2.jpg") no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;}
	
		#chooseMovies {padding: 20px; padding-top: 0px;}
		#selectGenre, #searchMovie {display: inline-block;}
		#selectGenre {vertical-align: baseline;}
		#select-title, #select-button {background-color: rgb(0, 0, 0, 0); border: 0.5px solid rgb(240, 240, 240); padding: 8px; font-family: a찐빵M; fon}
		#select-title {width: 160px;}
		#option-menu {margin: 22px; margin-top: 8px; width: 185px; font-family: a찐빵M;}
		#option {margin: 5px;}
		#searchMovie {width: 400px; float: none; display: inline-block;}
		#searchMovie * {font-family: a찐빵M;}
		#searchMovie input::placeholder {color: rgb(255, 255, 255, 0.5);}
	
		#nonMoviePre {text-align: center; position: absolute; left: 50%; top: 50%; transform: translate(-50%, -50%); -webkit-transform: translate(-50%, -50%);}
	
		#moviePage {text-align: center;}
		#moviePre {width: 300px; display: inline-block; margin: 20px;}
		#col-md-4 {width: 100%;}
		#movieTitle {font-family: BomBaramOTF;}
		#genre, #movieInfo, #buttonGroup {font-family: a찐빵M;}
		
		#MovieListPagination {text-align: center;}
		#MovieListPagination * {font-family: a찐빵M;}
	
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/layout/top.jsp" flush="false"></jsp:include>
	
	<div id="chooseMovies">
		<div class="btn-group" id="selectGenre">
  			<button type="button" class="btn btn-danger" id="select-title">
  				<c:forEach var="movieGenre" items="${movieGenreList}">
  					<c:if test="${movieGenre.genreId eq param.genreId}">${movieGenre.genreName}</c:if>
  				</c:forEach>
  				<c:if test="${empty param.genreId || param.genreId eq 0}">전체 장르</c:if>
  			</button>
  			<button type="button" class="btn btn-danger dropdown-toggle" id="select-button" data-toggle="dropdown" aria-expanded="false">
    			<span class="caret"></span>
    			<span class="sr-only">Toggle Dropdown</span>
  			</button>
  			<ul class="dropdown-menu" id="option-menu" role="menu">
  				<li id="option"><a href="movie_list">전체 장르</a></li>
    			<c:forEach var="movieGenre" items="${movieGenreList}">
    				<li id="option"><a href="movie_list?pageNo=1&genreId=${movieGenre.genreId}">${movieGenre.genreName}</a></li>
    			</c:forEach>
  			</ul>
		</div>
 		<div class="col-lg-6" id="searchMovie">
 			<form class="input-group" action="movie_list?genreId=${param.genreId}" method="post">
      			<input type="text" name="searchWord" class="form-control" placeholder="영화 제목을 입력해주세요." value="${param.searchWord}" style="background-color: rgb(0, 0, 0, 0); color: white; border: 0.5px solid white; padding: 18px;">
      			<span class="input-group-btn">
        			<input type="submit" class="btn btn-default" value="검색" style="background-color: rgb(0, 0, 0, 0); color: white; border: 0.5px solid white; padding: 8px;">
      			</span>
   			</form>
 		 </div>
 		 <div id="result" style="color: white; display: inline-block;">
 		 	<c:if test="${empty param.genreId and not empty param.searchWord}">전체 장르 > ${param.searchWord}</c:if>
 		 	<c:forEach var="movieGenre" items="${movieGenreList}">
 		 		<c:if test="${movieGenre.genreId eq param.genreId}">${movieGenre.genreName}</c:if>
 		 	</c:forEach>
 		 	<c:if test="${not empty param.genreId and not empty param.searchWord}"> > ${param.searchWord}</c:if>
 		 </div>
	</div>

	<!-- MoviePre가 없을 때 -->
	<c:if test="${!moviePage.hasMoviePres() && empty moviePreList}">
		<div id="nonMoviePre">
			<img src="images/overaction2.jpg">
			<h2 style="font-family: a찐빵M; color: white;">영화 정보 없어!!</h2>
		</div>
	</c:if>

	<!-- MoviePre가 있을 때 -->
	<c:if test="${moviePage.hasMoviePres() && empty moviePreList}">
	<div id="moviePage">
		<c:forEach var="moviePre" items="${moviePage.moviePreList}">
			<div id="moviePre">
				<div class="col-sm-6 col-md-4" id="col-md-4">
					<div class="thumbnail">
						<img src="poster/${moviePre.imageName}" alt="영화 포스터" style="width: 260px; height: 373px;">
						<div class="caption">
							<h3 id="movieTitle">${moviePre.title}</h3>
							<p id="genre">
								<c:forEach var="movieGenre" items="${movieGenreList}">
									<c:if test="${movieGenre.genreId eq moviePre.genreId}">${movieGenre.genreName}</c:if>
								</c:forEach>
							</p>
							<p id="movieInfo">
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
								<a href="movie?pageNo=${param.pageNo}&movieId=${moviePre.movieId}&genreId=${param.genreId}" class="btn btn-primary" role="button" style="background-color: rgb(255, 153, 51); border-width: 0px;">상세보기</a> 
								<a href="like_write?pageNo=${param.pageNo}&genreId=${param.genreId}&no=${moviePre.movieId}" class="btn btn-default" role="button"><img src="images/heart.png" width="20px;"></a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	</c:if>
	
	<!-- 페이지네이션 -->
	<c:if test="${moviePage.hasMoviePres() && empty moviePreList}">
		<div id="MovieListPagination">
			<nav>
	  			<ul class="pagination">
	  				<c:if test="${moviePage.totalPages > 5 && moviePage.currentPage > 4}">
	  					<li>
	  						<a href="movie_list?pageNo=1&genreId=${param.genreId}" aria-label="Previous">
	  							<span aria-hidden="true">&lt;&lt;</span>
	  						</a>
	  					</li>
	  				</c:if>
	  				<c:if test="${moviePage.currentPage > 2}">
	  	  				<li>
	  	    				<a href="movie_list?pageNo=${moviePage.currentPage - 2}&genreId=${param.genreId}" aria-label="Previous">
	  	      					<span aria-hidden="true">&lt;</span>
	  	    				</a>
	  	  				</li>
	  	  			</c:if>
	  	  			<c:forEach var="pageNo" begin="${moviePage.startPage}" end="${moviePage.endPage}">
 						<c:if test="${moviePage.currentPage eq pageNo}">
							<li class="active"><a href="movie_list?pageNo=${pageNo}&genreId=${param.genreId}">${pageNo}</a></li>
						</c:if>
						<c:if test="${not (moviePage.currentPage eq pageNo)}">
							<li><a href="movie_list?pageNo=${pageNo}&genreId=${param.genreId}">${pageNo}</a></li>
						</c:if>
	  	  			</c:forEach>
	  	  			<c:if test="${moviePage.totalPages > 1 && moviePage.currentPage < moviePage.totalPages - 1}">
	  	  				<li>
	  	    				<a href="movie_list?pageNo=${moviePage.currentPage + 2}&genreId=${param.genreId}" aria-label="Next">
	  	      					<span aria-hidden="true">&gt;</span>
	  	    				</a>
	  	  				</li>
	  	  			</c:if>
	  	  			<c:if test="${moviePage.totalPages > 5 && moviePage.currentPage < moviePage.totalPages - 2}">
	  	  				<li>
	  	  					<a href="movie_list?pageNo=${moviePage.totalPages}&genreId=${param.genreId}" aria-label="Next">
	  	  						<span aria-hidden="true">&gt;&gt;</span>
	  	  					</a>
	  	  				</li>
	  	  			</c:if>
	  			</ul>
			</nav>
		</div>
	</c:if>
	
	<!-- 검색 기능을 사용했을 시 화면 표시 -->
	<c:if test="${not empty moviePreList}">
		<div id="moviePage">
			<c:forEach var="moviePre" items="${moviePreList}">
				<div id="moviePre">
					<div class="col-sm-6 col-md-4" id="col-md-4">
						<div class="thumbnail">
							<img src="poster/${moviePre.imageName}" alt="영화 포스터">
							<div class="caption">
								<h3 id="movieTitle">${moviePre.title}</h3>
								<p id="movieInfo">
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
			</c:forEach>
		</div>
	</c:if>
	
	<span></span>
	
</body>
</html>