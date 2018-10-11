package handler.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;

public class ModifyAdminMovieHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, resp);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, resp);
		}
	}

}
