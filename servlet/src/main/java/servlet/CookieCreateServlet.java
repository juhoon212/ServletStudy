package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class CookieCreateServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		// Client에 쿠키 저장
		Cookie idCookie = new Cookie("id", "abc123");
		Cookie countCookie = new Cookie("count", "0");
		
		// 클라이언트에 전달되어 저장될 쿠키의 유지시간 변경
		// 메소드 호출 x => 유지시간은 -1 로 설정 => 브라우저 종료 시 자동 소멸
		
		countCookie.setMaxAge(24 * 60 * 60); // 초 (s)전달 => 1일
		
		response.addCookie(idCookie);
		response.addCookie(countCookie);
		
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키</h1>");
		out.println("<hr>");
		out.println("<p>네 안에 쿠키있다</p>");
		out.println("<p><a href='read'>쿠키</p>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
