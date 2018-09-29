package jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBCPInitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		// ServletContext 생성 (서블릿 컨텍스트를 받음)
		ServletContext servletContext = sce.getServletContext();
		
		// web.xml에 등록된 Parameter를 통해서 파일 주소 가져오기
		String poolConfigFile = servletContext.getRealPath(servletContext.getInitParameter("poolConfigFile"));
		
		// 데이터를 담을 Properties 객체 생성
		Properties properties = new Properties();
		
		// 파일 주소를 통해서 프로퍼티즈 객체에 파일에 있는 데이터 담기
		try {
			properties.load(new FileReader(poolConfigFile));
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Not Found poolConfigFile", e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
