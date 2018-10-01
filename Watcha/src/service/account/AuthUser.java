package service.account;

public class AuthUser {
	private  int memberId;
	private String userId;
	private String memberName;
	
	public AuthUser(int memberId, String userId, String memberName) {
		this.memberId = memberId;
		this.userId = userId;
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
}
