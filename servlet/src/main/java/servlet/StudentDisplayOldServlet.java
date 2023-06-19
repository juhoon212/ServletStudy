package servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/old")
public class StudentDisplayOldServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "scott";
			String password = "tiger";
			
			conn = DriverManager.getConnection(url, username, password);
			
			String sql = "select * from student order by no";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>학생목록</h1>");
			out.println("<hr>");
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<th width='100'>학번</th>");
			out.println("<th width='150'>이름</th>");
			out.println("<th width='200'>전화번호</th>");
			out.println("<th width='300'>주소</th>");
			out.println("<th width='250'>생년월일</th>");
			out.println("/<tr>");
			
			
			
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td align='center'>" + rs.getInt("no") + "</td>");
				out.println("<td align='center'>" + rs.getString("name") + "</td>");
				out.println("<td align='center'>" + rs.getString("phone") + "</td>");
				out.println("<td align='center'>" + rs.getString("address") + "</td>");
				out.println("<td align='center'>" + rs.getString("birthday").substring(0,10) + "</td>");
			}
			
			
			out.println("</body>");
			out.println("</html>");
			
			
		} catch(ClassNotFoundException e) {
			System.out.println("[에러] OracleDriver 클래스를 찾을 수 없습니다");
		} catch (SQLException e) {
			System.out.println("JDBC관련 오류 = " + e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(conn != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				e.getMessage();
			}
		}
	}
	
}
