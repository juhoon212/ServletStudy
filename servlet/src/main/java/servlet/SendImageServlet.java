package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.StandardContext;

@WebServlet("/image")
public class SendImageServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg"); // 문서 파일이 아니므로 charset 미지정
		
		ServletOutputStream out = response.getOutputStream();
		
		String imageFilePath = request.getServletContext().getRealPath("/WEB-INF/Koala.jpg");
		
		FileInputStream in = new FileInputStream(imageFilePath);
		
		while(true) {
			int readByte = in.read();
			if(readByte == -1) break;
			
			out.write(readByte);
		}
		
		in.close(); // 입력스트림 제거
	
	}
}
