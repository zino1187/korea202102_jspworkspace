package servlet.board;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

//�۾��� ��û ó��!! ( �Ķ���͵��� �Ѱܹ޾� sql����)
public class RegistServlet extends HttpServlet{

	//��û�� ó�� 
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//�Ķ���� �ޱ� 
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//Ŭ���̾�Ʈ�� �������� ���������� �����Ͽ� �����غ��� 
		PrintWriter out = response.getWriter(); //���䰴ü�� ���� ��Ʈ�� �̱�
		out.print("title= "+title+"<br>");
		out.print("writer= "+writer+"<br>");
		out.print("content= "+content+"<br>");
	}
}
