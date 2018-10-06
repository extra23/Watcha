package handler.review;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import model.WatchaReview;
import service.account.AuthUser;
import service.review.ReviewRequest;
import service.review.WriteReviewService;

//리뷰 작성 핸들러
public abstract class WriteReviewHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/view/movie/movie_review.jsp";

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

	// 서비스를 이용해서 리뷰를 watcha_review 테이블에 insert하고 resp.sendRedirect를 통해 review 주소를 보냄
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		// 빈 값이 있을 경우 오류를 저장할 Map 객체
		Map<String, Boolean> errors = new HashMap<>();
		
		String starStr = req.getParameter("star");
		int star = 0;
		if(starStr != null) {
			star = Integer.parseInt(starStr);
		}else {
			errors.put("star", true);
		}
		
		// 사용자가 작성한 내용을 받아와서 저장하는 ReviewRequest 객체
		ReviewRequest reviewRequest = new ReviewRequest(((AuthUser)req.getSession().getAttribute("authUser")).getMemberId(), star, req.getParameter("review"));
		reviewRequest.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		WriteReviewService writeReviewService = WriteReviewService.getInstance();
		writeReviewService.write(reviewRequest);
		
		System.out.println("주소 : " + req.getContextPath() + "/movie?no=2");
		
		resp.sendRedirect(req.getContextPath()+"/movie?no=2");
		
		return null;
		
	}
	
}
