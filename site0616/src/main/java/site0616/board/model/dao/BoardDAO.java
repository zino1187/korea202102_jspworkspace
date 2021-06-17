package site0616.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site0616.model.domain.Board;
import site0616.model.pool.PoolManager;

//웹이건, 응용이건 모두 공통적으로 재사용가능한 수준의 중립적 데이터 엑세스 객체를 정의해본다!!
//일반적인 어플리케이션 설계 분야에서 이러한 역할(Database와 연동되어 CRUD만을 수행)을 
//수행하는 객체를 가리켜 DAO(Data Access Object)라 한다. 
public class BoardDAO {
	PoolManager poolManager=PoolManager.getInstance(); //싱글턴으로 선언된 PoolManager의 인스턴스 얻기
	
	//Create(==insert) Read(==select) Update Delete 메서드 정의
	//글쓰기(글 한건 등록)
	public int insert(Board board) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0; //return 을 위해
		
		try {
			con=poolManager.getConnection();//풀로부터 Connection 한개 대여!!
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
			poolManager.release(con, pstmt);
		}
		return result;
	}
	
	
	//모드 레코드 가져오기 
	public List selectAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Board> list = new ArrayList<Board>(); //rs를 대신할 데이터!!
		
		try {
			con=poolManager.getConnection();
			
			String sql="select * from board order by board_id desc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery(); //쿼리수행 및 레코드 반환
			
			//곧 죽을 rs를 대신할 리스트에 레코드 한건 마다 VO담아놓고, 이 VO를 list 에 누적시키자!!
			while(rs.next()) {
				Board board = new Board(); //하나의 Board 인스턴스는 하나의 레코드를 대신할 수 있다!!
				
				board.setBoard_id(rs.getInt("board_id"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
				
				list.add(board);//완성된 VO를 컬렉션에 담자!!
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			poolManager.release(con, pstmt, rs);		
		}
		return list;
	}
	
	//레코드 한건 가져오기 !!
	public Board select(int board_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		Board board=null;
		
		try {
			con=poolManager.getConnection();
			
			String sql="select * from board where board_id="+board_id; //한건 가져오기
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//곧 죽을 rs를 대신할 즉 레코드 1건을 담을 VO를 생성하여, rs의 레코드를 옮겨심자
			if(rs.next()) {	//단 레코드가 있을때만 담아야 한다..따라서 레코드가 없을때는 Board는 null이 되므로, 개발자는
								//반환값이 null일때는 레코드가 없다는 판단을 해야 한다.
				board = new Board(); //하나의 Board 인스턴스는 하나의 레코드를 대신할 수 있다!!
				
				board.setBoard_id(rs.getInt("board_id"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			poolManager.release(con, pstmt, rs);		
		}
		return board;
	}
	
	//수정 메서드
	public int update(Board board) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0; //반환하기 위해
		
		try {
			con=poolManager.getConnection();
			String sql="update board set title=?, writer=?, content=? where board_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getBoard_id());
			
			result = pstmt.executeUpdate();//수정 쿼리 실행
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			poolManager.release(con, pstmt);					
		}
		return result;
	}
	
	
	//레코드 1건 삭제처리 메서드
	public int delete(int board_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			con=poolManager.getConnection();
			String sql="delete from board where board_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			result=pstmt.executeUpdate(); //삭제 쿼리 수행
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			poolManager.release(con, pstmt);					
		}
		return result;
	}
}














