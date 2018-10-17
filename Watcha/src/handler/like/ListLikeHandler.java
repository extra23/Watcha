package handler.like;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import model.MoviePre;
import service.account.AuthUser;
import service.like.DeleteLikeService;
import service.like.LikePage;
import service.like.ListLikeService;
import service.like.SelectLikeService;
import service.movie.ListMovieService;

public class ListLikeHandler implements CommandHandler{

	//페이지 번호를 파라미터로 받고 서비스를 이용해서 페이지 목록을  받아온다.
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, resp);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmint(req, resp);
		}else {
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	//member_like를 요청할 때 처리하는 메소드
	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		
		//ListLikeService객체 생성
		 ListLikeService listLikeService = ListLikeService.getInstance();
		 
		 String pageNoStr = req.getParameter("pageNo");
		 int pageNo =1;
		 if(pageNoStr != null) {
			 pageNo = Integer.parseInt(pageNoStr);
		 }
		 
		 
		 int memberId = ((AuthUser)req.getSession().getAttribute("authUser")).getMemberId();
		 
		 LikePage likePage = listLikeService.getLikePage(pageNo, memberId);
		 
		 req.setAttribute("likePage", likePage);
		
		 
		 //SelectLikeService 객체 생성
	
		 
		 SelectLikeService selectLikeService = SelectLikeService.getInstance();
		 
		 List<MoviePre> moviePreList = selectLikeService.getLikeList(memberId);
		 req.setAttribute("moviePreList", moviePreList);
		 
		return "/WEB-INF/view/member/member_like.jsp";
	}

	private String processSubmint(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		
		return null;
	}

}
