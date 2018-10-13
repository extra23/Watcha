package handler.movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.MoviePreNotFoundException;
import common.handler.CommandHandler;
import model.MovieGenre;
import model.MoviePre;
import service.movie.ListMovieService;
import service.movie.MoviePage;
import service.movie.ReadMovieGenreService;
import service.movie.SelectMovieService;

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
		if(pageNoStr != null && !pageNoStr.isEmpty()) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		
		String genreIdStr = req.getParameter("genreId");
		int genreId = 0;
		if(genreIdStr != null && genreIdStr != "") {
			genreId = Integer.parseInt(genreIdStr);
		}
		
		MoviePage moviePage = listMovieService.getMoviePage(pageNo, genreId, 10, 5);
		List<MovieGenre> movieGenreList = readMovieGenreService.readMovieGenre();
		
		req.setAttribute("moviePage", moviePage);
		req.setAttribute("movieGenreList", movieGenreList);
		
		return "/WEB-INF/view/movie/movie_list.jsp";
		
	}

	private String processSubmint(HttpServletRequest req, HttpServletResponse resp) {
		
		// genreId 받아오기
		String genreIdStr = req.getParameter("genreId");
		int genreId = 0;
		if(genreIdStr != null && !genreIdStr.isEmpty()) {
			genreId = Integer.parseInt(genreIdStr);
		}
		
		// MoviePre객체를 담을 ArrayList 생성, MovieGenre 객체를 담을 ArrayList 생성
		List<MoviePre> moviePreList = null;
		List<MovieGenre> movieGenreList = null;
		
		// error를 담을 Map 객체 생성
		Map<String, Boolean> errors = new HashMap<>();
		
		// 사용자에게서 입력받은 검색어(searchWord) 받아오기
		String searchWord = req.getParameter("searchWord");
		
		// 사용할 Service 객체 생성
		SelectMovieService selectMovieService = SelectMovieService.getInstance();
		ReadMovieGenreService readMovieGenreService = ReadMovieGenreService.getInstance();
		
		try {
			moviePreList = selectMovieService.getMoviePreList(genreId, searchWord);
		}catch(MoviePreNotFoundException e) {
			errors.put("notFoundMoviePreList", true);
			req.setAttribute("errors", errors);
			return "/WEB-INF/view/movie/movie_list.jsp";
		}
		
		movieGenreList = readMovieGenreService.readMovieGenre();
		
		req.setAttribute("moviePreList", moviePreList);
		req.setAttribute("movieGenreList", movieGenreList);
		
		return "/WEB-INF/view/movie/movie_list.jsp";
		
	}

}
