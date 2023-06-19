package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dto.StudentDTO;


@WebServlet("/new")
public class StudentDisplayNewServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<StudentDTO> studentList = StudentDAO.getInstance().selectStudentList();
		
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
		
		for (StudentDTO studentDTO : studentList) {
			out.println("<tr>");
			out.println("<td align='center'>" + studentDTO.getNo() + "</td>");
			out.println("<td align='center'>" + studentDTO.getName() + "</td>");
			out.println("<td align='center'>" + studentDTO.getPhone() + "</td>");
			out.println("<td align='center'>" + studentDTO.getAddress() + "</td>");
			out.println("<td align='center'>" + studentDTO.getDate().substring(0,10) + "</td>");
		}
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
