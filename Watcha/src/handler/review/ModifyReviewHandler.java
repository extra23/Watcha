package handler.review;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.PermissionDeniedException;
import Exception.ReviewNotFoundException;
import common.handler.CommandHandler;
import service.account.AuthUser;
import service.review.ModifyReviewService;

public class ModifyReviewHandler implements CommandHandler{

	private static final String FORM_VIEW = "/WEB-INF/view/member/member_review_modify.jsp";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
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

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//  ReviewData에 수정 내용들을 파라미터에서 받아서 담고
		int memberId = ((AuthUser)req.getSession( ).getAttribute("authUser")).getMemberId();
		
		String pageNoStr = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoStr != null && !pageNoStr.isEmpty()) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		
		// 파라미터 받아오기
		int reviewId = Integer.parseInt(req.getParameter("no"));
		
		// errors 를 담을 Map 객체 생성
		Map<String, Boolean> errors = new HashMap<>( );
		req.setAttribute("errors", errors);
		
		// 사용할 서비스 객체 생성
		ModifyReviewService modifyReviewService = ModifyReviewService.getInstance( );
		
		// 서비스 객체 사용
		try {
			modifyReviewService.modify(reviewId, memberId);
		}catch(PermissionDeniedException e) {
			errors.put("PermissionDenied", true);
			return FORM_VIEW;
		}catch(ReviewNotFoundException e) {
			errors.put("ReviewNotFound", true);
			return FORM_VIEW;
		}
		resp.sendRedirect(req.getContextPath( ) + "/member_review_list?pageNo =" + pageNo);
		
		return null;
	}

}