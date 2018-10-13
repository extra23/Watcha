package model;

import java.time.LocalDateTime;

public class WatchaReview {
	
	private int reviewId;
	private int memberId;
	private String memberName;
	private int movieId;
	private String title;
	private double star;
	private String review;
	private LocalDateTime wdate;
	private LocalDateTime udate;
	
	
	//생성자 : DB에서 가져올 때 사용할 생성자 (watcha_review 테이블)
	public WatchaReview(int reviewId, int memberId, int movieId, String review, double star, LocalDateTime wdate, LocalDateTime udate) {
		this.reviewId = reviewId;
		this.movieId = movieId;
		this.memberId = memberId;
		this.star = star;
		this.review = review;
		this.wdate = wdate;
		this.udate = udate;
	}
	
	// 생성자 : DB에서 가져올 때 사용할 생성자 (watcha_review 테이블과 movie_pre 테이블 조인)
	public WatchaReview(int reviewId, int memberId, int movieId, String title, double star, String review, LocalDateTime wdate, LocalDateTime udate) {
		this.reviewId = reviewId;
		this.movieId = movieId;
		this.memberId = memberId;
		this.title = title;
		this.star = star;
		this.review = review;
		this.wdate = wdate;
		this.udate = udate;
	}
	
	// 생성자 : DB에서 가져올 때 사용할 생성자 (watcha_review 테이블과 member 테이블 조인)
	public WatchaReview(int reviewId, int memberId, String memberName, int movieId, double star, String review, LocalDateTime wdate, LocalDateTime udate) {
		this.reviewId = reviewId;
		this.memberId = memberId;
		this.memberName = memberName;
		this.movieId = movieId;
		this.star = star;
		this.review = review;
		this.wdate = wdate;
		this.udate = udate;
	}
	
	//생성자. 작성할 때 사용할 생성자
	public WatchaReview(int memberId, int movieId, double star, String review) {
		this.memberId = memberId;
		this.movieId = movieId;
		this.star = star;
		this.review = review;
	}

	//getter, setter
	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public double getStar() {
		return star;
	}
	
	public void setStar(double star) {
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
