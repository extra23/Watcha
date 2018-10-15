package service.review;

import java.sql.Connection;
import java.sql.SQLException;

import Exception.LoginFailException;
import Exception.PermissionDeniedException;
import Exception.ReviewNotFoundException;
import dao.MemberDAO;
import dao.WatchaReviewDAO;
import jdbc.ConnectionProvider;
import model.Member;
import model.WatchaReview;

public class DeleteReviewService {
	// 싱글톤
	private static DeleteReviewService instance = new DeleteReviewService( );
	private DeleteReviewService( ) { }
	public static DeleteReviewService getInstance( ) {
		return instance;
	}
	
	public void delete(int reviewId, int memberId, String password) {
		System.out.println("서비스로 들어옴");
		WatchaReviewDAO reviewDAO =WatchaReviewDAO.getInstance( );
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		try(Connection conn = ConnectionProvider.getConnection( )){
			try {
				conn.setAutoCommit(false);
				
				WatchaReview review = reviewDAO.selectById(conn, reviewId);
				
				// userId를 이용하여 Member 객체를 select 해옴
				Member member = memberDAO.selectMember(conn, memberId);
				
				// 게시글이 있는지 확인
				if(review == null) {
					System.out.println("오류 발생, 삭제할 리뷰 없어");
					throw new ReviewNotFoundException("리뷰가 없습니다");
				}
				// 사용자 권한이 있는지 확인
				if(review.getMemberId() != memberId) {
					System.out.println("오류 발생, 삭제하는 사람이 작성한 사람이 아니야");
					throw new PermissionDeniedException("사용자 권한이 없음");
				}
				
				// 비밀번호 확인
				if(!member.matchPassword(password)) {
					throw new LoginFailException("비밀번호가 일치하지 않음");
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
