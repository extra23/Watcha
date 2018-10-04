package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.MovieDetail;

public class MovieDetailDAO {

	// 싱글톤
	private static MovieDetailDAO instance = new MovieDetailDAO();

	public static MovieDetailDAO getInstance() {
		return instance;
	}

	private MovieDetailDAO() {
	}

	//movieDetail insert
	public MovieDetail insert(Connection conn, MovieDetail movieDetail) throws SQLException {
		String sql = "insert into movie_detail(movie_id,director,actor,genre_id,plot,trailer) values(?,?,?,?,?,?)";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, movieDetail.getMovieId());
			pst.setString(2, movieDetail.getDirector());
			pst.setString(3, movieDetail.getActor());
			pst.setInt(4, movieDetail.getGenreId());
			pst.setString(5, movieDetail.getPlot());
			pst.setString(6, movieDetail.getTrailer());
			
			int insertedCount = pst.executeUpdate();
			if( insertedCount>0) {
				return movieDetail;
			}else {
				return null;
			}

	}

	}
	//게시글 내용을 가져오는 메소드 
	public MovieDetail selectById(Connection conn, int movieId) throws SQLException {
		String sql = "select * from movie_detail where movie_id=?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, movieId);
			try(ResultSet rs = pst.executeQuery()){
				MovieDetail movieDetail = null;
				if(rs.next()) {
					movieDetail = new MovieDetail(rs.getInt("movie_id"), rs.getString("director"), rs.getString("actor"), rs.getInt("genre_id"), rs.getString("plot"), rs.getString("trailer"));
				}
				return movieDetail;
			}
		
	}
}
	
	
}
