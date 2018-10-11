package service.review;

import model.WatchaReview;
import model.WatchaReviewContent;

// 리뷰 보기에 필요한 객체
public class ReviewData {
	private WatchaReview watchaReview; // 리뷰 테이블 내용
	
	public ReviewData(WatchaReview watchaReview) {
		this.watchaReview = watchaReview;
	}
	
	public WatchaReview getWatchaReview() {
		return watchaReview;
	}

}
