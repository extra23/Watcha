package handler.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import model.MovieGenre;
import service.movie.ListMovieService;
import service.movie.MoviePage;
import service.movie.ReadMovieGenreService;

public class ListAdminMovieHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/WEB-INF/view/admin/admin_movie_list.jsp";

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
		
		// request로부터 pageNo(parameter) 받기
		String pageNoStr = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoStr != null && !pageNoStr.isEmpty()) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		
		// request로부터 genreId(parameter) 받기
		String genreIdStr = req.getParameter("genreId");
		int genreId = 0;
		if(genreIdStr != null && !genreIdStr.isEmpty()) {
			genreId = Integer.parseInt(genreIdStr);
		}
		
		// 사용할 Service 객체 생성
		ListMovieService listMovieService = ListMovieService.getInstance();
		ReadMovieGenreService readMovieGenreService = ReadMovieGenreService.getInstance();
		
		// Service 객체 사용 (MoviePage 객체, movieGenreList 받아오기)
		MoviePage moviePage = listMovieService.getMoviePage(pageNo, genreId, 20, 5);
		List<MovieGenre> movieGenreList = readMovieGenreService.readMovieGenre();
		
		// request 객체에 setAttribute
		req.setAttribute("moviePage", moviePage);
		req.setAttribute("movieGenreList", movieGenreList);
		
		return FORM_VIEW;
		
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

}
