package service.movie;

import java.sql.Connection;
import java.sql.SQLException;

import Exception.InvalidPasswordException;
import Exception.MovieDetailNotFoundException;
import Exception.MoviePreNotFoundException;
import Exception.PermissionDeniedException;
import dao.MovieDetailDAO;
import dao.MoviePreDAO;
import jdbc.ConnectionProvider;
import model.MovieDetail;
import model.MoviePre;

public class DeleteMovieService {
	
	// 싱글톤 패턴 사용
	private static DeleteMovieService instance = new DeleteMovieService();
	private DeleteMovieService() {}
	public static DeleteMovieService getInstance() {
		return instance;
	}
	
	public void delete(int movieId, int memberRate, String authUserPwd, String inputPwd) {
		
		MoviePreDAO moviePreDAO = MoviePreDAO.getInstance();
		MovieDetailDAO movieDetailDAO = MovieDetailDAO.getInstance();
		
		try(Connection conn = ConnectionProvider.getConnection();){
			conn.setAutoCommit(false);
				// 삭제할 객체가 있는지 확인 (MoviePre)
				MoviePre moviePre = moviePreDAO.selectById(conn, movieId);
				if(moviePre == null) {
					throw new MoviePreNotFoundException("해당 MoviePre 찾을 수 없음");
				}
				// 삭제할 객체가 있는지 확인 (MovieDetail)
				MovieDetail movieDetail = movieDetailDAO.selectById(conn, movieId);
				if(movieDetail == null) {
					throw new MovieDetailNotFoundException("해당 MovieDetail 찾을 수 없음");
				}
				// 삭제하려는 사람이 권한이 있는지 확인
				if(memberRate != 0) {
					throw new PermissionDeniedException("권한 없음");
				}
				// 관리자 비밀번호 확인
				if(!authUserPwd.equals(inputPwd)) {
					throw new InvalidPasswordException("잘못된 비밀번호");
				}
				// 확인이 끝났다면 삭제
				moviePreDAO.delete(conn, movieId);
				movieDetailDAO.deleteMovieDetail(conn, movieId);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
