package service.like;

//watcha like작성하는 내용이 들어오는 객체
public class LikeRequest {

	private int  memberId;
	private int movieId;
	
	
	//생성자
	public LikeRequest(int memberId, int movieId) {
		this.memberId = memberId;
		this.movieId = movieId;
	}


	//getter
	public int getMemberId() {
		return memberId;
	}


	public int getMovieId() {
		return movieId;
	}
	
}
