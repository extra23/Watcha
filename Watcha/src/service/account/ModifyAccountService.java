package service.account;

import java.sql.Connection;
import java.sql.SQLException;

import Exception.InvalidPasswordException;
import Exception.MemberNotFoundException;
import dao.MemberDAO;
import jdbc.ConnectionProvider;
import model.Member;

public class ModifyAccountService {

	// 싱글톤
	private static ModifyAccountService instance = new ModifyAccountService();

	public static ModifyAccountService getInstance() {
		return instance;
	}

	private ModifyAccountService() {
	}

	// 비밀번호 변경위해 비즈니스 로직 수행
	// 로그인 아이디, 현 비번, 새 비번을 인자로 받고 그것을 통해서 비번이 제대로 되었는지
	// 현재 있는 사용자인지 확인하고 로직을 수행한다.
	public void changePassword(String userId, String oldPwd, String newPwd,String memberName) {
		MemberDAO memberDao = MemberDAO.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {

			try {
				conn.setAutoCommit(false);
				// user객체를 받아오고

				Member member = memberDao.selectMember(conn, userId);

				// 없는 유저라면
				if (member == null) {
					throw new MemberNotFoundException("없는 멤버");
				}

				// member객체와 입력받은 비밀번호를 비교해서 잘못된 비밀번호를 입력했다면
				if (!member.matchPassword(oldPwd)) {
					throw new InvalidPasswordException("잘못된 비밀번호");
				}
				// 업데이트에 보낼 객체의 비번을 새로 넣어줌
				// 정상이면 update
				member.setPassword(newPwd);
				member.setMemberName(memberName);
				memberDao.update(conn, member);
				conn.commit();
			} catch (SQLException e) {
				// 아니면 예외날리고 롤백
				conn.rollback();
				throw new RuntimeException(e);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
