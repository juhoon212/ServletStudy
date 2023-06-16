package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/read")
public class CookieReadServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키</h1>");
		out.println("<hr>");
		
		if(cookies == null) {
			out.println("<p>네 안에 쿠키없다</p>");
		} else {
			String id = "";
			String count = "";
			
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(id)) {
					id = cookie.getValue();
				} else if(cookie.getName().equals("count")){
					count = cookie.getValue();
				}
			}
			
			if(!id.equals("")) {
				out.println("<p>아이디 =" + id + "</p>");
			}
			
			if(!count.equals("")) {
				int cookieCount = Integer.parseInt(count) + 1;
				
				out.println("<p>count =" + cookieCount + "</p>");
				
				Cookie cookie = new Cookie("count", cookieCount + "");
				cookie.setMaxAge(86400);
				response.addCookie(cookie);
			}
		}
		
		out.println("<p><a href='create'>쿠키 생성</p>");
		out.println("<p><a href='remove'>쿠키 삭제</p>");
		out.println("</body>");
		out.println("</html>");
		

	}

}
