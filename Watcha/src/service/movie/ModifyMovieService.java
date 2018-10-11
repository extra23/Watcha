package service.movie;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import Exception.MovieDetailNotFoundException;
import Exception.MoviePreNotFoundException;
import Exception.PermissionDeniedException;
import dao.MovieDetailDAO;
import dao.MoviePreDAO;
import jdbc.ConnectionProvider;
import model.MovieDetail;
import model.MoviePre;

public class ModifyMovieService {
	
	// 싱글톤 패턴 사용
	private static ModifyMovieService instance = new ModifyMovieService();
	private ModifyMovieService() {}
	public ModifyMovieService getInstance() {
		return instance;
	}
	
	public void modify(MovieData movieData, int memberRate) {
		
		MoviePreDAO moviePreDAO = MoviePreDAO.getInstance();
		MovieDetailDAO movieDetailDAO = MovieDetailDAO.getInstance();
		
		try(Connection conn = ConnectionProvider.getConnection();){
			conn.setAutoCommit(false);
				// 수정하려는 데이터가 존재하는지 확인 (MoviePre)
				MoviePre moviePre = moviePreDAO.selectById(conn, movieData.getMoviePre().getMovieId());
				if(moviePre == null) {
					throw new MoviePreNotFoundException("해당 moviePre 객체 없음");
				}
				// 수정하려는 데이터가 존재하는지 확인 (MovieDetail)
				MovieDetail movieDetail = movieDetailDAO.selectById(conn, movieData.getMoviePre().getMovieId());
				if(movieDetail == null) {
					throw new MovieDetailNotFoundException("해당 movieDetail 객체 없음");
				}
				// 수정하려는 주체가 권한을 가졌는지 확인
				if(memberRate != 0) {
					throw new PermissionDeniedException("수정할 권한이 없습니다.");
				}
				// 모두 확인되었으면 데이터 수정
				moviePreDAO.updateMoviePre(conn, movieData);
				movieDetailDAO.updateMovieDetail(conn, movieData);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
