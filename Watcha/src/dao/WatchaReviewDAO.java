package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.WatchaReview;
import service.review.ReviewRequest;

public class WatchaReviewDAO {

	// 싱글톤
	private static WatchaReviewDAO instance = new WatchaReviewDAO();

	public static WatchaReviewDAO getInstance() {
		return instance;
	}

	private WatchaReviewDAO() {
	}

	// 사용자 리뷰 추가
	public int insert(Connection conn, ReviewRequest reviewRequest) throws SQLException {
		String sql = "insert into watcha_review(member_id, movie_id, star, review) values(?, ?, ?, ?)";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, reviewRequest.getMemberId());
			pst.setInt(2, reviewRequest.getMovieId());
			pst.setDouble(3, reviewRequest.getStar());
			pst.setString(4, reviewRequest.getReview());
			return pst.executeUpdate();
		}
	}

	// (movie_id에 상관없이) watcha_review의 전체 tuple수를 가져오는 메소드
	public int selectCount(Connection conn) throws SQLException {
		String sql = "select count(*) from watcha_review";
		try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
			if (rs.next()) {
				return rs.getInt(1);
			}
		}
		return 0;
	}
	
	// (member_id에 따라서) watcha_review의 전체 tuple수를 가져오는 메소드
	public int selectCount(Connection conn, int memberId) throws SQLException {
		String sql = "select count(*) from watcha_review where member_id = ?";
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, memberId);
			try(ResultSet rs = pst.executeQuery();){
				if(rs.next()) {
					return rs.getInt(1);
				}
			}
		}
		return 0;
	}

	// (movie_id에 상관없이) 리미트를 이용한 리스트를 가져오는 쿼리
	public List<WatchaReview> select(Connection conn, int StartRow, int size) throws SQLException {
		String sql = "select * from watcha_review order by review_id desc limit ?,?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, StartRow);
			pst.setInt(2, size);
			try (ResultSet rs = pst.executeQuery()) {
				List<WatchaReview> reviewList = new ArrayList<WatchaReview>();
				while (rs.next()) {
					reviewList.add(convReview(rs, 0));
				}
				return reviewList;
			}
		}
	}
	
	// (member_id에 따라서) 리미트를 이용한 List<WatchaReview>를 가져오는 쿼리를 날리는 메소드
	public List<WatchaReview> selectList(Connection conn, int memberId, int startRow, int size) throws SQLException{
		String sql = "select * from watcha_review join movie_pre on watcha_review.movie_id = movie_pre.movie_id where watcha_review.member_id = ? limit ?, ?";
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, memberId);
			pst.setInt(2, startRow);
			pst.setInt(3, size);
			try(ResultSet rs = pst.executeQuery();){
				List<WatchaReview> reviewList = new ArrayList<>();
				while(rs.next()) {
					reviewList.add(convReview(rs, 1));
				}
				return reviewList;
			}
		}
	}
	
	//review_id로 특정 리뷰를 가져오는 메소드
	public WatchaReview selectById(Connection conn, int reviewId) throws SQLException {
		String sql = "select * from watcha_review where review_id = ?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, reviewId);
			try(ResultSet rs = pst.executeQuery()){
				WatchaReview watchaReview = null;
				if(rs.next()) {
					watchaReview = convReview(rs, 0);
				}
				return watchaReview;
			}
		}
	}

	// 사용자 리뷰 삭제
	public int delete(Connection conn, int reviewId) throws SQLException {
		String sql = "delete from watcha_review where review_id =?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, reviewId);
			return pst.executeUpdate();
		}
	}
	
	// member_id select하는 메소드
	public WatchaReview selectByMemberId(Connection conn, int memberId) throws SQLException {
		String sql = "select * from watcha_review where member_id = ?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, memberId);
			try(ResultSet rs = pst.executeQuery()){
				WatchaReview watchaReview = null;
				if(rs.next()) {
					watchaReview = convReview(rs, 0);
				}
				return watchaReview;
			}
		}
	}	
	
	// (member_id에 따라서) watcha_review의 전체 tuple수를 가져오는 메소드
	public int selectMemberCount(Connection conn, int memberId) throws SQLException {
		String sql = "select count(*) from watcha_review where member_id = ?";
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, memberId);
			try(ResultSet rs = pst.executeQuery();){
				if(rs.next()) {
					return rs.getInt(1);
				}
			}
		}
		return 0;
	}

	//ResultSet으로 나온결과를 Watcha_review객체로 생성해서 담는 메소드
	private WatchaReview convReview(ResultSet rs, int flag) throws SQLException {
		
		WatchaReview watchaReview = null;
		
		if(flag == 0) {
			watchaReview = new WatchaReview(rs.getInt("review_id"), rs.getInt("member_id"), rs.getInt("movie_id"), rs.getString("review"), rs.getDouble("star"), rs.getTimestamp("wdate").toLocalDateTime(), rs.getTimestamp("udate").toLocalDateTime());
		}else {
			watchaReview = new WatchaReview(rs.getInt("review_id"),
					rs.getInt("member_id"),
					rs.getInt("movie_id"),
					rs.getString("title"),
					rs.getDouble("star"), 
					rs.getString("review"), rs.getTimestamp("wdate").toLocalDateTime(), rs.getTimestamp("udate").toLocalDateTime());
		}
		
		return watchaReview;
		
	}
}
