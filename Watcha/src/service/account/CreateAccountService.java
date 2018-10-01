package service.account;

import java.sql.Connection;
import java.sql.SQLException;

import Exception.DuplicateException;
import dao.MemberDAO;
import jdbc.ConnectionProvider;
import model.Member;

public class CreateAccountService {
	// 싱글톤
	private static CreateAccountService instance = new CreateAccountService( );
	private CreateAccountService( ) { }
	public static CreateAccountService getInstance( ) {
		return instance;
	}
	
	// 회원가입 로직
	public void create(CreateAccountRequest createReq) {
		MemberDAO memberDAO = MemberDAO.getInstance( );
		try(Connection conn = ConnectionProvider.getConnection( )){
			conn.setAutoCommit(false);
			try {
				Member member = memberDAO.selectByUserId(conn, createReq.getUserId( ));
				if(member != null) {
					 conn.rollback( );
					 throw new DuplicateException("아이디 중복");
				}
				memberDAO.insert(conn, new Member(createReq.getUserId( ), createReq.getMemberName( ), createReq.getPassword( )));
				conn.commit( );
			}catch(SQLException e) {
				throw new RuntimeException(e);
		}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}