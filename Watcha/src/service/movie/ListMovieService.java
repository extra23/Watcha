package service.movie;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.MoviePreDAO;
import jdbc.ConnectionProvider;
import model.MoviePre;

public class ListMovieService {

	// 싱글톤
	private static ListMovieService instance = new ListMovieService( );
	private ListMovieService( ) { }
	public static ListMovieService getInstance( ) {
		return instance;
	}
	
	private int size = 10; // 한 페이지에 보여줄 게시물 개수
	private int blockSize = 5; // 한 페이지에서 보여줄 하단 페이지 링크의 개수
	
	public MoviePage getMoviePage(int pageNum) {
		try(Connection conn = ConnectionProvider.getConnection( )){
			MoviePreDAO movieDAO = MoviePreDAO.getInstance( );
			int total =movieDAO.selectCount(conn);
			List<MoviePre> movieList = movieDAO.select(conn, (pageNum - 1)* size, size);
			return new MoviePage(movieList, pageNum, total, size, blockSize);
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
