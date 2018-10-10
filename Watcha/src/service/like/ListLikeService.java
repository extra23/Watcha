package service.like;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.WatchaLikeDAO;
import jdbc.ConnectionProvider;
import model.WatchaLike;

public class ListLikeService {
	
	//싱글톤  
	private static ListLikeService instance = new ListLikeService();
	private ListLikeService () {}
	public static ListLikeService getInstance() {
		return instance;
	}
	
	private int size = 10; //한 페이지에 보여줄 게시물 개수
	private int blockSize = 5; //한 페이지에서 보여줄 하단 페이지 링크의 개수
	
	public LikePage getLikePage(int pageNo, int memberId) {
		
		try(Connection conn = ConnectionProvider.getConnection()){
			WatchaLikeDAO watchaLikeDAO = WatchaLikeDAO.getInstance();
			
			int total = 0;
			List<WatchaLike> likeList = null;
			
			total = watchaLikeDAO.selectCount(conn, memberId);
			likeList = watchaLikeDAO.select(conn, (pageNo - 1), size);
			
			return new LikePage(likeList, pageNo, total, size, blockSize);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
}
