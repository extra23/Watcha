package handler.movie;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import model.MovieGenre;
import service.movie.ListMovieService;
import service.movie.MoviePage;
import service.movie.ReadMovieGenreService;

public class ListMovieHandler implements CommandHandler{
	
	// 페이지 번호를 파라미터로 받고 서비스를 이용해서 페이지 목록을 받아온다.
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, resp);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmint(req, resp);
		}else {
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	// movie_list를 요청할때 처리하는 메소드 (영화 장르에 상관없이 DB에 등록된 모든 영화 정보를 가져오는 메소드)
	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		
		ListMovieService listMovieService = ListMovieService.getInstance();
		ReadMovieGenreService readMovieGenreService = ReadMovieGenreService.getInstance();
		
		String pageNoStr = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoStr != null) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		
		MoviePage moviePage = listMovieService.getMoviePage(pageNo);
		List<MovieGenre> movieGenreList = readMovieGenreService.readMovieGenre();
		
		req.setAttribute("moviePage", moviePage);
		req.setAttribute("movieGenreList", movieGenreList);
		
		return "/WEB-INF/view/movie/movie_list.jsp";
		
	}

	private String processSubmint(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

}
