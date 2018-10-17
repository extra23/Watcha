package service.like;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Exception.DuplicateException;
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
			conn.setAutoCommit(false);
			try {
				List<Integer> movieIdArr = watchaLikeDAO.selectByIdToArr(conn, likeRequest.getMemberId());
				for(int movieId : movieIdArr) {
					if(movieId == likeRequest.getMovieId()) {
						conn.rollback();
						throw new DuplicateException("이미 찜한 영화입니다.");
					}	
				}
				watchaLikeDAO.insert(conn, likeRequest);
				conn.commit();
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}	
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
