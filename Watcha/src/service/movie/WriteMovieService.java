package service.movie;

import java.sql.Connection;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import dao.MovieDetailDAO;
import dao.MoviePreDAO;
import jdbc.ConnectionProvider;
import model.MovieDetail;
import model.MoviePre;

public class WriteMovieService {
	
	// 싱글톤
	private static WriteMovieService instance = new WriteMovieService();
	private WriteMovieService() {};
	public static WriteMovieService getInstance() {
		return instance;
	}
	
	public int write(MovieData movieData) {
		
		// 게시글의 테이블이 두개가 있고, 두 개의 movieId는 같아야 무결성을 해치지 않음.
				// 따라서 두개의 movieId는 동기화 되어야 하고, movie_pre에 삽입 되었을 때 movieId가 생성되기 때문에 삽입 후 select를 하여 movieId를 받아옴
				// 그리고 그 movieId를 movie_detail 테이블에 삽입 시 사용하여 movieId가 같도록 처리함
		try(Connection conn = ConnectionProvider.getConnection();){
			
			MoviePreDAO moviePreDAO = MoviePreDAO.getInstance();
			MovieDetailDAO movieDetailDAO = MovieDetailDAO.getInstance();
			
			// 트랜잭션 사용 시 Connection이 close되기 전에 rollback을 해줘야하기 때문에 
				// 트랜잭션 사용 이유 : movie_pre 테이블에 데이터 넣는 것이 성공하고 movie_detail 테이블에 데이터 넣는 것이 실패하면 두 테이블에서 전부 데이터를 빼주어야 함
			try{
				conn.setAutoCommit(false);
					 MoviePre moviePre = new MoviePre(movieData.getMoviePre().getMovieId(), movieData.getMoviePre().getTitle(), movieData.getMoviePre().getTime(), movieData.getMoviePre().getReleaseDate(), movieData.getMoviePre().getRate(), movieData.getMoviePre().getFamousLine(), movieData.getMoviePre().getImageName());
					 MoviePre savedMoviePre = moviePreDAO.insert(conn, moviePre);
					 if(savedMoviePre == null) {
						 throw new RuntimeException("Movie_Pre insert fail");
					 }
					 MovieDetail movieDetail = new MovieDetail(savedMoviePre.getMovieId(), movieData.getMovieDetail().getDirector(), movieData.getMovieDetail().getActor(), movieData.getMovieDetail().getGenreId(), movieData.getMovieDetail().getPlot(), movieData.getMovieDetail().getTrailer());
					 MovieDetail savedMovieDatail = movieDetailDAO.insert(conn, movieDetail);
					 if(savedMovieDatail == null) {
						 throw new RuntimeException("Movie_Detail insert fail");
					 }
				conn.commit();
				return savedMoviePre.getMovieId();
			}catch (SQLException e) {
				conn.rollback();
				throw new RuntimeException(e);
			}catch (RuntimeException e) {
				conn.rollback();
				throw e;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;

	}

}
