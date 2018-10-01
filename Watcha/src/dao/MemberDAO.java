package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Member;


public class MemberDAO {
	// 싱글톤
	private static MemberDAO instance = new MemberDAO( );
	private MemberDAO( ) { }
	public static MemberDAO getInstance( ) {
		return instance;
	}
	
	// 회원가입시 필요한 쿼리 메소드 작성
	public Member selectByUserId(Connection conn, String userId) throws SQLException{
		String sql = "select * from member where userId = ? ";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, userId);
			Member member = null;
			
			try(ResultSet rs = pst.executeQuery( )){
				if(rs.next( )) {
					member = new Member(rs.getInt("memberId"),
							rs.getString("userId"),
							rs.getString("memberName"),
							rs.getString("password"),
							rs.getInt("memberRate"),
							rs.getTimestamp("regdate").toLocalDateTime( ));
				}
			}
			return member;
		}
	}
	
	// member 객체를 받아서 데이타베이스에 member를 삽입
	public void insert(Connection conn, Member member) throws SQLException {
		String sql ="insert into member(userId, name, password) values(?,?,?)";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, member.getUserId( ));
			pst.setString(2, member.getMemberName( ));
			pst.setString(3, member.getPassword());
			pst.executeUpdate( );
		}
	}
	
	// 사용자 정보 수정
	public void update(Connection conn, Member member) throws SQLException {
		String sql = "update member set memberName = ?, password = ? where memberId = ?";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, member.getMemberName( ));
			pst.setString(2, member.getPassword( ));
			pst.setInt(3, member.getMemberId( ));
			pst.executeUpdate( );
			
		}
	}
}
