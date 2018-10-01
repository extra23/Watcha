package model;

import java.time.LocalDateTime;

public class Member {
	
	private int memberId;
	private String userId;
	private String password;
	private String memberName;
	private int memberRate;
	private LocalDateTime regDate;
	
	// 생성자 (1) : DB에서 select해올 때 사용할 생성자
	public Member(int memberId, String userId, String password, String memberName, int memberRate, LocalDateTime regDate) {
		this.memberId = memberId;
		this.userId = userId;
		this.password = password;
		this.memberName = memberName;
		this.memberRate = memberRate;
		this.regDate = regDate;
	}
	
	// 생성자 (2) : 회원 가입 입력 시 사용할 생성자
	public Member(String userId, String password, String memberName) {
		this.userId = userId;
		this.password = password;
		this.memberName = memberName;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public int getMemberRate() {
		return memberRate;
	}
	
	public void setMemberRate(int memberRate) {
		this.memberRate = memberRate;
	}
	
	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	// 입력받은 데이터와 필드의 비밀번호가 같은지 판단하는 메소드
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
	
}
