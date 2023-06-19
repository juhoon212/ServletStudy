package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GuestDAO;
import dao.StudentDAO;
import dto.GuestDTO;
import dto.StudentDTO;

@WebServlet("/guest/list")
public class GuestSelectServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<GuestDTO> guestList = GuestDAO.getInstacne().selectGuestList();
		
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
		out.println("<td align='right'>");
		out.println("button type='button' onclick=''");
		out.println("</td>");
		out.println("</tr>");
		
		if(guestList.isEmpty()) {
			out.println("<tr>");
			out.println("<td>검색된 방명록 게시글이 하나도 없습니다</td>");
			out.print("</tr>");
		} else {
			for (GuestDTO guestDTO : guestList) {
				out.println("<tr>");
				out.println("<td align='center>");
				out.println("</tr>");
			}
		}
		
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
}
