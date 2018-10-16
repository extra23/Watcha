package handler.account;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.InvalidPasswordException;
import Exception.MemberNotFoundException;
import common.handler.CommandHandler;
import service.account.AuthUser;
import service.account.ModifyAccountService;

public class ModifyAccountHandler implements CommandHandler{

	//수정할 페이지 생성
	private static final String FORM_VIEW = "/WEB-INF/view/member/member_account_modify.jsp";
	
	//입력받은 데이터(비밀번호)가 문제가 있는지 무결성 체크 후 비번화면으로 돌려보내거나
	//정보 수정 후 성공화면으로 보낸다. + 수정한 이름을 성공화면으로 보낸다.
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req,resp);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req,resp);
		}else {
			resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}

	//form_view로부터 입력받은 비밀번호의 무결성 검증을 해야하고
	//session에 있는 auth객체로부터 로그인 ID정보를 받아오고
	//서비스를 이용하여 비번 변경 수행
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		AuthUser authUser = (AuthUser)req.getSession().getAttribute("authUser");
		
		Map<String, Boolean> errors = new HashMap<String,Boolean>();
		req.setAttribute("errors", errors);
		
		String oldPwd = req.getParameter("oldPwd");
		String newPwd = req.getParameter("newPwd");
		String memberName = req.getParameter("memberName");
		
		if(oldPwd == null || oldPwd.isEmpty()) {
			errors.put("oldPwd", true);
		}
		
		if(newPwd == null || newPwd.isEmpty()) {
			errors.put("newPwd", true);
		}
		
		if(oldPwd.equals(newPwd)) {
			errors.put("samePwd", true);
		}
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			ModifyAccountService modifyAccountService = ModifyAccountService.getInstance();
			int modifyFlag = modifyAccountService.changePassword(authUser.getUserId(), oldPwd, newPwd, memberName);
			authUser.setPassword(newPwd);
			authUser.setMemberName(memberName);
			req.setAttribute("modifyFlag", modifyFlag);
			return FORM_VIEW;
		}catch(InvalidPasswordException e) {
			errors.put("wrongOldPwd", true);
			return FORM_VIEW;
		}catch(MemberNotFoundException e) {
			//잘못된 요청 정보
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			//헤드에 에러값을 넣어주는 것이므로 null을 넣어줌
			return null;
		}
		
	}

	
}
