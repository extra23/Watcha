package handler.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;

public class DeleteReviewHandler implements CommandHandler {
	private static final String FORM_VIEW ="/WEB-INF/view/member/member_account_delete.jsp";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod( ).equalsIgnoreCase("GET")) {
			return processForm(req, resp);
		}else if(req.getMethod( ).equalsIgnoreCase("POST")) {
			return processSubmit(req, resp);
		}else {
			resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
