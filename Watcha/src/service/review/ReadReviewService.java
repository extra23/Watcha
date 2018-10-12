package service.review;

import java.sql.Connection;
import java.sql.SQLException;


import Exception.ReviewNotFoundException;
import dao.WatchaReviewDAO;
import jdbc.ConnectionProvider;
import model.WatchaReview;


public class ReadReviewService {
	private static ReadReviewService instance = new ReadReviewService( );
	private ReadReviewService ( ) { }
	public static ReadReviewService getInstance( ) {
		return instance;
	}
	
	public ReviewData getReview(int memberId) {
		WatchaReviewDAO reviewDAO = WatchaReviewDAO.getInstance( );
		
		try(Connection conn= ConnectionProvider.getConnection( )){
			WatchaReview review = reviewDAO.selectById(conn, memberId);
			if(review == null) {
				throw new ReviewNotFoundException("review 없음");
			}
			return new ReviewData(review);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
