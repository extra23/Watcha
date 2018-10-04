package service.account;

import model.MovieDetail;
import model.MoviePre;

//게시글 보기에 필요한 객체
public class AccountData {
	
	//moviePre 테이블 내용
	private MoviePre moviePre;
	//MovieDetail 테이블 내용
	private MovieDetail movieDetail;
	
	//constructor
	public AccountData(MoviePre moviePre, MovieDetail movieDetail) {
		this.moviePre = moviePre;
		this.movieDetail = movieDetail;
	}

	//getter
	public MoviePre getMoviePre() {
		return moviePre;
	}

	public MovieDetail getMovieDetail() {
		return movieDetail;
	}
	
	
	

	
	
}
