package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WatchaLikeDAO {
	
	//싱글톤
	private static WatchaLikeDAO instance = new WatchaLikeDAO();
	public static WatchaLikeDAO getInstance() {
		return instance;
	}
	private WatchaLikeDAO () {}
	
	//사용자가 보고싶다고한 작품 삭제하자.
	public int delete(Connection conn, int memberId) throws SQLException {
		String sql = "delete from watcha_like where member_id =?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, memberId);
			return pst.executeUpdate();
		}
	}
}
