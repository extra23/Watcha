package service.review;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.WatchaReviewDAO;
import jdbc.ConnectionProvider;
import model.WatchaReview;

public class ListReviewService {

	//싱글톤
	private static ListReviewService instance = new ListReviewService();
	public static ListReviewService getInstance() {
		return instance;
	}
	private ListReviewService () {}
	
	private int size = 3; //한 페이지에 보여줄 리뷰 개수
	private int blockSize = 5; //한 페이지에서 보여줄 하단 페이지 링크의 개수
	
	public ReviewPage getReviewPage(int pageNum) {
		try(Connection conn = ConnectionProvider.getConnection()){
			WatchaReviewDAO watchaReviewDAO = WatchaReviewDAO.getInstance();
			int total = watchaReviewDAO.selectCount(conn);
			List<WatchaReview> reviewList = watchaReviewDAO.select(conn, (pageNum-1)*size, size);
			return new ReviewPage(reviewList, pageNum, total, size, blockSize);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
