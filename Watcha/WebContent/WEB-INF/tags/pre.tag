<%@ tag body-content="empty" pageEncoding="utf-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="value" type="java.lang.String" required="true" %>
<%

	// 사용자 태그를 정의하는 소스
		// 변수 설정
	value=value.replace("&", "&amp;");
	value=value.replace("<", "&lt;");
	value=value.replace(">", "&gt;");
	value=value.replace("\n", "<br>");
	value=value.replace(" ", "&nbsp;");

%>
<%= value %>	<%-- 변수 출력 --%>