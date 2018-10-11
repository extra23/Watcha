package service.review;

import java.sql.Connection;
import java.sql.SQLException;

import Exception.PermissionDeniedException;
import Exception.ReviewNotFoundException;
import dao.WatchaReviewContentDAO;
import dao.WatchaReviewDAO;
import jdbc.ConnectionProvider;
import model.WatchaReview;

public class DeleteReviewService {
	// 싱글톤dd
	private static DeleteReviewService instance = new DeleteReviewService( );
	private DeleteReviewService( ) { }
	public static DeleteReviewService getInstance( ) {
		return instance;
	}
	
	public void delete(ReviewRequest dr) {
		WatchaReviewDAO reviewDAO =WatchaReviewDAO.getInstance( );
		WatchaReviewContentDAO contentDAO = WatchaReviewContentDAO.getInstance( );
		
		try(Connection conn = ConnectionProvider.getConnection( )){
			try {
				conn.setAutoCommit(false);
				
				WatchaReview review = reviewDAO.selectById(conn, dr.getMemberId( ));
				// 게시글이 있는지 확인
				if(review == null) {
					throw new ReviewNotFoundException("리뷰가 없습니다");
				}
				// 사용자 권한이 있는지 확인
				if(review.getMemberId() != dr.getMemberId()) {
					throw new PermissionDeniedException("사용자 권한이 없음");
				}
				reviewDAO.delete(conn, dr.getMemberId( ));
				contentDAO.delete(conn, dr.getMemberId( ));
				// reviewDAO, contentDAO 를 이용해서 게시글 삭제 메소드를 실행
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
