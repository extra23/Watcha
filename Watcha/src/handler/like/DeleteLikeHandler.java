package handler.like;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import service.account.AuthUser;
import service.like.DeleteLikeService;

public class DeleteLikeHandler implements CommandHandler {

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

	private String processForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		
		//memberId
				AuthUser authUser = (AuthUser) req.getSession().getAttribute("authUser");
				int memberId = authUser.getMemberId();
				
				String pageNoStr = req.getParameter("pageNo");
				int pageNo = 1;
				if(pageNoStr != null && !pageNoStr.isEmpty()) {
					pageNo = Integer.parseInt(pageNoStr);
				}
				
				//movieId
				int movieId = Integer.parseInt(req.getParameter("movieId"));
				
			
				
				//DeleteLikeService를 가져온다.
				DeleteLikeService deleteLikeService = DeleteLikeService.getInstance();
				
				deleteLikeService.delete(memberId, movieId);
				resp.sendRedirect(req.getContextPath() + "/member_like?pageNo=" + pageNo);
				
				return null;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		

		return null;
	}
}
