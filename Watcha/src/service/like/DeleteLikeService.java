package service.like;

import java.sql.Connection;
import java.sql.SQLException;

import dao.WatchaLikeDAO;
import jdbc.ConnectionProvider;
//보고싶어요한 영화를 삭제하는 서비스
public class DeleteLikeService {

	// 싱글톤
	private static DeleteLikeService instance = new DeleteLikeService();

	private DeleteLikeService() {
	}

	public static DeleteLikeService getInstance() {
		return instance;
	}

	public void delete(int memberId, int movieId) {
		WatchaLikeDAO watchaLikeDAO = WatchaLikeDAO.getInstance();

		try (Connection conn = ConnectionProvider.getConnection()) {
			conn.setAutoCommit(false);
		System.out.println("들어오니");
	
			System.out.println("여기는?");
			watchaLikeDAO.delete(conn, memberId, movieId);
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
