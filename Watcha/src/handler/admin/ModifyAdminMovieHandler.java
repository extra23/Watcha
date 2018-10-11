package handler.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import model.MovieGenre;
import service.movie.MovieData;
import service.movie.ReadMovieGenreService;
import service.movie.ReadMovieService;

public class ModifyAdminMovieHandler implements CommandHandler{
	
	private static final String FORM_VIEW = "/WEB-INF/view/admin/admin_movie_modify.jsp";

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
	
	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		
		// 파라미터 받음 (movieId)
		int movieId = Integer.parseInt(req.getParameter("movieId"));
		
		// 사용할 Service 객체 생성
		ReadMovieService readMovieService = ReadMovieService.getInstance();
		ReadMovieGenreService readMovieGenreService = ReadMovieGenreService.getInstance();
		
		// MovieData 생성
		MovieData movieData = readMovieService.getMovie(movieId);
		List<MovieGenre> movieGenreList = readMovieGenreService.readMovieGenre();
		
		// request 객체에 setAttribute 해줌
		req.setAttribute("movieData", movieData);
		req.setAttribute("movieGenreList", movieGenreList);
		
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

}
