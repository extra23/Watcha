package service.account;

import java.sql.Connection;
import java.sql.SQLException;

import Exception.MemberNotFoundException;
import Exception.PermissionDeniedException;
import dao.MemberDAO;
import dao.WatchaLikeDAO;
import dao.WatchaReviewDAO;
import jdbc.ConnectionProvider;
import model.Member;

public class DeleteAccountService {
	
	//싱글톤
	private static DeleteAccountService instance = new DeleteAccountService();
	public static DeleteAccountService getInstance() {
		return instance;
	}
	private DeleteAccountService () {}
	
	public void delete(int memberId,String userId,String memberName) {
		MemberDAO memberDAO = MemberDAO.getInstance();
		WatchaLikeDAO watchaLikeDAO = WatchaLikeDAO.getInstance();
		WatchaReviewDAO watchaReviewDAO = WatchaReviewDAO.getInstance();
		
		try(Connection conn = ConnectionProvider.getConnection()){
			try {
				conn.setAutoCommit(false);
				
				Member member = memberDAO.selectMember(conn, memberId);
				
				//입력할 때 사용하는 생성자
				Member writeMember = new Member(memberId, userId, memberName);
				
				//사용자 있는지 확인
				if(member == null) {
					throw new MemberNotFoundException("없는 멤버");
				}
				
				//사용자 권한이 있는지 확인
				if(!member.getUserId().equals(writeMember.getUserId())) {
					throw new PermissionDeniedException("사용자 권한 없음");
				}
				
				//memberDAO,watchaLikeDAO,watchaReviewDAO를 이용해서 멤버삭제 메소드 실행
				memberDAO.delete(conn, memberId);
				watchaLikeDAO.delete(conn, memberId);
				watchaReviewDAO.deleteByMemberId(conn, memberId);
				conn.commit();
				
			}catch(SQLException e) {
				conn.rollback();
				throw new RuntimeException(e);
			}catch(PermissionDeniedException e) {
				conn.rollback();
				throw e;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
