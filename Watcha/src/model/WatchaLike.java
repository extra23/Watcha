package model;

public class WatchaLike {
	
	private int likeId;
	private int memberId;
	private int movieId;
	private boolean saw;
	
	public WatchaLike(int likeId, int memberId, int movieId, boolean saw) {
		this.likeId = likeId;
		this.memberId = memberId;
		this.movieId = movieId;
		this.saw = saw;
	}
	
	public int getLikeId() {
		return likeId;
	}
	
	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	public boolean getSaw() {
		return saw;
	}
	
	public void setSaw(boolean saw) {
		this.saw = saw;
	}

}
