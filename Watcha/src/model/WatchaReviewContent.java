package model;

// 리뷰 내용을 담는 객체
public class WatchaReviewContent {
	private int reviewId;
	private String content;
	public WatchaReviewContent(int reviewId, String content) {
		this.reviewId = reviewId;
		this.content = content;
	}
	public int getReviewId() {
		return reviewId;
	}
	public String getContent() {
		return content;
	}
	
}
