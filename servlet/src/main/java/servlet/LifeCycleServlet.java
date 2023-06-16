package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet("/lifeCycle")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	// 객체를 생성하면서 실행된 명령 작성 - 초기화 처리
	public LifeCycleServlet() {
//		name = "홍길동";
		System.out.println("### LifeCycleServlet의 생성자 메소드 호출 ###");
	}
	
	// 객체를 생성하면서 실행된 명령 작성 - 초기화 처리
	// 생성자 대신 init메소드를 이용하여 초기화 처리 명령을 작성하는 이유
	// => init() 메소드는 매개변수로 ServletConfig 객체를 제공받아 사용 가능
	// ServletConfig객체 : 웹 자원을 생성하기 위한 환경 설정 관련 정보를 저장한 객체
	// => [web.xml] 파일에서 제공되는 값을 얻어와 서블릿 클래스에서 사용 가능 - 유지보수의 효율성 증가
 	    @Override
		public void init(ServletConfig config) throws ServletException {
			System.out.println("### LifeCycleServlet의 init() 메소드 호출 ###");
			name = config.getServletContext().getInitParameter("name");
			
			// getServletContext() => contextParam의 요소를 가져오기 위해 사용
			
			// [web.xml] 파일의 init-param 엘리먼트로 제공되는 값은 ServletConfig 객체의
			// getInitParameter(String name) 메소드를 호출하여 값을 얻어와서 반환 
		}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("### LifeCycleServlet의 service() 메소드 호출###");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.write(
				"<DOCTYPE html>"
						+ "<html>"
						+ "<head>"
						+ "<meta charset='UTF-8'>"
						+ "<title>Servlet</title>"
						+ "</head>"
						+ "<body>"
						+ "<h1>서블릿의 생명주기</h1>"
						+ "이름 : " + name
						+ "</body>");
	}
	
	@Override
	public void destroy() {
	   System.out.println("### LifeCycleServlet의 destroy() 메소드 호출###");
	}

}
