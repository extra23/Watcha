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

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//서비스를 이용해서 리뷰를 작성하고 
		//resp.sendRedirect를 통해 review 주소를 보낸다.
		
		String starStr = req.getParameter("star");
		
		ReviewRequest reviewRequest = new ReviewRequest(((AuthUser)req.getSession().getAttribute("authUser")).getMemberId(), Integer.parseInt(starStr), req.getParameter("review"));
		
		
		//memberId, star는 자료형이 int이므로 Integer.parseInt()하기 전에 먼저 빈 값이 들어왔는지 들어오지 않았는지 check해줌

		
		WriteReviewService writeReviewService = WriteReviewService.getInstance();
		writeReviewService.write(reviewRequest);
		resp.sendRedirect(req.getContextPath()+"/movie");
		return null;
	}
}
