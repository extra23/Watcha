package handler.like;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.DuplicateException;
import common.handler.CommandHandler;
import model.WatchaLike;
import service.account.AuthUser;
import service.like.LikeRequest;
import service.like.WriteLikeService;

//보고싶어요 한 영화에 대한 핸들러핸들러DS
public class WriteLikeHandler implements CommandHandler{

	private int movieId;

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		
		String pageNoStr = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoStr != null && !pageNoStr.isEmpty()) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		
		String genreIdStr = req.getParameter("genreId");
		int genreId = 0;
		if(genreIdStr != null && genreIdStr != "") {
			genreId = Integer.parseInt(genreIdStr);
		}
		
		String movieIdStr = req.getParameter("no");
		int movieId = 0;
		if(movieIdStr != null) {
			movieId = Integer.parseInt(movieIdStr);
		}

		int memberId = ((AuthUser)req.getSession().getAttribute("authUser")).getMemberId();
		LikeRequest likeRequest = new LikeRequest(memberId, movieId);
		
		WriteLikeService writeLikeService = WriteLikeService.getInstance();
		
		try{
			
			writeLikeService.write(likeRequest);
			pw.println("<script>alert('보고싶어요 목록에 추가되었습다 찜찜찜')</script>");
		}catch(DuplicateException e) {
			pw.println("<script>alert('이미 찜함')</script>");
		}
		
		pw.println("<script>location.href = '" + req.getContextPath()+"/movie_list?pageNo=" + pageNo + "&genreId=" + genreId + "'</script>");
		//resp.sendRedirect(req.getContextPath()+"/movie_list?pageNo=" + pageNo + "&genreId=" + genreId);
		
		return null;
		
	}
	

}
