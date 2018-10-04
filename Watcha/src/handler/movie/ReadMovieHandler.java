package handler.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.ArticleContentNotFoundException;
import common.exception.ArticleNotFoundException;
import common.handler.CommandHandler;
import service.movie.MovieData;
import service.movie.ReadMovieService;

public class ReadMovieHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 사용자에게 요청을 받고 서비스를 이용해서 화면에 보여줄 데이터 생성
		int movieId = Integer.parseInt(req.getParameter("no"));
		ReadMovieService movieService = ReadMovieService.getInstance( );
		
		// 화면으로 리턴
		try {
			MovieData movieData = movieService.getMovie(movieId, true);
			req.setAttribute("movieData", movieData);
			
			return "/WEB-INF/view/movie/movie_list.jsp";
		}catch(ArticleNotFoundException | ArticleContentNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
	}
}
