package site0617.model.gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import site0617.model.domain.Gallery;
import site0617.model.pool.PoolManager;

//이 클래스는 오직 gallery에 테이블에 대한 CRUD만을 담당
public class GalleryDAO {
	PoolManager pool=PoolManager.getInstance();
	
	public int insert(Gallery gallery) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		con=pool.getConnection();
		String sql="insert into gallery(gallery_id, title, writer, content, filename) values(seq_gallery.nextval,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, gallery.getTitle());
			pstmt.setString(2, gallery.getWriter());
			pstmt.setString(3, gallery.getContent());
			pstmt.setString(4, gallery.getFilename());
			result=pstmt.executeUpdate();//쿼리수행
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
}





