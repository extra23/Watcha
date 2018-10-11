package handler.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import model.WatchaLike;
import service.account.AuthUser;
import service.like.LikeRequest;
import service.like.WriteLikeService;

//보고싶어요 한 영화에 대한 핸들러핸들러
public class WriteLikeHandler implements CommandHandler{

	private int movieId;

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String pageNoStr = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoStr != null && !pageNoStr.isEmpty()) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		
		System.out.println("페이지넘버 : " + pageNo);
		
		String genreIdStr = req.getParameter("genreId");
		int genreId = 0;
		if(genreIdStr != null && genreIdStr != "") {
			genreId = Integer.parseInt(genreIdStr);
		}
		
		System.out.println("장르 아이디 : " + genreId);
		
		String movieIdStr = req.getParameter("no");
		int movieId = 0;
		if(movieIdStr != null) {
			movieId = Integer.parseInt(movieIdStr);
		}

		int memberId = ((AuthUser)req.getSession().getAttribute("authUser")).getMemberId();
		LikeRequest likeRequest = new LikeRequest(memberId, movieId);
		
		WriteLikeService writeLikeService = WriteLikeService.getInstance();
		writeLikeService.write(likeRequest);
		
		resp.sendRedirect(req.getContextPath()+"/movie_list?pageNo=" + pageNo + "&genreId=" + genreId);
		
		return null;
		
	}
	

}
