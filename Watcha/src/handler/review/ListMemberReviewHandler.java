package handler.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import service.review.ListMemberReviewService;
import service.review.ReviewPage;

public class ListMemberReviewHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//1122
		int memberId = Integer.parseInt(req.getParameter("memberId"));
		
		ListMemberReviewService listMemberReviewService = ListMemberReviewService.getInstance( );
		
		String pageNoStr = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoStr != null) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		ReviewPage reviewPage = listMemberReviewService.getReviewPage(memberId, pageNo);
		req.setAttribute("reviewPage", reviewPage);
		return "/WEB-INF/view/movie/movie_review_page";
	}
}
