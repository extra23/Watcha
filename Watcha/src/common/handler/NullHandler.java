package common.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler {

	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
	
}