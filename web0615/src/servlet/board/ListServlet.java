//��� ��û�� ó���ϴ� ����
package servlet.board;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ListServlet extends HttpServlet{
	
	//��ûó�� �޼���
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		out.print("this is board list");
	}

}
