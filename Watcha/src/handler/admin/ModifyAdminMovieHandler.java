package handler.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import model.MovieDetail;
import model.MovieGenre;
import model.MoviePre;
import service.account.AuthUser;
import service.movie.ModifyMovieService;
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

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// 파라미터 받음 (pageNo)
		String pageNoStr = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoStr != null && !pageNoStr.isEmpty()) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		
		// 파라미터 받음 (movieId)
		int movieId = Integer.parseInt(req.getParameter("movieId"));
		
		// 사용할 서비스객체 생성
		ModifyMovieService modifyMovieService = ModifyMovieService.getInstance();
		
		// 서비스객체 사용
		modifyMovieService.modify(new MovieData(new MoviePre(movieId, req.getParameter("title"), Integer.parseInt(req.getParameter("genreId")), Integer.parseInt(req.getParameter("time")), req.getParameter("releaseDate"), Integer.parseInt(req.getParameter("rate")), req.getParameter("famousLine"), req.getParameter("imageName"), req.getParameter("title").trim(), req.getParameter("searchWord2"), req.getParameter("searchWord3")), new MovieDetail(req.getParameter("director"), req.getParameter("actor"), Integer.parseInt(req.getParameter("genreId")), req.getParameter("plot"), req.getParameter("trailer"))), ((AuthUser)req.getSession().getAttribute("authUser")).getMemberRate());
		
		// 화면 반환 (redirect 사용)
		resp.sendRedirect(req.getContextPath() + "/admin_movie?pageNo=" + pageNo + "&movieId=" + movieId);
		
		return null;
		
	}

}
