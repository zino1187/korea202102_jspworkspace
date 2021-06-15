//��� ��û�� ó���ϴ� ����
//�����̶�, javaEE����� �������� ����� �� �ִ� Ŭ�����̴�..������ ���������δ� ���߽� 
//������ ó���� �ʹ� ���� ���ҽ��� �Ҹ��..�� ȿ�������� ���ϴ�...��? Ŭ���̾�Ʈ���� ������ ������ ���ڿ���
//���ڿ� ó���Ͽ� �����ؾ� �ϹǷ�...�� �����ο� �����..
package servlet.board;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ListServlet extends HttpServlet{
	
	//��ûó�� �޼���
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;utf-8"); //ǥ������ header ���� 
		//response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");//����̹� �ε� 
			//���� 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE" ,"webmaster", "1234");
			if(con !=null){
				out.print("connection ok <br>");
				//select�� ����
				String sql="select * from board order by board_id desc";
				pstmt=con.prepareStatement(sql); //������ü �غ� 
				rs=pstmt.executeQuery(); //�������� �� ���ڵ� ��ȯ
				//rs�� html ǥtable�� ��� 
				out.print("<table width='100%' border='1px'>");
				
				out.print("<tr>");
				out.print("<th>No</th>");
				out.print("<th>title</th>");
				out.print("<th>writer</th>");
				out.print("<th>regdate</th>");
				out.print("<th>hit</th>");
				out.print("</tr>");

				//�ݺ������� tró��~~~
				while(rs.next()){
					out.print("<tr>");
					out.print("<td>No</td>");
					out.print("<td>"+rs.getString("title")+"</td>");
					out.print("<td>"+rs.getString("writer")+"</td>");
					out.print("<td>"+rs.getString("regdate")+"</td>");
					out.print("<td>"+rs.getInt("hit")+"</th>");
					out.print("</tr>");
				}
				out.print("</table>");

			}else{
				out.print("connection fail <br>");
			}
		}catch(ClassNotFoundException e){ //java.lang�� �ֱ� ������ import�� �ʿ� ����
			e.printStackTrace(); //���� ������ ��µǴ� ����? ������ �ܼ�â �Ǵ� log���� 
		}catch(SQLException e){ //java.lang�� �ֱ� ������ import�� �ʿ� ����
			e.printStackTrace(); 
		}finally{
			if(rs!=null){
				try{rs.close();}catch(SQLException e){}
			}
			if(pstmt!=null){
				try{pstmt.close();}catch(SQLException e){}
			}
			if(con!=null){
				try{con.close();}catch(SQLException e){}
			}
		}
	}

}
