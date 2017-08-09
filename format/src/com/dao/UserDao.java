package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.ConnectionManager;

public class UserDao {

	
	public boolean checkLogin(String id,String password,String duty) throws SQLException
	{//check id and password for all kinds of users
		
		String sql = null;
		Connection conn = ConnectionManager.getInstance().getConnection();  
		PreparedStatement ptmt=null;
		ResultSet rst=null;
		
		if(duty.equals("admin"))
		{
			sql="select count(id) as number from admin where id=? and password=?";
			
		}
		else if(duty.equals("auditor"))
		{
			
			sql="select count(id) as number from auditor where id=? and password=?";
			
		}
		else if(duty.equals("committer"))
		{
			
			sql="select count(id) as number from committer where id=? and password=?";
		
		}
		else if(duty.equals("superAdmin"))
		{
			sql="select count(id) as number from superAdmin where id=? and password=?";
			
			
		}
		ptmt = conn.prepareStatement(sql);	
		ptmt.setString(1, id);
		ptmt.setString(2, password);
		rst = ptmt.executeQuery();	
		while(rst.next())
		{
		if(rst.getInt("number")!=0)
		{
			ConnectionManager.close(conn,rst,ptmt);
			return true;
		}
		else
		{
			ConnectionManager.close(conn,rst,ptmt);
			return false;			
		}
		}
		ConnectionManager.close(conn,rst,ptmt);
		return false;
	}
	
	
	
	
	
	
	
}
