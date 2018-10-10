package service.movie;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exception.MoviePreNotFoundException;
import dao.MoviePreDAO;
import jdbc.ConnectionProvider;
import model.MoviePre;

public class SelectMovieService {
	
	private static SelectMovieService instance = new SelectMovieService();
	private SelectMovieService() {}
	public static SelectMovieService getInstance() {
		return instance;
	}
	
	private int size = 10;
	private int blockSize = 5;
	
	public List<MoviePre> getMoviePreList(int genreId, String searchWord){
		
		// MoviePre를 담을 ArrayList 생성
		List<MoviePre> moviePreList = null;
		
		// 사용할 MoviePreDAO 객체 생성
		MoviePreDAO moviePreDAO = MoviePreDAO.getInstance();
		
		try(Connection conn = ConnectionProvider.getConnection();){
			
			if(genreId == 0) {
				moviePreList = moviePreDAO.selectMoviePreList(conn, searchWord);
			}else {
				moviePreList = moviePreDAO.selectMoviePreList(conn, genreId, searchWord);
			}
			
			if(moviePreList == null) {
				throw new MoviePreNotFoundException("해당 MoviePre(MoviePreList)를 찾을 수 없습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return moviePreList;
		
	}

}
