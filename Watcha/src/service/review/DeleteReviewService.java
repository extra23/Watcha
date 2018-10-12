package service.review;

import java.sql.Connection;
import java.sql.SQLException;

import Exception.PermissionDeniedException;
import Exception.ReviewNotFoundException;
import dao.WatchaReviewDAO;
import jdbc.ConnectionProvider;
import model.WatchaReview;

public class DeleteReviewService {
	// 싱글톤
	private static DeleteReviewService instance = new DeleteReviewService( );
	private DeleteReviewService( ) { }
	public static DeleteReviewService getInstance( ) {
		return instance;
	}
	
	public void delete(int reviewId, int memberId) {
		WatchaReviewDAO reviewDAO =WatchaReviewDAO.getInstance( );
		
		try(Connection conn = ConnectionProvider.getConnection( )){
			try {
				conn.setAutoCommit(false);
				
				WatchaReview review = reviewDAO.selectById(conn, reviewId);
				// 게시글이 있는지 확인
				if(review == null) {
					throw new ReviewNotFoundException("리뷰가 없습니다");
				}
				// 사용자 권한이 있는지 확인
				if(review.getMemberId() != memberId) {
					throw new PermissionDeniedException("사용자 권한이 없음");
				}
				reviewDAO.delete(conn, reviewId);
				// reviewDAO 를 이용해서 게시글 삭제 메소드를 실행
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
