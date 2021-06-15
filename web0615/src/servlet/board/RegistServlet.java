package servlet.board;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

//�۾��� ��û ó��!! ( �Ķ���͵��� �Ѱܹ޾� sql����)
public class RegistServlet extends HttpServlet{
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="webmaster";
	String password="1234";
	Connection con; 
	PreparedStatement pstmt;

	//��û�� ó�� 
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//�Ķ���� �ޱ� 
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//Ŭ���̾�Ʈ�� �������� ���������� �����Ͽ� �����غ��� 
		response.setContentType("text/html");

		PrintWriter out = response.getWriter(); //���䰴ü�� ���� ��Ʈ�� �̱�
		out.print("title= "+title+"<br>");
		out.print("writer= "+writer+"<br>");
		out.print("content= "+content+"<br>");

		//�ش�DB�ý��ۿ� �˸´� ����̹� �ε�, ����Ŭ�� �����Ͽ� �������� 
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
			out.print("driver load success!!");

			//���ӽõ� 
			con=DriverManager.getConnection(url, user, password);
			if(con==null){
				out.print("Connection fail ");
			}else{
				out.print("Connected to oracle ^^");

				//�����غ�
				String sql="insert into board(board_id, title, writer, content) values(seq_board.nextval, ?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, writer);
				pstmt.setString(3, content);

				//��������
				int result=pstmt.executeUpdate(); //DML

				out.print("<script>");
				if(result>0){
					out.print("alert('insert ok');");
					out.print("location.href='/board/list';");
				}else{
					out.print("alert('insert fail');");
				}
				out.print("</script>");
			}	
		}catch(ClassNotFoundException e){
			System.out.println("����̹��� ã�� �� �����ϴ�");
			out.print("driver load failure!!");
		}catch(SQLException e){
			out.print(e);
		}finally{
			if(pstmt!=null){
				try{pstmt.close();}catch(SQLException e){}
			}
			if(con!=null){
				try{con.close();}catch(SQLException e){}
			}
		}

	}
}
