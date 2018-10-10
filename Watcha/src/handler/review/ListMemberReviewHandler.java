package handler.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import service.account.AuthUser;
import service.review.ListMemberReviewService;
import service.review.ReviewPage;

public class ListMemberReviewHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//11223
		int memberId = ((AuthUser)req.getSession().getAttribute("authUser")).getMemberId();
		
		ListMemberReviewService listMemberReviewService = ListMemberReviewService.getInstance( );
		
		String pageNoStr = req.getParameter("pageNo");
		int pageNum = 1;
		if(pageNoStr != null) {
			pageNum = Integer.parseInt(pageNoStr);
		}
		
		ReviewPage reviewPage = listMemberReviewService.getReviewPage(memberId, pageNum);
		req.setAttribute("reviewPage", reviewPage);
		
		return "/WEB-INF/view/member/member_review_list.jsp";
	}
}
