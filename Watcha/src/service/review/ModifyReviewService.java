package service.review;

import java.sql.Connection;
import java.sql.SQLException;

import Exception.PermissionDeniedException;
import Exception.ReviewNotFoundException;
import dao.WatchaReviewDAO;
import jdbc.ConnectionProvider;
import model.WatchaReview;

public class ModifyReviewService {
	// 싱글톤
	private static ModifyReviewService instance = new ModifyReviewService( );
	private ModifyReviewService( ) { }
	public static ModifyReviewService getInstance( ) {
		return instance;
	}

	public void modify(int reviewId, int memberId) {
		WatchaReviewDAO reviewDAO = WatchaReviewDAO.getInstance( );
		
		try(Connection conn = ConnectionProvider.getConnection( )){
			try {
				conn.setAutoCommit(false);
				
				WatchaReview savedWatchaReview = reviewDAO.selectById(conn, reviewId);
			
				// 게시글이 있는지 확인
				if(savedWatchaReview == null) {
					throw new ReviewNotFoundException("리뷰가 없습니다");
				}
				// 사용자 권한이 있는지 확인
				if(savedWatchaReview.getMemberId() != memberId) {
					throw new PermissionDeniedException("사용자 권한이 없음");
				}
				reviewDAO.update(conn, reviewId, savedWatchaReview.getReview());
				conn.commit( );
		}catch (SQLException e) {
			conn.rollback( );
			throw new RuntimeException(e);
		}catch(PermissionDeniedException e) {
			conn.rollback( );
			throw e;
		}
	}catch (SQLException e) {
		throw new RuntimeException(e);
	}
}
}