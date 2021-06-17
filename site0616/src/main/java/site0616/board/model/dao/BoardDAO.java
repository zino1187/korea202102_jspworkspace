package site0616.board.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import site0616.model.domain.Board;

//웹이건, 응용이건 모두 공통적으로 재사용가능한 수준의 중립적 데이터 엑세스 객체를 정의해본다!!
//일반적인 어플리케이션 설계 분야에서 이러한 역할(Database와 연동되어 CRUD만을 수행)을 
//수행하는 객체를 가리켜 DAO(Data Access Object)라 한다. 
public class BoardDAO {
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="webmaster";
	String password="1234";
	
	public BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Create(==insert) Read(==select) Update Delete 메서드 정의
	//글쓰기(글 한건 등록)
	public int insert(Board board) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0; //return 을 위해
		
		try {
			con=DriverManager.getConnection(url, user, password);
			String sql="insert into board(board_id, title, writer,content) values(seq_board.nextval,?,?,?)";
			pstmt=con.prepareStatement(sql)	;
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			//쿼리실행 
			result=pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
}












