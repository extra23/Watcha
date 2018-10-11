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
	
	/*private int size = 10; // 한 페이지에 보여줄 게시물 개수
	private int blockSize = 5; // 한 페이지에서 보여줄 하단 페이지 링크의 개수
*/	
	
	public MoviePage getMoviePage(int pageNo, int genreId, int size, int blockSize) {
		
		try(Connection conn = ConnectionProvider.getConnection();){
			
			MoviePreDAO moviePreDAO = MoviePreDAO.getInstance();
			
			int total = 0;
			List<MoviePre> moviePreList = null;
			
			if(genreId == 0) {
				total = moviePreDAO.selectCount(conn);
				moviePreList = moviePreDAO.select(conn, (pageNo - 1) * size, size);
			}else {
				total = moviePreDAO.selectCount(conn, genreId);
				moviePreList = moviePreDAO.selectList(conn, genreId, (pageNo - 1) * size, size);
			}
			
			return new MoviePage(moviePreList, pageNo, total, size, blockSize);
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
