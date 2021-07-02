package com.koreait.model2app.model.license.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.koreait.model2app.model.domain.License;

import lombok.Data;

@Data
public class JdbcLicenseDAO implements LicenseDAO{
	private Connection con;
	
	@Override
	public int insert(License license) {
		PreparedStatement pstmt=null;
		int result=0;

		String sql="insert into license(license_id, member_id, title) values(seq_license.nextval,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, license.getMember_id());
			pstmt.setString(2, license.getTitle());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
