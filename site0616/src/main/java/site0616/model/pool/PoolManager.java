package site0616.model.pool;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//커넥션을 모아놓고 관리하는 커넥션풀 객체는 메모리에 인스턴스를 오직1개만 두고 사용하기 위해
//싱글턴으로 처리해 보자 (SingleTon)
public class PoolManager {
	InitialContext context;
	DataSource ds;
	
	public PoolManager() {
		try {
			context = new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jndi/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//누구든지 쿼리문을 수행하기 위해 Connection이 필요하다면 아래의 메서드를 호출하여  Connection을 가져가기만 하면 됨
	public Connection getConnection() {
		Connection con=null;
		try {
			con=ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}






