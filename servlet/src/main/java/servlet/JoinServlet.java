package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class JoinServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(request.getMethod().equals("GET")) {
//			response.sendError(HttpServletResponse.SC_BAD_REQUEST); 400
			// response.sendError(HttpServletResponse.SC_Method_NOT_ALLOWED); // 405
			
			response.sendRedirect("form.html"); // 영구적 리다이렉트
			return;
		}
		
		request.setCharacterEncoding("utf-8"); // post방식에만 사용
		
		String id = request.getParameter("id");
		String password = request.getParameter("passwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		request.getParameterNames().asIterator()
		.forEachRemaining((paramName) -> System.out.println("paramName" + paramName)); // 파라미터 이름 가져오기
		
		String[] hobbies = request.getParameterValues("hobby");
		
		
		
		
		
		
		
		
		
		// Validation!
		
		out.write("<DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset='UTF-8'>"
				+ "<title>Servlet</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>회원가입 확인</h1>"
				+ id
				+ "password = " + password
				+ "name = " + name
				+ "email = " + email);
		
		Arrays.stream(hobbies).forEach((hobby) -> out.println(" hobby = , " + hobby));
				
				
		
		
		
	}
}
