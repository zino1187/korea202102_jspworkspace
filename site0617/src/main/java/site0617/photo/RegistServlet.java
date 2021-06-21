package site0617.photo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//아파치 업로드 컴포넌트를 이용한 파일업로드 구현
public class RegistServlet extends HttpServlet{
	ServletContext context;
	String path;
	int maxSize=2*1024*1024; //2M byte
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
		path = context.getRealPath("/data");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//jsp에서의 page지시영역의 conentType과 동일
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("저 실행성공이요~!");
		
		//아파치 파일 업로드를 이용한 파일업로드 처리~~
		
		
		//업로드 관련설정 DiskFileItemFactory 이용
		File saveDir=new File(path); //저장될 디렉토리
		DiskFileItemFactory factory=new DiskFileItemFactory();

		factory.setRepository(saveDir);//어느경로에 저장
		factory.setSizeThreshold(maxSize);//저장용량 제한
		
		//업로드 처리 객체 
		ServletFileUpload upload=new ServletFileUpload(factory);//설정 정보 적용하여 인스턴스 생성
		
		try {
			List<FileItem> itemList=upload.parseRequest(request);
			out.print("넘겨받은 컴포넌트 값의 수는 "+itemList.size()+"<br>");
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		} 
		
	}
}
