package handler.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;

public class ModifyAccountHandler implements CommandHandler{

	//수정할 페이지 생성
	private static final String FORM_VIEW = "/WEB-INF/view/";

	
	//입력받은 데이터(비밀번호)가 문제가 있는지 무결성 체크 후 비번화면으로 돌려보내거나
	//정보 수정 후 성공화면으로 보낸다.
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		return null;
	}

	
}
