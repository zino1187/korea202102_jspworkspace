package site0621.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import site0621.board.model.domain.Board;
import site0621.util.PoolManager;

public class BoardDAO {
	PoolManager pool = PoolManager.getInstance();
	
	//insert
	public int insert(Board board) {
		Connection con=null;
		PreparedStatement pstmt=null;
		con=pool.getConnection();
		int result=0;
		
		String sql="insert into board(title, writer, content) values(?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
	
	//목록 (5분)
	public void selectAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from board order by board_id desc";
		
	}
	
	//한건 가져오기 (5분)
	public void select() {
		
	}
	
	//수정하기 (5분)
	public void update() {
		
	}
	
	//삭제하기 (5분)
	public void delete() {
		
	}
	
}











