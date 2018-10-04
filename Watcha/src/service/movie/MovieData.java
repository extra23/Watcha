package service.movie;

import java.util.Map;

import model.MovieDetail;
import model.MoviePre;

public class MovieData {
	
		//moviePre 테이블 내용
		private MoviePre moviePre;
		//MovieDetail 테이블 내용
		private MovieDetail movieDetail;
		
		//constructor
		public MovieData(MoviePre moviePre, MovieDetail movieDetail) {
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
		
		// 무결성 체크를 위한 메소드
		public void validate(Map<String, Boolean> errors) {
			if(moviePre.getTitle() == null || moviePre.getTitle().isEmpty()) {
				errors.put("title", true);
			}else if(moviePre.getReleaseDate() == null || moviePre.getReleaseDate().isEmpty()) {
				errors.put("releaseDate", true);
			}else if(moviePre.getFamousLine() == null || moviePre.getFamousLine().isEmpty()) {
				errors.put("famousLine", true);
			}else if()
		}
		
}
