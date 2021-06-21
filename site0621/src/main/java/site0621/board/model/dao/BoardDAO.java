package site0621.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BoardDAO {
	
	//insert
	public void insert() {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		
		String sql="insert into board(title, writer, content) values(?,?,?)";
		
	}
}
