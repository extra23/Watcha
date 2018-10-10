package service.review;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.WatchaReviewDAO;
import jdbc.ConnectionProvider;
import model.WatchaReview;

public class ListMemberReviewService {
	
	// 싱글톤
	private static ListMemberReviewService instance = new ListMemberReviewService( );
	public static ListMemberReviewService getInstance( ) {
		return instance;
	}
	private ListMemberReviewService ( ) { }
	
	private int size = 5; // 한 페이지에 보여줄 리뷰 개수d
	private int blockSize = 5; // 한 페이지에서 보여줄 하단 페이지 링크의 개수
	
	public ReviewPage getReviewPage(int memberId, int pageNum) {
		try(Connection conn = ConnectionProvider.getConnection( )){
			WatchaReviewDAO watchReviewDAO = WatchaReviewDAO.getInstance( );
			int total = watchReviewDAO.selectMemberCount(conn, memberId);
			List<WatchaReview> reviewList = watchReviewDAO.selectList(conn, memberId, (pageNum-1)*size, size);
			return new ReviewPage(reviewList, pageNum, total, size, blockSize);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
