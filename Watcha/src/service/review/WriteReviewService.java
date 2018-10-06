package service.review;


import java.sql.Connection;
import java.sql.SQLException;

import dao.WatchaReviewDAO;
import jdbc.ConnectionProvider;

//리뷰를 작성하는 서비스
public class WriteReviewService {

	private static WriteReviewService instance = new WriteReviewService();
	public static WriteReviewService getInstance() {
		return instance;
	}
	private WriteReviewService () {}
	
	public void write(ReviewRequest reviewRequest) {
		
		WatchaReviewDAO watchaReviewDAO = WatchaReviewDAO.getInstance();
		
		try(Connection conn = ConnectionProvider.getConnection()){
			
			watchaReviewDAO.insert(conn, reviewRequest);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
