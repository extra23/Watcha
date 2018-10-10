package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.WatchaLike;
import service.like.LikeRequest;

public class WatchaLikeDAO {
	
	//싱글톤
	private static WatchaLikeDAO instance = new WatchaLikeDAO();
	public static WatchaLikeDAO getInstance() {
		return instance;
	}
	private WatchaLikeDAO () {}
	
	//사용자가 보고싶다고한 작품 삭제하자.
	public int delete(Connection conn, int memberId) throws SQLException {
		String sql = "delete from watcha_like where member_id =?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, memberId);
			return pst.executeUpdate();
		}
	}
	
	// member_id에 맞게 게시글 내용을 가져오는 메소드
	public WatchaLike selectById(Connection conn, int memberId) throws SQLException {
		String sql = "select * from movie_like where member_id = ? ";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, memberId);
			try (ResultSet rs = pst.executeQuery()) {
				WatchaLike like = null;
				if (rs.next()) {
					like = new WatchaLike(rs.getInt("like_id"), rs.getInt("member_id"), rs.getInt("movie_id"),
							rs.getBoolean("saw"));
				}
				return like;
			}
		}
	}
	
	/*//member_id에 따라서 watcha_like의 전체 tuple수를 가져오는 메소드
	public int selectCount(Connection conn, int memberId) throws SQLException {
		String sql = "select count(*) from watcha_like where member_id = ?";
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, memberId);
			try(ResultSet rs = pst.executeQuery();){
				if(rs.next()) {
					return rs.getInt(1);
				}
			}
		}
		return 0;	
	}*/
	
/*	//리미트를 이용한 리스트를 가져오는 쿼리
	public List<WatchaLike> select(Connection conn, int StartRow, int size) throws SQLException{
		String sql = "select * from watcha_like order by like_Id desc limit ?,?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, StartRow);
			pst.setInt(2, size);
			try(ResultSet rs = pst.executeQuery()){
				List<WatchaLike> likeList = new ArrayList<WatchaLike>();
				while(rs.next()) {
					likeList.add(convLike(rs));
				}
				return likeList;
			}
		}
	}*/
	
	
	
	// like update  메소드
	public int update(Connection conn, int likeId) throws SQLException {
		String sql = "update movie_like set title = ? where like_id = ? ";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, likeId);
			return pst.executeUpdate();
		}
	}
	
	//like insert 메소드
	public int insert(Connection conn, LikeRequest likeRequest) throws SQLException {
		String sql = "insert into watcha_like(member_id, movie_id) values(?,?)";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, likeRequest.getMemberId());
			pst.setInt(2, likeRequest.getMovieId());
			return pst.executeUpdate();
		}
	}
	
	/*//ResultSet으로 나온 결과를 watcha_like객체로 생성해서 담는 메소드
	private WatchaLike convLike(ResultSet rs) throws SQLException {
		WatchaLike watchaLike = new WatchaLike(rs.getInt("like_Id"), 
				rs.getInt("member_id"), 
				rs.getInt("movie_id"), 
				rs.getBoolean("saw"));
		return watchaLike;
	}	*/
}
