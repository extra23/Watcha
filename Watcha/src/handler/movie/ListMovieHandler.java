package handler.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import service.movie.ListMovieService;
import service.movie.MoviePage;

public class ListMovieHandler implements CommandHandler{
	
	// 페이지 번호를 파라미터로 받고 서비스를 이용해서 페이지 목록을 받아온다.
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ListMovieService movieService = ListMovieService.getInstance( );
		String pageNoStr = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoStr != null) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		MoviePage moviePage = movieService.getMoviePage(pageNo);
		req.setAttribute("moviePage", moviePage);
		return "/WEB-INF/view/movie/movie_list.jsp";
	}

}
