package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Date now = new Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		
		String displayNow = dateFormat.format(now);
		
		out.write("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset='UTF-8'>"
				+ "<title>Servlet</title>"
				+ "</head>"
				+ "<h1>서블릿 시계</h1>"
				+ "<hr>"
				+ "<p>" + displayNow + "</p>"
						+ "</body>"
						+ "</html>");
	}

}
