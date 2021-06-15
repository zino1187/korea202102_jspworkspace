package servlet.board;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

//글쓰기 요청 처리!! ( 파라미터들을 넘겨받아 sql수행)
public class RegistServlet extends HttpServlet{

	//요청을 처리 
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//파라미터 받기 
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//클라이언트의 브라우저에 응답정보를 구성하여 전송해보자 
		PrintWriter out = response.getWriter(); //응답객체로 부터 스트림 뽑기
		out.print("title= "+title+"<br>");
		out.print("writer= "+writer+"<br>");
		out.print("content= "+content+"<br>");
	}
}
