package common.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.handler.NullHandler;

public class Controller extends HttpServlet {
	
	private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();

	@Override
	public void init() throws ServletException {
		
		String handlerConfigFilePath = getServletContext().getRealPath(getInitParameter("handlerConfigFile"));
	
		Properties properties = new Properties();
		
		try(FileReader fR = new FileReader(handlerConfigFilePath);){
			properties.load(fR);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Properties 객체에 담긴 정보들을 commandHandlerMap에 객체로 만들어서 담아냄
		for(Object key : properties.keySet()) {
			
			String command = (String)key;
			String handlerClassName = properties.getProperty(command);
			
			try {
				Class handlerClass = Class.forName(handlerClassName);
				CommandHandler handlerInstance = (CommandHandler)handlerClass.getDeclaredConstructor().newInstance();
				commandHandlerMap.put(command, handlerInstance);
			}catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// URI로부터 command 뽑아오기
		String command = req.getRequestURI();
		if(command.indexOf(req.getContextPath()) == 0) {
			command = command.substring(req.getContextPath().length());
		}
		
		CommandHandler handler = null;
		if(command == null) {
			handler = new NullHandler();
		}else {
			handler = commandHandlerMap.get(command);
		}
		
		String viewPage = null;
		try {
			viewPage = handler.process(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(viewPage != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, resp);
		}
		
	}
	
	
	
	
}
