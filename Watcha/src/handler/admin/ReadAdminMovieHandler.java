package handler.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.MovieDetailNotFoundException;
import Exception.MoviePreNotFoundException;
import common.handler.CommandHandler;
import service.movie.MovieData;
import service.movie.ReadMovieService;

public class ReadAdminMovieHandler implements CommandHandler{

	// 사용자에게 요청을 받고 서비스를 이용해서 화면에 보여줄 데이터 생성할 메소드
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		// 사용할 movieId 받아오기
		int movieId = Integer.parseInt(req.getParameter("movieId"));
		
		ReadMovieService readMovieService = ReadMovieService.getInstance();
		
		// 화면으로 리턴
		try {
			MovieData movieData = readMovieService.getMovie(movieId);
			req.setAttribute("movieData", movieData);
			return "/WEB-INF/view/admin/admin_movie.jsp";
		}catch(MoviePreNotFoundException | MovieDetailNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

	}

}
