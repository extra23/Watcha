package service.like;

import java.sql.Connection;
import java.sql.SQLException;

import dao.WatchaLikeDAO;
import jdbc.ConnectionProvider;

//보고싶어요 한 영화에 대한 서비스
public class WriteLikeService {
		
	//싱글톤
	private static WriteLikeService instance = new WriteLikeService();
	private WriteLikeService () {}
	public static WriteLikeService getInstance() {
		return instance;
	}
	
	public void write(LikeRequest likeRequest) {
		
		WatchaLikeDAO watchaLikeDAO = WatchaLikeDAO.getInstance();
		
		try(Connection conn = ConnectionProvider.getConnection()){
			
			watchaLikeDAO.insert(conn, likeRequest);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
}
