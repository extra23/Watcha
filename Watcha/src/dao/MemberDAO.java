package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Member;


public class MemberDAO {
	
	// 싱글톤
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() { }
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// 회원 가입 시 필요한 쿼리 메소드 작성 (아이디 중복 체크 시 사용하는 query문)
	public Member selectMember(Connection conn, String userId) throws SQLException{
		
		String sql = "select * from member where user_id = ? ";
		
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setString(1, userId);
			Member member = null;
			
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					member = new Member(rs.getInt("member_id"), rs.getString("user_id"), rs.getString("password"), rs.getString("member_name"), rs.getInt("member_rate"), rs.getTimestamp("regDate").toLocalDateTime());
				}
			}
			
			return member;
		}
		
	}
	
	public Member selectMember(Connection conn, int memberId) throws SQLException{
		
		String sql = "select * from member where user_id = ? ";
		
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setInt(1, memberId);
			Member member = null;
			
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					member = new Member(rs.getInt("member_id"), rs.getString("user_id"), rs.getString("password"), rs.getString("member_name"), rs.getInt("member_rate"), rs.getTimestamp("regDate").toLocalDateTime());
				}
			}
			
			return member;
		}
		
	}
	
	// member 객체를 받아서 데이타베이스에 member를 삽입
	public void insert(Connection conn, Member member) throws SQLException {
		String sql ="insert into member(user_id, member_name, password) values(?,?,?)";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, member.getUserId());
			pst.setString(2, member.getMemberName());
			pst.setString(3, member.getPassword());
			pst.executeUpdate();
		}
	}
	
	// 사용자 정보 수정
	public void update(Connection conn, Member member) throws SQLException {
		String sql = "update member set member_name = ?, password = ? where member_id = ?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, member.getMemberName());
			pst.setString(2, member.getPassword());
			pst.setInt(3, member.getMemberId());
			pst.executeUpdate();
		}
	}
	
	//사용자 삭제
	public int delete(Connection conn, int memberId) throws SQLException {
		String sql = "delete from member where member_id =?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, memberId);
			return pst.executeUpdate();
		}
	}
	
}
