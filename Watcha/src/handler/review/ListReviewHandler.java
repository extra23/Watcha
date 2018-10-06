package handler.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import service.review.ListReviewService;
import service.review.ReviewPage;

public class ListReviewHandler implements CommandHandler{

	//페이지 번호로 파라미터로 받고 서비스를 이용해서 페이지 목록을 받아온다.
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ListReviewService listReviewService = ListReviewService.getInstance();
		
		String pageNoStr = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoStr != null) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		
		ReviewPage reviewPage = listReviewService.getReviewPage(pageNo);
		req.setAttribute("reviewPage", reviewPage);
		
		return "/WEB-INF/view/movie/movie.jsp";
	}

}
