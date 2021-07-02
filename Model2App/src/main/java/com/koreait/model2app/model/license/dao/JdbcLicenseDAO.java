package com.koreait.model2app.model.license.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.koreait.model2app.model.domain.License;
import com.koreait.model2app.util.pool.PoolManager;

public class JdbcLicenseDAO implements LicenseDAO{
	private PoolManager pool=PoolManager.getInstance();
	
	@Override
	public int insert(License license) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		con=pool.getConnection();
		String sql="insert into license(license_id, member_id, title) values(seq_license.nextval,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, license.getMember_id());
			pstmt.setString(2, license.getTitle());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public License select(int license_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(License license) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int license_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
