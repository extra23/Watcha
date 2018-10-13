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
	
	public WatchaReview getReview(int memberId) {
		
		WatchaReviewDAO reviewDAO = WatchaReviewDAO.getInstance( );
		
		try(Connection conn= ConnectionProvider.getConnection( )){
			WatchaReview savedReview = reviewDAO.selectById(conn, memberId);
			if(savedReview == null) {
				throw new ReviewNotFoundException("review 없음");
			}
			return savedReview;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
