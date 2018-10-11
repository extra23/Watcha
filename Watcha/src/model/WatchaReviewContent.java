package model;

// 리뷰 내용을 담는 객체
public class WatchaReviewContent {
	private int memberId;
	private String content;
	public WatchaReviewContent(int memberId, String content) {
		this.memberId = memberId;
		this.content = content;
	}
	public int getMemberId() {
		return memberId;
	}
	public String getContent() {
		return content;
	}
	
}
