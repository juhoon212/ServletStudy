package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


/**
 * Apache 그룹에서 배포한 commons-fileupload 라이브러리의 클래스 사용 - 선택적 파일 업로드
 * Oreilly 그룹에서 배포한 cos 라이브러리의 클래스 사용 - 무조건 파일 업로드
 * 
 * Oreilly 그룹에서 배포한 cos 라이브러리를 다운로드 프로젝트 빌드 처리
 * 1. http://www.servlets.com 사이트로 접속 >> COS File upload library 클릭 >> 맨 밑 cos.zip 파일 다운로드
 * 2. cos zip 파일 압출 풀고 lib 폴더안에 cos.jar파일 복사
 * 3. 프로젝트 >> src/main/webapp >> WEB-INF >> lib >> 붙여넣기
 */

@WebServlet("/uploadImage")
public class UploadServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// WAS 프로그램이 실행될 때 이클립스 작업 디렉토리의 파일을 이용하여 웹 디렉토리의 자원으로 변환하여 저장
		// => 작업 디렉토리에 업로드 파일이 없으므로 동기화 처리되면 웹디렉토리에 업로드된 파일 소멸
		
		String saveDirectory = request.getServletContext().getRealPath("/upload");
		System.out.println("saveDirectory = " + saveDirectory);
		
		if(request.getMethod().equals("GET")) {
			response.sendRedirect("upload.html");
			return;
		}
		
		// cos 라이브러리의 MultiPartRequest 객체 : [multipart/form-data] 로 전달받은 값과 파일 처리
		// FileRenamePolicy 객체 : 업로드될 파일의 이름과 같은 이름의 파일이 서버 디렉토리에
		// 이미 존재할 경우 업로드될 파일의 이름을 변경하는 기능을 제공하는 객체
		MultipartRequest mr = new MultipartRequest(request, saveDirectory, 20 * 1024*1024
				, "utf-8", new DefaultFileRenamePolicy());
		
		// MultipartRequest 객체를 이용하여 전달값을 반환받아 저장
		
//		String uploadFile = mr.getOriginalFileName("uploadfile");
		
		String uploader = mr.getParameter("uploader");
		
		//MultipartRequest.getOriginalFileName(String name) : 매개변수로 전달된 이름의 파일명
		//(입력파일명)을 반환하는 메소드
		
		String fileOne = mr.getFilesystemName("fileOne");
		String fileTwo = mr.getFilesystemName("fileTwo");
		
		
		
		
		
		/*
		request.setCharacterEncoding("utf-8");
		
		//form 태그의 [multipart/form-data]로 전달된 입력값은 HttpServletRequest 객체의
		//getParameter() 메소드를 호출하여 반환 불가능
		String uploader=request.getParameter("uploader");
		*/

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>파일업로드</h1>");
		out.println("<hr>");
		out.println("<p>올린이 = "+uploader+"</p>");
		out.println("<p>파일-1 = "+fileOne+"</p>");
		out.println("<p>파일-2 = "+fileTwo+"</p>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
	}
}
