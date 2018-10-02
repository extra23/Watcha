package handler.account;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.LoginFailException;
import common.handler.CommandHandler;
import service.account.AuthUser;
import service.account.LoginService;

public class LoginHandler implements CommandHandler{

	private static final String FORM_VIEW = "/WEB-INF/view/main/login.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, resp);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, resp);
		}else {
			resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// 1. request로 parameter를 받음 (id, password)
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		
		// 2. 받아온 parameter의 무결성 체크 (비었는지 안비었는지)
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		if(userId == null || userId.isEmpty()) {
			errors.put("userId", true);
		}
		if(password == null || password.isEmpty()) {
			errors.put("password", true);
		}
		req.setAttribute("errors", errors);
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		// 3. 무결성 체크 후 비지 않았다면 Service 객체 받고 Service 객체의 메소드를 통해서 인증함
		LoginService loginService = LoginService.getInstance();
		try{
			// 3-1. 인증에 성공하면 AuthUser 객체를 생성하여 Session에 넣음
			AuthUser authUser = loginService.login(userId, password);
			req.getSession().setAttribute("authUser", authUser);
			resp.sendRedirect(req.getContextPath() + "/movieList");
			return null;
		}catch (LoginFailException e) {
			// 3-2. 인증에 실패하면 errors 객체에 실패 정보를 받고 login.jsp 화면으로 다시 보냄
			e.printStackTrace();
			errors.put("idOrPasswordNotMatch", true);
			return FORM_VIEW;
		}
		
	}
	
}
