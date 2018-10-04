package service.movie;

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
		
}
