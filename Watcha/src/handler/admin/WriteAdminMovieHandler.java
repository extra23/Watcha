package handler.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import dao.MoviePreDAO;
import jdbc.ConnectionProvider;
import model.MovieDetail;
import model.MovieGenre;
import model.MoviePre;
import service.movie.MovieData;
import service.movie.ReadMovieGenreService;
import service.movie.WriteMovieService;

public class WriteAdminMovieHandler implements CommandHandler{
	
	private static final String FORM_VIEW = "/WEB-INF/view/admin/admin_movie_write.jsp";

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
		ReadMovieGenreService readMovieGenreService = ReadMovieGenreService.getInstance();
		List<MovieGenre> movieGenreList = readMovieGenreService.readMovieGenre();
		req.setAttribute("movieGenreList", movieGenreList);
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// 0. time, rate, genreId는 자료형이 int이므로 Integer.parseInt()하기 전에 먼저 빈 값이 들어 왔는지 들어오지 않았는지 check 해줌
		Map<String, Boolean> errors = new HashMap<>();
		
		String timeStr = req.getParameter("time");
		int time = 0;
		if(timeStr != null && !timeStr.isEmpty()) {
			time = Integer.parseInt(timeStr);
		}else {
			errors.put("time", true);
		}
		
		String rateStr = req.getParameter("rate");
		int rate = 0;
		if(rateStr != null && !rateStr.isEmpty()) {
			rate = Integer.parseInt(rateStr);
		}else {
			errors.put("rate", true);
		}
		
		String genreIdStr = req.getParameter("genreId");
		int genreId = 0;
		if(genreIdStr != null && !genreIdStr.isEmpty()) {
			genreId = Integer.parseInt(genreIdStr);
		}else {
			System.out.println("여기들어오나??");
			errors.put("genreId", true);
		}
		
		// 1. 관리자에게 입력받은 Movie 정보를 MovieData 객체에 담음
		MovieData movieData = new MovieData(new MoviePre(req.getParameter("title"), genreId, time, req.getParameter("releaseDate"), rate, req.getParameter("famousLine"), req.getParameter("imageName"), req.getParameter("title").trim(), req.getParameter("searchWord2"), req.getParameter("searchWord3")), new MovieDetail(req.getParameter("director"), req.getParameter("actor"), genreId, req.getParameter("plot"), req.getParameter("trailer")));
		
		
		
		// 2. MovieData에 담은 내용들의 무결성 체크 (비어있는지 안비어 있는지)
		movieData.validate(errors);
		req.setAttribute("errors", errors);
		
		// 3. 무결성 검사에서 이상이 있으면 FORM_VIEW로 다시 반환
		if(!errors.isEmpty()) {
			ReadMovieGenreService readMovieGenreService = ReadMovieGenreService.getInstance();
			List<MovieGenre> movieGenreList = readMovieGenreService.readMovieGenre();
			req.setAttribute("movieGenreList", movieGenreList);
			return FORM_VIEW;
		}
		
		// 4. 무결성 검사에서 이상이 없다면 WriteMovieService를 이용하여 write(movie_pre, movie_detail insert) 로직을 수행함
		WriteMovieService writeMovieService = WriteMovieService.getInstance();
		int movieId = writeMovieService.write(movieData);
		
		resp.sendRedirect(req.getContextPath() + "/admin_movie?movieId=" + movieId);
		
		return null;
		
	}
	
}
