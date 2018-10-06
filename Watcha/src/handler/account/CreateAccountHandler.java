package handler.account;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.DuplicateException;
import Exception.LoginFailException;
import common.handler.CommandHandler;
import dao.MemberDAO;
import jdbc.ConnectionProvider;
import model.Member;
import service.account.AuthUser;
import service.account.CreateAccountRequest;
import service.account.CreateAccountService;
import service.account.LoginService;

public class CreateAccountHandler implements CommandHandler{

	private static final String FORM_VIEW = "/WEB-INF/view/main/join.jsp";

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
		return FORM_VIEW;
	}

	// 사용자로부터 회원가입 데이터를 입력받아adadg
	// submit 버튼을 클릭해서 데이타가 넘어왔을 때 실행하는 메소드 
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// 파라미터를 통해서 입력받은 데이터를 CreateAccountRequest 객체에 담음.
		CreateAccountRequest createAccountRequest = new CreateAccountRequest();
			createAccountRequest.setUserId(req.getParameter("userId"));
			createAccountRequest.setMemberName(req.getParameter("memberName"));
			createAccountRequest.setPassword(req.getParameter("password"));
			createAccountRequest.setConfirmPassword(req.getParameter("confirmPassword"));
		
		Map<String, Boolean> errors = new HashMap<String, Boolean>( );
		
		req.setAttribute("errors", errors);
		
		// 데이터 검증, 무결성 체크, 패스워드 확인
		createAccountRequest.validate(errors);
		
		// 잘못 들어왔으면 다시 폼화면으로 반환
		if(!errors.isEmpty( )) {
			return FORM_VIEW;
		}
		
		// 잘 입력되면 CreateAccountService 회원가입 로직 수행
		CreateAccountService createAccountService = CreateAccountService.getInstance();
		LoginService loginService = LoginService.getInstance();
		try {
			
			// 아이디가 중복일 때 예외를 여기로 던져줌
			createAccountService.create(createAccountRequest);
			
			// 로그인 Service 사용
			AuthUser authUser = loginService.login(createAccountRequest.getUserId(), createAccountRequest.getPassword());
			req.getSession().setAttribute("authUser", authUser);
			
			// movie_list로 화면 반환
			resp.sendRedirect(req.getContextPath() + "/movie_list");
			return null;
			
		}catch(DuplicateException e) {
			// 아이디가 중복일 때 service에서 발생시킨 예외를 받아서 처리해줌.
			errors.put("duplicateId", true);
			return FORM_VIEW;
		}catch (LoginFailException e) {
			e.printStackTrace();
			errors.put("idOrPasswordNotMatch", true);
			return "/WEB-INF/view/main/login.jsp";
		}
		
	}
	
	
}