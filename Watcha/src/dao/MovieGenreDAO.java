package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.MovieGenre;

public class MovieGenreDAO {

	// 싱글톤
	private static MovieGenreDAO instance = new MovieGenreDAO();
	private MovieGenreDAO() {}
	public static MovieGenreDAO getInstance() {
		return instance;
	}
	
	// genreId를 이용하여 movie_genre테이블에서 genre_name을 select해오는 쿼리를 날리는 메소드
	public String selectMovieGenre(Connection conn, int movieId) throws SQLException {
		
		String sql = "select genre_name from movie_genre where genre_id = ?";
		
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, movieId);
			try(ResultSet rs = pst.executeQuery();){
				if(rs.next()) {
					return rs.getString("genre_name");
				}
			}
		}
		
		return null;
		
	}
	
	// movie_genre 테이블의 전체 내용을 List로 읽어오는 메소드
	public List<MovieGenre> selectMovieGenreList(Connection conn) throws SQLException{
		
		String sql = "select * from movie_genre";
		
		List<MovieGenre> movieGenreList = new ArrayList<>();
		
		try(Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);){
			while(rs.next()) {
				movieGenreList.add(new MovieGenre(rs.getInt("genre_id"), rs.getString("genre_name")));
			}
		}
		
		return movieGenreList;
		
	}
	
}
