package service.movie;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MovieGenreDAO;
import jdbc.ConnectionProvider;
import model.MovieGenre;

public class ReadMovieGenreService {
	
	// 싱글톤
	private static ReadMovieGenreService instance = new ReadMovieGenreService();
	private ReadMovieGenreService() {}
	public static ReadMovieGenreService getInstance() {
		return instance;
	}
	
	// movie_genre 테이블의 모든 내용을 읽어와 List<MovieGenre> 형태로 반환하는 메소드
	public List<MovieGenre> readMovieGenre(){
		
		List<MovieGenre> movieGenreList = null;
		
		MovieGenreDAO movieGenreDAO = MovieGenreDAO.getInstance();
		
		try(Connection conn = ConnectionProvider.getConnection();){
			movieGenreList = movieGenreDAO.selectMovieGenreList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return movieGenreList;
		
	}

}
