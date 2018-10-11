package service.review;

import java.sql.Connection;
import java.sql.SQLException;

import Exception.ReviewContentNotFoundException;
import Exception.ReviewNotFoundException;
import dao.WatchaReviewContentDAO;
import dao.WatchaReviewDAO;
import jdbc.ConnectionProvider;
import model.WatchaReview;
import model.WatchaReviewContent;

public class ReadReviewService {
	private static ReadReviewService instance = new ReadReviewService( );
	private ReadReviewService ( ) { }
	public static ReadReviewService getInstance( ) {
		return instance;
	}
	
	public ReviewData getReview(int reviewId, boolean increaseReadCount) {
		WatchaReviewDAO reviewDAO = WatchaReviewDAO.getInstance( );
		WatchaReviewContentDAO contentDAO = WatchaReviewContentDAO.getInstance( );
		try(Connection conn= ConnectionProvider.getConnection( )){
			WatchaReview review = reviewDAO.selectById(conn, reviewId);
			if(review == null) {
				throw new ReviewNotFoundException("review 없음");
			}
			WatchaReviewContent reviewContent = contentDAO.selectById(conn, reviewId);
			if(reviewContent == null) {
				throw new ReviewContentNotFoundException("content 없음");
			}
			return new ReviewData(review, reviewContent);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
