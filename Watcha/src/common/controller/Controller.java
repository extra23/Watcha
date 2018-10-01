package common.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.sun.corba.se.impl.activation.CommandHandler;

public class Controller extends HttpServlet {
	
	private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();

	@Override
	public void init() throws ServletException {
		
		String handlerConfigFilePath = getServletContext().getRealPath(getInitParameter("handlerConfigFile"));
		
		Properties properties = new Properties();
		
		try(FileReader fR = new FileReader(handlerConfigFilePath);){
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
