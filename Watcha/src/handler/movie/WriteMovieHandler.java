package handler.movie;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import model.MovieDetail;
import model.MoviePre;
import service.movie.MovieData;

public class WriteMovieHandler implements CommandHandler{
	
	private static final String FORM_VIEW = "/WEB-INF/view/admin/admin_movie.jsp";

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
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		
		// 0. time, rate, genreId는 자료형이 int이므로 Integer.parseInt()하기 전에 먼저 빈 값이 들어 왔는지 들어오지 않았는지 check 해줌
		Map<String, Boolean> errors = new HashMap<>();
		
		String timeStr = req.getParameter("time");
		int time = 0;
		if(timeStr != null) {
			time = Integer.parseInt(timeStr);
		}else {
			errors.put("time", true);
		}
		
		String rateStr = req.getParameter("rate");
		int rate = 0;
		if(rateStr != null) {
			rate = Integer.parseInt(rateStr);
		}else {
			errors.put("rate", true);
		}
		
		String genreIdStr = req.getParameter("genreId");
		int genreId = 0;
		if(genreIdStr != null) {
			genreId = Integer.parseInt(genreIdStr);
		}else {
			errors.put("genreId", true);
		}
		
		// 1. 관리자에게 입력받은 Movie 정보를 MovieData 객체에 담음
		MovieData movieData = new MovieData(new MoviePre(req.getParameter("title"), time, req.getParameter("releaseDate"), rate, req.getParameter("famousLine"), req.getParameter("image")), new MovieDetail(req.getParameter("director"), req.getParameter("actor"), genreId, req.getParameter("plot"), req.getParameter("trailer")));
		
		// 2. MovieData에 담은 내용들의 무결성 체크 (비어있는지 안비어 있는지)
		
		
		req.setAttribute("errors", errors);
		
		return null;
	}
	
}
