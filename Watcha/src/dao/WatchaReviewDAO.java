package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.WatchaReview;
import service.review.ReviewRequest;



public class WatchaReviewDAO {
	
	//싱글톤
	private static WatchaReviewDAO instance = new WatchaReviewDAO();
	public  static WatchaReviewDAO getInstance() {
		return instance;
	}
	private WatchaReviewDAO () {}
	
	//사용자 리뷰 추가
	public int insert(Connection conn, ReviewRequest reviewRequest) throws SQLException {
		String sql = "insert into watcha_review(member_id,star,review) values(?,?,?)";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, reviewRequest.getMemberId());
			pst.setInt(2, reviewRequest.getStar());
			pst.setString(3, reviewRequest.getReview());
			return pst.executeUpdate();
		}
	}
	
	//사용자 리뷰 삭제
	public int delete(Connection conn, int memberId) throws SQLException {
		String sql = "delete from watcha_review where member_id =?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, memberId);
			return pst.executeUpdate();
		}
	}
}
