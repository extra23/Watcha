package service.account;

import java.util.Map;
import java.time.LocalDateTime;

// 폼에서 받은 데이터를 담고 무결성 체크하는 클래스
public class CreateAccountRequest {
	
	// 폼에서 입력되는 데이터
	private String userId;
	private String memberName;
	private String password;
	private String confirmPassword;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	// 패스워드가 같은지 확인하는 메소드
	public boolean isEqPassword() {
		return password != null && password.equals(confirmPassword);
	}

	// 입력받은 데이터가 비었는지 확인하는 메소드
	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty()) {
			// 비거나 문제가 있다면 그 결과를 화면으로 다시 전송하기 위해서
			// 객체에 담아서 결과 화면에 보내줌.
			errors.put(fieldName, true); // fieldName -> 나중에 화면에서 출력하기 위한 변수명
		}
	}

	// 입력받은 데이터가 제대로 들어왔는지 검사하는 메소드
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, userId, "userId");
		checkEmpty(errors, memberName, "memberName");
		checkEmpty(errors, password, "password");
		checkEmpty(errors, confirmPassword, "confirmPassword");
		// 패스워드 확인부분이 입력되어 있다면
		if (!errors.containsKey("confirmPassword")) {
			// 두개의 패스워드를 비교
			if (!isEqPassword()) {
				errors.put("notMatch", true);
			}
		}
	}
	
}
