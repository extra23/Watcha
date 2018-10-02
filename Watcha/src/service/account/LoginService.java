package service.account;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDAO;
import jdbc.ConnectionProvider;
import model.Member;

public class LoginService {
	
	private static LoginService instance = new LoginService();
	private LoginService() {}
	public static LoginService getInstance() {
		return instance;
	}
	
	public AuthUser login(String userId, String password) {
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		try(Connection conn = ConnectionProvider.getConnection();){
			
			conn.setAutoCommit(false);
			
				Member member = memberDAO.selectByUserId(conn, userId);
				
				if(member == null) {
					
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
