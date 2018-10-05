package handler.account;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.handler.CommandHandler;
import service.account.AuthUser;
import service.account.DeleteAccountService;

public class DeleteAccountHandler implements CommandHandler{

	//삭제할지말지 알려주는 form
	private static final String FORM_VIEW = "/WEB-INF/view/member/member_account_delete.jsp";

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
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException{ 
		
		//입력한 비밀번호
		String password = req.getParameter("password");
		//로그인시 사용한 비밀번호
		HttpSession session = req.getSession(false);
		
		if(session == null) {
			//잘못된 접근시 에러페이지로 보냄
			resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
		AuthUser authUser = (AuthUser)session.getAttribute("authUser");
		
		//authUser가 null이 아니고 입력한 password와 로그인시 사용한 비밀번호가 같다면
		if(authUser != null && password.equals(authUser.getPassword())) {
			//DeleteAccountService를 가져온다.
			DeleteAccountService deleteAccountService = DeleteAccountService.getInstance();
			//DeleteAccountService에 있는 delete사용해서 저장된 계정과 등록한 리뷰 등 삭제
			deleteAccountService.delete(authUser.getMemberId(), authUser.getUserId(), authUser.getMemberName());
			//세션삭제
			session.invalidate();
			//login페이지로 돌아가기
			resp.sendRedirect(req.getContextPath() + "/login");
			return null;
		}else {
			Map<String, Boolean> errors = new HashMap<String,Boolean>();
			req.setAttribute("errors", errors);
			
			if(password == null || password.isEmpty()) {
				errors.put("emptyPassword", true);
			}else if(!password.equals(authUser.getPassword())) {
				errors.put("wrongPwd", true);
			}
			
			return FORM_VIEW;
		}
		
	}	
}
