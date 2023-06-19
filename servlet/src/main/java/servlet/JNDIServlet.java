package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


// JDNI(JAVA Naming Directory Interface) : WAS 프로그램에 의해 관리되는 객체를 미리 생성하여 저장하고 웹프로그램에서 객체가 필요한 경우
// WAS 프로그램에 등록된 객체의 이름을 이용하여 객체를 제공받아 사용하기 위한 기능


@WebServlet("/jndi")
public class JNDIServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			// InitialContext 객체 : WAS 프로그램에 등록된 객체 관련 JNDI 서비스를 제공하는 객체
			DataSource dataSource = (DataSource)new InitialContext().lookup("java:comp/env/jdbc/oracle");
			
			Connection conn = dataSource.getConnection();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>DBCP-JNDI</h1>");
			out.println("<hr>");
			out.println("<p>conn = " + conn + "</p>");
			out.println("</body>");
			out.println("</html>");
			
			
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

}
