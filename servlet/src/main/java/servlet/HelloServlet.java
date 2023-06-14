package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** doGet 메소드보다 service의 우선순위가 더 높다. 따라서 service
 * 메소드를 정의한 경우  doGet이나 doPost메소드를 사용하지말자! 
*/
@WebServlet("/serve")
public class HelloServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// doGet() : Get방식 요청
	// doPost() : Post방식 요청
	
	
	/** 클라이언트 요청에 대한 실행결과를 응답하기 위한 파일형태(MimeType)을 변경
	 * => 리스폰즈 메세지의 몸체부에 저장될 파일형태 설정
	 * HttpServletResponse.setContentType(String mimeType[;charset=encoding]) 메소드 호출
	 * 기본 응답 파일 형식 : text/html;charset=iso-8859-1 >> 서유럽어로된 HTML문서로 응답
	*/
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter(); // 응답파일을 생성하기 위한 출력 스트림
		
		out.write("<DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset='UTF-8'>"
				+ "<title>Servlet</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>서블릿</h1>"
				+ "</body>"
				);
		
		
	}
}
