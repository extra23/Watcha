package handler.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import model.WatchaLike;
import service.like.LikeRequest;
import service.like.WriteLikeService;

//보고싶어요 한 영화에 대한 핸들러
public class WriteLikeHandler implements CommandHandler{

	private int movieId;

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		/*//에러
		Map<String, Boolean>errors = new HashMap<>();
		req.setAttribute("errors", errors);
		*/
		
		//movieId받아오기
		int movieId = Integer.parseInt(req.getParameter("no"));
		this.movieId = movieId;
		
		
		if(movieId==0) {
			throw new RuntimeException();
		}

		
		WatchaLike watchaLike = (WatchaLike)req.getSession().getAttribute("watchaLike");
		LikeRequest likeRequest = new LikeRequest(watchaLike.getMemberId(), watchaLike.getMovieId());
		
		
		
		WriteLikeService writeLikeService = WriteLikeService.getInstance();
		writeLikeService.write(likeRequest);
		
		resp.sendRedirect(req.getContextPath()+"/movie?no="+this.movieId);
		
		return null;
		
	}
	

}
