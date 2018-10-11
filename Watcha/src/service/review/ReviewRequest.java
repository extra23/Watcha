package service.review;

import java.util.Map;

//review작성 하는 내용이 들어오는 객체d
public class ReviewRequest {

	private int memberId;
	private int movieId;
	private double star;
	private String review;
	
	public ReviewRequest(int memberId, int movieId, double star, String review) {
		this.memberId = memberId;
		this.movieId = movieId;
		this.star = star;
		this.review = review;
	}

	public int getMemberId() {
		return memberId;
	}

	public int getMovieId() {
		return movieId;
	}

	public double getStar() {
		return star;
	}

	public String getReview() {
		return review;
	}

	// 입력받은 데이터가 비었는지 확인하는 메소드
	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty()) {
			// 비거나 문제가 있다면 그 결과를 화면으로 다시 전송하기 위해서
			// 객체에 담아서 결과 화면에 보내줌.
			errors.put(fieldName, true); // fieldName -> 나중에 화면에서 출력하기 위한 변수명
		}
	}

	// 입력받은 데이터가 제대로 들어왔는지 검사하는 메소드
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, review, "review");
	}

}
