package service.review;

public class ListReviewService {

	//싱글톤
	private static ListReviewService instance = new ListReviewService();
	public static ListReviewService getInstance() {
		return instance;
	}
	private ListReviewService () {}
	
	private int size = 3; //한 페이지에 보여줄 리뷰 개수
	private int blockSize = 5; //한 페이지에서 보여줄 하단 페이지 링크의 개수
	
	
}
