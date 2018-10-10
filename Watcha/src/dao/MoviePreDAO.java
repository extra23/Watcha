package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.MoviePre;


public class MoviePreDAO {
	private static MoviePreDAO instance = new MoviePreDAO();
	private MoviePreDAO() {}
	public static MoviePreDAO getInstance() {
		return instance;
	}

	// movie_pre 테이블에 insert 쿼리를 날리는 메소드
	public MoviePre insert(Connection conn, MoviePre moviePre) throws SQLException {
		
		String Sql = "insert into movie_pre(title, genre_id, time, release_date, rate, famous_line, image_name, search_word1, search_word2, search_word2) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement pst = conn.prepareStatement(Sql);
				Statement st = conn.createStatement()){
					pst.setString(1, moviePre.getTitle());
					pst.setInt(2, moviePre.getGenreId());
					pst.setInt(3, moviePre.getTime());
					pst.setString(4, moviePre.getReleaseDate());
					pst.setInt(5, moviePre.getRate());
					pst.setString(6, moviePre.getFamousLine());
					pst.setString(7, moviePre.getImageName());
					pst.setString(8, moviePre.getSearchWord1());
					pst.setString(9, moviePre.getSearchWord2());
					pst.setString(10, moviePre.getSearchWord3());
					int insertedCount = pst.executeUpdate();

				if(insertedCount > 0) {
					try(ResultSet rs = st.executeQuery("select last_insert_id() from movie_pre")){
						if(rs.next()) {
							int movieId = rs.getInt(1);
							moviePre.setMovieId(movieId);
							return moviePre;
						}
					}				
				}
				
				return null;	
		}
		
	}
	
	// (genre_id에 관계없이) movie_pre의 tuple 수를 가져오는 메소드
	public int selectCount(Connection conn) throws SQLException {
		String sql = "select count(*) from movie_pre";
		try(Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql)){
			if(rs.next()) {
				return rs.getInt(1);
			}
		}	
		return 0;		
	}
	
	// (genre_id에 따라서) movie_pre의 tuple 수를 가져오는 메소드
	public int selectCount(Connection conn, int genreId) throws SQLException {
		String sql = "select count(*) from movie_pre where genre_id = ?";
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, genreId);
			try(ResultSet rs = pst.executeQuery();){
				if(rs.next()) {
					return rs.getInt(1);
				}
			}
		}
		return 0;
	}

	// (genre_id에 상관 없이) 리미트를 이용한 리스트를 가져오는 쿼리
	public List<MoviePre> select(Connection conn , int StarRow , int size) throws SQLException{
		String sql = "select * from movie_pre order by movie_id desc limit ?, ?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, StarRow);
			pst.setInt(2, size);
			try(ResultSet rs = pst.executeQuery()){
				List<MoviePre> movieList = new ArrayList<MoviePre>();
				while(rs.next()) {
					movieList.add(convMoviePre(rs));
				}
				return movieList;
			}
		}
	}
	
	// (genre_id에 따라) movie_pre의 데이터를 분류해서 가져오는 쿼리를 날리는 메소드 (limit 사용)
	public List<MoviePre> selectList(Connection conn, int genreId, int startRow, int size) throws SQLException{
		String sql = "select * from movie_pre where genre_id = ? order by movie_id desc limit ?, ?";
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, genreId);
			pst.setInt(2, startRow);
			pst.setInt(3, size);
			try(ResultSet rs = pst.executeQuery();){
				List<MoviePre> moviePreList = new ArrayList<>();
				while(rs.next()) {
					moviePreList.add(convMoviePre(rs));
				}
				return moviePreList;
			}
		}
	}

	// movie_id로 특정 MoviePre 객체를 가져오는 메소드
	public MoviePre selectById(Connection conn, int no) throws SQLException {
		String sql = "select * from movie_pre where movie_id  =? ";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, no);
			try(ResultSet rs = pst.executeQuery()){
				MoviePre moviePre = null;
			if(rs.next()) {
				moviePre = convMoviePre(rs);
				}
			return moviePre;
			}
		}
	}
	
	// title, searchWord들로 특정 MoviePre 객체를 가져오는 메소드
	public List<MoviePre> selectMoviePreList(Connection conn, String searchWord) throws SQLException{
		
		String sql = "select * from movie_pre where search_word1 like ? or search_word2 like ? or search_word3 like ?";
		
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setString(1, "%" + searchWord + "%");
			pst.setString(2, "%" + searchWord + "%");
			pst.setString(3, "%" + searchWord + "%");
			try(ResultSet rs = pst.executeQuery();){
				List<MoviePre> moviePreList = new ArrayList<>();
				while(rs.next()) {
					moviePreList.add(convMoviePre(rs));
				}
				return moviePreList;
			}
		}

	}
	
	// 조회수를 올리는 메소드
	public void increaseReadCount(Connection conn , int movieId) throws SQLException{
		String sql = "update movie_pre set readCnt = readCnt+1 where movie_id = ? ";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, movieId);
			pst.executeQuery();
		}
	}
	

	// 삭제하는 메소드
	public int delete(Connection conn , int movieId ) throws SQLException {
		String sql = "delet from movie_pre where movie_id = ? ";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, movieId);
			return pst.executeUpdate();
		}
	}

	//ResultSet 으로 나온결과를 MoviePre 객체로 생성해서 담는 메소드
	private MoviePre convMoviePre(ResultSet rs) throws SQLException {
		MoviePre moviePre = new MoviePre(rs.getInt("movie_id"),
							rs.getString("title"),
							rs.getInt("genre_id"),
							rs.getInt("time"),
							rs.getString("release_date"),
							rs.getInt("rate"),
							rs.getString("famous_line"),
							rs.getString("image_name"),
							rs.getString("search_word1"),
							rs.getString("search_word2"),
							rs.getString("search_word3"));	
		return moviePre;
	}

}
