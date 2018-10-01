package service.account;

public class AuthUser {
	private  int member_id;
	private String user_id;
	private String member_name;
	
	public AuthUser(int member_id, String user_id, String member_name) {
		this.member_id = member_id;
		this.user_id = user_id;
		this.member_name = member_name;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	
}
