package handler.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.InvalidPasswordException;
import Exception.MovieDetailNotFoundException;
import Exception.MoviePreNotFoundException;
import Exception.PermissionDeniedException;
import common.handler.CommandHandler;
import model.MovieGenre;
import service.account.AuthUser;
import service.movie.DeleteMovieService;
import service.movie.MovieData;
import service.movie.ReadMovieGenreService;
import service.movie.ReadMovieService;

public class DeleteAdminMovieHandler implements CommandHandler{

	private static final String FORM_VIEW = "/WEB-INF/view/admin/admin_movie_delete.jsp";
	
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
		
		// 파라미터 받아오기 (movieId)
		int movieId = Integer.parseInt(req.getParameter("movieId"));
		
		// error를 담을 Map 객체 생성
		Map<String, Boolean> errors = new HashMap<>();
		
		// 사용할 서비스 객체 생성
		ReadMovieService readMovieService = ReadMovieService.getInstance();
		ReadMovieGenreService readMovieGenreService = ReadMovieGenreService.getInstance();
		
		// 서비스 객체 사용
		MovieData movieData = null;
		try {
			movieData = readMovieService.getMovie(movieId);
		}catch(MoviePreNotFoundException | MovieDetailNotFoundException e) {
			errors.put("MovieNotFound", true);
			return FORM_VIEW;
		}
		List<MovieGenre> movieGenreList = readMovieGenreService.readMovieGenre();
		
		// request 객체에 setAttribute
		req.setAttribute("movieData", movieData);
		req.setAttribute("movieGenreList", movieGenreList);
		req.setAttribute("errors", errors);
		
		return FORM_VIEW;
		
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		// 파라미터 받아오기 (pageNo)
		String pageNoStr = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoStr != null && !pageNoStr.isEmpty()) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		
		// 파라미터 받아오기 (movieId)
		int movieId = Integer.parseInt(req.getParameter("movieId"));
		
		// errors를 담을 Map 객체 생성
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		// 사용할 서비스 객체 생성
		DeleteMovieService deleteMovieService = DeleteMovieService.getInstance();
		
		// 서비스 객체 사용
		try {
			deleteMovieService.delete(movieId, ((AuthUser)req.getSession().getAttribute("authUser")).getMemberRate(), ((AuthUser)req.getSession().getAttribute("authUser")).getPassword(), req.getParameter("password"));
		}catch(MoviePreNotFoundException | MovieDetailNotFoundException e) {
			errors.put("MovieNotFound", true);
			return FORM_VIEW;
		}catch(PermissionDeniedException e) {
			errors.put("PermissionDenied", true);
			return FORM_VIEW;
		}catch(InvalidPasswordException e) {
			errors.put("InvalidPassword", true);
			return FORM_VIEW;
		}
		
		resp.sendRedirect(req.getContextPath() + "/admin_movie_list?pageNo=" + pageNo);
		
		return null;
		
	}

}
