package service.account;

import java.sql.Connection;
import java.sql.SQLException;

import Exception.LoginFailException;
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
			
			// userId를 이용하여 Member 객체를 select 해옴
			Member member = memberDAO.selectMember(conn, userId);
			
			// Member 객체가 존재하지 않을 때의 처리
			if(member == null) {
				throw new LoginFailException("존재하지 않는 사용자");
			}
			
			// Member 객체가 존재한다면 Member 객체의 password와 입력한 password가 동일한지 확인 
			if(!member.matchPassword(password)) {
				throw new LoginFailException("비밀번호가 일치하지 않음");
			}
			
			// 인증이 완료되었으므로 Member 객체를 AuthUser 객체에 담아 반환
			return new AuthUser(member.getMemberId(), member.getUserId(), member.getPassword());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
