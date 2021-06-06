package lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lms.dao.LmsDao;
import lms.vo.Account;

public class LmsDao {
	private static LmsDao dao = new LmsDao();
	private LmsDao() {}
	public static LmsDao getInstance()
	{
		return dao;
			
	}
	public Connection connect()
	{
		Connection conn = null;
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:8080/test","root","cs1234");
		} catch(Exception e)
		{
			System.out.print("MDAD:connect"+e);
			
			
		}
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement pstmt)
	{
		if(pstmt !=null)
		{
			try {
				pstmt.close();
			}catch(Exception e) {
				System.out.print("Pstmt close error");
			}
		}
		if(conn !=null)
		{
			try {
				conn.close();
			}catch(Exception e) 
			{
				System.out.print("Conn close error");
			}
			
		}
		
	}
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) 
	{
		if(rs != null)
		{
			try {
				rs.close();
		  }catch(Exception e) {
			  System.out.print("rs close error"); 
			  
		  }
		}
		close(conn, pstmt);
	}
	
	
	
	
	public void join(Account account) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn= connect();
			pstmt = conn.prepareStatement("insert into account value(?,?,?);");
			pstmt.setString(1, account.getId());
			pstmt.setString(2, account.getPwd());
			
			pstmt.executeUpdate();
			
			}catch(Exception e) {
				System.out.print("join error"+e);
				
			}
		finally
		{
			close(conn,pstmt);
		}
	}
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		boolean result=false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try
		{
			conn= connect();
			pstmt = conn.prepareStatement("select * from account where id=? and pwd=?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs =pstmt.executeQuery();
			if(rs.next()) 
			{
				result = true;
			}
			else
				result = false;
			
			}catch(Exception e) {
				System.out.print("join error"+e);
				
			}
		finally
		{
			close(conn,pstmt, rs);
		}
		return result;
	}
	
  
}
