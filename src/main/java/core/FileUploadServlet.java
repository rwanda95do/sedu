package core;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig (location = "c:/uploadtest", maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		request.setCharacterEncoding("utf-8");
		
		// 폴더가 없으면 만드는거 
		String path = "c:/uploadtest";
		File isDir = new File(path);
		if (!isDir.isDirectory()) {
			isDir.mkdirs();
		}
		
		
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			if (part.getContentType() != null) {  // 업로든된 파일의 정보를 가지고 있는지 구분
				String fileName = part.getSubmittedFileName();  // getSubmittedFileName() : 실제 업로드되는 파일 이름
				if (fileName != null) {
					part.write(fileName.substring(0, fileName.lastIndexOf(".")) + "_"
							+ System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf(".")));
					out.print("업로드한 파일 이름: " + fileName + "<br>");
					out.print("크기: " + part.getSize() + fileName + "<br>");				
				}
			} else {
				String partName = part.getName();
				String fieldValue = request.getParameter(partName);
				out.print(partName + ": " + fieldValue +"<br>");			
			}
		}
		out.close();
	}
}