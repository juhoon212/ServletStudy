package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory;

@WebServlet("/dbcp")
public class DataSourceServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//BasicDataSource 객체(DataSource 객체) 생성
		BasicDataSource dataSource = new BasicDataSource();
		
		
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		dataSource.setInitialSize(10); // 최초 생성될 Connection 객체의 갯수 변경
		dataSource.setMaxIdle(10); // 대기상태의 Connection 객체의 갯수 변경
		dataSource.setMaxTotal(15); // 생성 가능한 최대 Connection 객체의 갯수 변경
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>DBCP</h1>");
		out.println("<hr>");
		
		try (dataSource;){
			Connection conn = dataSource.getConnection();
			out.println("<p>conn = " + conn + "</p>");
			out.println("<hr>");
			out.println("<h3>Connection 객체 제공 후</h3>");
			out.println("<p>Idle Connection Number = " + dataSource.getNumIdle() + "</p>");
			out.println("<p>Active Connection Number = " + dataSource.getNumActive() + "</p>");
			conn.close(); // Connection 객체 제거
			out.println("<hr>");
			out.println("<h3>Connection 객체 제거 후</h3>");
			out.println("<p>Idle Connection Number = " + dataSource.getNumIdle() + "</p>");
			out.println("<p>Active Connection Number = " + dataSource.getNumActive() + "</p>");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
}
