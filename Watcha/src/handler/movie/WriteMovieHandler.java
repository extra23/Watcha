package handler.movie;

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
		
		MovieData movieData = new MovieData(new MoviePre(req.getParameter("title"), Integer.parseInt(req.getParameter("time")), req.getParameter("releaseDate"), Integer.parseInt(req.getParameter("rate")), req.getParameter("famousLine"), req.getParameter("image")), new MovieDetail(req.getParameter("director"), req.getParameter("actor"), Integer.parseInt(req.getParameter("genreId")), req.getParameter("plot"), req.getParameter("trailer")));
		
		return null;
	}
	
}
