package handler.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.handler.CommandHandler;

public class LogoutHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		// 1. session 받아오기
		HttpSession session = req.getSession(false);
		
		// 2. session이 null이 아닌 경우 삭제
		if(session != null) {
			session.invalidate();
		}
		
		// 3. login 페이지로 redirect
		resp.sendRedirect(req.getContextPath() + "/login");
		
		return null;
	}
	
}
