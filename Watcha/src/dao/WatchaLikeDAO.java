package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WatchaLikeDAO {
	
	//싱글톤
	private WatchaLikeDAO instance = new WatchaLikeDAO();
	public WatchaLikeDAO getInstance() {
		return instance;
	}
	private WatchaLikeDAO () {}
	
	//사용자가 보고싶다고한 작품 삭제
	public int delete(Connection conn, int memberId) throws SQLException {
		String sql = "delete from watcha_like where memberId =?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, memberId);
			return pst.executeUpdate();
		}
	}
}
