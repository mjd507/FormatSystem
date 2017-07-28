package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.SuperAdmin;
import com.util.ConnectionManager;

public class SuperAdminDao {

	
	public SuperAdmin GetSuperAdmin(String id) throws SQLException
	{//get superAdmin by id
		
		SuperAdmin superAdmin=new SuperAdmin();
		
		String sql = "select * from superadmin where id=?;";
		Connection conn = ConnectionManager.getInstance().getConnection();  
		PreparedStatement ptmt=null;
		ResultSet rst=null;
		
		ptmt = conn.prepareStatement(sql);	
		ptmt.setString(1, id);
		rst = ptmt.executeQuery();	
		while(rst.next())
		{
			superAdmin.setId(id);
			superAdmin.setPassword(rst.getString("password"));
			superAdmin.setName(rst.getString("name"));
			superAdmin.setTelephone(rst.getString("telephone"));
			superAdmin.setEmail(rst.getString("email"));
		}
		ConnectionManager.close(conn,rst,ptmt);
		return superAdmin;
		
		
	}
	
}
