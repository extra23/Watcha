package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WatchReviewDAO {
	
	//싱글톤
	private WatchReviewDAO instance = new WatchReviewDAO();
	public WatchReviewDAO getInstance() {
		return instance;
	}
	private WatchReviewDAO () {}
	
	//사용자 리뷰 삭제
	public int delete(Connection conn, int memberId) throws SQLException {
		String sql = "delete from watcha_review where memberId =?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, memberId);
			return pst.executeUpdate();
		}
	}
}
