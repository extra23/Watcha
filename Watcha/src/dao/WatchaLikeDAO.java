package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.WatchaLike;
import service.like.LikeRequest;

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
	
	// 게시글 내용을 가져오는 메소드
	public WatchaLike selectById(Connection conn, int likeId) throws SQLException {
		String sql = "select * from movie_like where like_id = ? ";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, likeId);
			try (ResultSet rs = pst.executeQuery()) {
				WatchaLike like = null;
				if (rs.next()) {
					like = new WatchaLike(rs.getInt("like_id"), rs.getInt("member_id"), rs.getInt("movie_id"),
							rs.getBoolean("saw"));
				}
				return like;
			}
		}
	}
	
	// like update  메소드
	public int update(Connection conn, int likeId) throws SQLException {
		String sql = "update movie_like set title = ? where like_id = ? ";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, likeId);
			return pst.executeUpdate();
		}
	}
	
	//like insert 메소드
	public int insert(Connection conn, LikeRequest likeRequest) throws SQLException {
		String sql = "insert into watcha_like(member_Id,movie_id) values(?,?)";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, likeRequest.getMemberId());
			pst.setInt(2, likeRequest.getMovieId());
			return pst.executeUpdate();
		}
	}
	
	
}
