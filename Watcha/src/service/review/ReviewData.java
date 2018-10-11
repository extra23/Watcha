package service.review;

import model.WatchaReview;
import model.WatchaReviewContent;

// 리뷰 보기에 필요한 객체dd
public class ReviewData {
	private WatchaReview watchaReview; // 리뷰 테이블 내용
	private WatchaReviewContent content; // 리뷰 컨텐트 테이블 내용
	
	public ReviewData(WatchaReview watchaReview, WatchaReviewContent content) {
		this.watchaReview = watchaReview;
		this.content = content;
	}

	public WatchaReview getWatchaReview() {
		return watchaReview;
	}

	public String getContent() {
		return content.getContent( );
	}
	
	
}
