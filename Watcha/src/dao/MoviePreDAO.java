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

	// 게시글 insert를 구현할 것인데!	
	public MoviePre insert(Connection conn, MoviePre moviePre) throws SQLException {
		String Sql = "insert into Movie(movieId,title)values(?,?)";
		try(PreparedStatement pst = conn.prepareStatement(Sql);
				Statement st = conn.createStatement()){
					pst.setInt(1,moviePre.getMovieId());
					pst.setString(2, moviePre.getTitle());
					int insertedCount = pst.executeUpdate(); 

				if(insertedCount > 0) {
					try(ResultSet rs = st.executeQuery("select last_insert_id() from moviePre")){
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
	
	// 게시글 개수를 가져오는 메소드 작성 ㄱㄱ
	public int selectCount(Connection conn) throws SQLException {
		String sql = "select count(*) from moviePre";
		try(Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql)){
			if(rs.next()) {
				return rs.getInt(1);
			}
		}	
		return 0;		
	}

	// 리미트를 이용한 리스트를 가져오는 쿼리
	public List<MoviePre> select(Connection conn , int StarRow , int size) throws SQLException{
		String sql = "select * from moviePre order by movieId limit ?,?";
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

	// 게시글 번호로 특정 게시글을 가져오는 메소드
	public MoviePre selectById(Connection conn, int no ) throws SQLException {
		String sql = "select * from moviePre where movieId  =? ";
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

	// 조회수를 올리는 메소드
	public void increaseReadCount(Connection conn , int movieId) throws SQLException{
		String sql = "update moviePre set readCnt = readCnt+1 where movieId = ? ";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, movieId);
			pst.executeQuery();
		}
	}

	// 제목을 수정하는 메소드
	public int update(Connection conn , int movieId , String title) throws SQLException {
		String sql = "update moviePre set title = ? where movieId = ? ";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, title);
			pst.setInt(2, movieId);
			return pst.executeUpdate();
		}
	}
	

	// 삭제하는 메소드
	public int delete(Connection conn , int movieId ) throws SQLException {
		String sql = "delet from moviePre where  movieId = ? ";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1,  movieId);
			return pst.executeUpdate();
		}
	}

	//ResultSet 으로 나온결과를 MoviePre 객체로 생성해서 담는 메소드
	private MoviePre convMoviePre(ResultSet rs) throws SQLException {
		MoviePre moviePre = new MoviePre(rs.getInt("movieId"),
							rs.getString("title"),
							rs.getInt("time"),
							rs.getString("releaseDate"),
							rs.getInt("rate"),
							rs.getString("famousLine"),
							rs.getString("image"));	
		return moviePre;
	}

}
