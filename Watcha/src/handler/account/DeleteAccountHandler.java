package handler.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;

public class DeleteAccountHandler implements CommandHandler{

	//삭제할지말지 알려주는 form
	private static final String FORM_VIEW = "/WEB-INF/view/member/deleteForm.jsp";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req,resp);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req,resp);
		}else {
			resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
			//dk
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		//아이디 받기
		String noStr = req.getParameter("no");
		int no = Integer.parseInt(noStr);
		
		//게시글을 읽어오는 
		return null;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		
		return null;
	}
	
	
}
