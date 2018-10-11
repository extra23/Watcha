package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.WatchaReviewContent;

public class WatchaReviewContentDAO {
	private static WatchaReviewContentDAO instance = new WatchaReviewContentDAO( );
	private WatchaReviewContentDAO( ) { }
	public static WatchaReviewContentDAO getInstance( ) {
		return instance;
	}
	
	public WatchaReviewContent insert(Connection conn, WatchaReviewContent content) throws SQLException{
		String sql = "insert into watcha_review(member_id, review) values(?,?)";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, content.getMemberId());
			pst.setString(2, content.getContent( ));
			int insertedCount = pst.executeUpdate( );
			
			if(insertedCount > 0) {
				return content;
			}else {
				return null;
			}
		}
	}
	
	// 리뷰 내용을 가져오는 메소드
	public WatchaReviewContent selectById(Connection conn, int memberId) throws SQLException {
		String sql = "select *from watcha_review where memberId = ?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, memberId);
			try(ResultSet rs = pst.executeQuery( )){
				WatchaReviewContent content = null;
				if(rs.next( )) {
					content = new WatchaReviewContent(rs.getInt("memberId"),rs.getString("content"));
				}
				return content;	
			}
		}
	}
	
	// 내용을 수정하는 메소드
	public int update(Connection conn, int memberId, String content) throws SQLException {
		String sql = "update watcha_review set review = ? where member_id = ? ";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, content);
			pst.setInt(2, memberId);
			return pst.executeUpdate( );
		}
	}
	
	// 삭제하는 메소드
	public int delete(Connection conn, int memberId) throws SQLException {
		String sql = "delete from watcha_review where member_id = ?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, memberId);
			return pst.executeUpdate( );
		}
	}
	
}