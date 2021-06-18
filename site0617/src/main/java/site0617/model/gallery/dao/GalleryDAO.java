package site0617.model.gallery.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//이 클래스는 오직 gallery에 테이블에 대한 CRUD만을 담당
public class GalleryDAO {
	
	public void insert() {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		con=커넥션풀에서 가져오자;
		String sql="insert into gallery(gallery_id, title, writer, content, filename) values(seq_gallery.nextval,?,?,?,?)";
		
	}
	
}
