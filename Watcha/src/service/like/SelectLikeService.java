package service.like;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MoviePreDAO;
import dao.WatchaLikeDAO;
import jdbc.ConnectionProvider;
import model.MoviePre;

//보고싶어요한 영화에 대한 정보를 받아오는 서비스
public class SelectLikeService {

	// 싱글톤
	private static SelectLikeService instance = new SelectLikeService();

	private SelectLikeService() {
	}

	public static SelectLikeService getInstance() {
		return instance;
	}


	public List<MoviePre> getLikeList(int memberId) {

		/*// MoviePre를 담을 ArrayList를 생성
		List<MoviePre> moviePreList = new ArrayList<>();

		// movieId를 담을 ArrayList를 생성
		List<Integer> movieIdList = new ArrayList<>();

		// 사용할 MoviePreDao 객체 생성
		MoviePreDAO moviePreDAO = MoviePreDAO.getInstance();

		// 사용할 WatchaLikeDao 객체 생성임
		WatchaLikeDAO watchaLikeDAO = WatchaLikeDAO.getInstance();

		try (Connection conn = ConnectionProvider.getConnection()) {
			movieIdList = watchaLikeDAO.selectByIdToArr(conn, memberId);

			if (movieIdList != null) {
				for (int i = 0; i < movieIdList.size(); i++) {
					moviePreList.add(moviePreDAO.selectById(conn, movieIdList.get(i)));
				}
			}*/
		
		// 사용할 MoviePreDao 객체 생성
		MoviePreDAO moviePreDAO = MoviePreDAO.getInstance();
		
		List<MoviePre> moviePreList = new ArrayList<>();
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			moviePreList  = moviePreDAO.selectByLike(conn, memberId);
			
			return moviePreList ;
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return null;
	}

}
