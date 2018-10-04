package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WatchaReviewDAO {
	
	//싱글톤
	private static WatchaReviewDAO instance = new WatchaReviewDAO();
	public  static WatchaReviewDAO getInstance() {
		return instance;
	}
	private WatchaReviewDAO () {}
	
	//사용자 리뷰 삭제
	public int delete(Connection conn, int memberId) throws SQLException {
		String sql = "delete from watcha_review where memberId =?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, memberId);
			return pst.executeUpdate();
		}
	}
}