package model;

import java.time.LocalDateTime;

public class WatchaReview {
	
	private int reviewId;
	private Member member;
	private int star;
	private String review;
	private LocalDateTime wdate;
	private LocalDateTime udate;
	public int getReviewId() {
		return reviewId;
	}
	
	//생성자. DB에서 가져올 때 사용할 생성자
	public WatchaReview(int reviewId, Member member, int star, String review) {
		this.reviewId = reviewId;
		this.member = member;
		this.star = star;
		this.review = review;
	}
	
	//생성자. 작성할 때 사용할 생성자
	public WatchaReview(Member member, int star, String review) {
		this.member = member;
		this.star = star;
		this.review = review;
	}
	
	//getter, setter
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}
	
	public int getStar() {
		return star;
	}
	
	public void setStar(int star) {
		this.star = star;
	}
	
	public String getReview() {
		return review;
	}
	
	public void setReview(String review) {
		this.review = review;
	}
	
	public LocalDateTime getWdate() {
		return wdate;
	}
	
	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
	}
	
	public LocalDateTime getUdate() {
		return udate;
	}
	
	public void setUdate(LocalDateTime udate) {
		this.udate = udate;
	}
	
}
