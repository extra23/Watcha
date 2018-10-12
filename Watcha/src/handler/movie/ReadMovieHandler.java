package handler.movie;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.MovieDetailNotFoundException;
import Exception.MoviePreNotFoundException;
import common.handler.CommandHandler;
import model.MovieGenre;
import service.account.AuthUser;
import service.movie.MovieData;
import service.movie.ReadMovieGenreService;
import service.movie.ReadMovieService;
import service.review.ListReviewService;
import service.review.ReviewPage;
import service.review.ReviewRequest;
import service.review.WriteReviewService;

public class ReadMovieHandler implements CommandHandler{
	
	public static final String FORM_VIEW = "/WEB-INF/view/movie/movie.jsp";
	int movieId;

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, resp);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, resp);
		}else {
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	// 사용자에게 요청을 받고 서비스를 이용해서 화면에 보여줄 데이터 생성
	public String processForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// 사용할 Parameter 받아오기 (movieData, reviewPage)
		// movieData
		int movieId = Integer.parseInt(req.getParameter("movieId"));
		this.movieId = movieId;
		// reviewPage
		String pageNoStr = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoStr != null) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		
		// 사용할 service 객체 생성 (movieGenre, movieData, reviewPage)
		ReadMovieGenreService readMovieGenreService = ReadMovieGenreService.getInstance();
		ReadMovieService readMovieService = ReadMovieService.getInstance();
		ListReviewService listReviewService = ListReviewService.getInstance();
				
		// service 사용
		List<MovieGenre> movieGenreList = readMovieGenreService.readMovieGenre();
		MovieData movieData = null;
		try {
			movieData = readMovieService.getMovie(movieId);
		}catch(MoviePreNotFoundException | MovieDetailNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		ReviewPage reviewPage = listReviewService.getReviewPage(movieId, pageNo);
		
		// 화면으로 이동
		req.setAttribute("movieData", movieData);
		req.setAttribute("movieGenreList", movieGenreList);
		req.setAttribute("reviewPage", reviewPage);
		
		return FORM_VIEW;
		
	}
	
	public String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		Map<String, Boolean> errors = new HashMap<>();
		
		// 사용자가 작성한 내용을 받아와서 ReviewRequest 객체 생성하여 저장
		String starStr = req.getParameter("star");
		double star = 0.0;
		if(starStr != null) {
			star = Double.parseDouble(starStr);
		}else {
			errors.put("star", true);
		}
		
		ReviewRequest reviewRequest = new ReviewRequest(((AuthUser)req.getSession().getAttribute("authUser")).getMemberId(), movieId, star, req.getParameter("review"));
		
		reviewRequest.validate(errors);
		req.setAttribute("errors", errors);
		
		for(String errorsValue : errors.keySet()) {
			System.out.println(errorsValue);
		}
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		// WriteReviewService 이용하여 watcha_review 테이블에 reviewRequest 내용 넣기
		WriteReviewService writeReviewService = WriteReviewService.getInstance();
		writeReviewService.write(reviewRequest);
		
		resp.sendRedirect(req.getContextPath() + "/movie?movieId=" + this.movieId);
		
		return null;
		
	}

}
