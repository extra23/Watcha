package service.movie;

import java.sql.Connection;
import java.sql.SQLException;

import Exception.MovieDetailNotFoundException;
import Exception.MoviePreNotFoundException;
import dao.MovieDetailDAO;
import dao.MoviePreDAO;
import jdbc.ConnectionProvider;
import model.MovieDetail;
import model.MoviePre;

public class ReadMovieService {

	//싱글톤
	private static ReadMovieService instance = new ReadMovieService();
	private ReadMovieService() {
	}
	public static ReadMovieService getInstance() {
		return instance;
	}

	//한 편의 movie를 읽어오는 메소드
	public MovieData getMovie(int movieId) {

		MoviePreDAO moviePreDAO = MoviePreDAO.getInstance();
		MovieDetailDAO movieDetailDAO = MovieDetailDAO.getInstance();

		try (Connection conn = ConnectionProvider.getConnection()) {
			MoviePre moviePre = moviePreDAO.selectById(conn, movieId);
			
			if (moviePre == null) {
				throw new MoviePreNotFoundException("moviePre이 없음");
			}

			MovieDetail movieDetail = movieDetailDAO.selectById(conn, movieId);
			
			if (movieDetail ==null) {
				throw new MovieDetailNotFoundException("movieDetail이 없음");
			}

			return new MovieData(moviePre, movieDetail);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}