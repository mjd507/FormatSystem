package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Admin;
import com.util.ConnectionManager;

public class AdminDao {

	
	public Admin GetAdmin(String id) throws SQLException
	{//get Admin by id
		
		Admin admin=new Admin();
		String sql = "select admin.password,admin.name,admin.telephone,admin.email,admin.oid,organization.name as oName from admin,organization where admin.id=? and admin.oid=organization.id;";
		Connection conn = ConnectionManager.getInstance().getConnection();  
		PreparedStatement ptmt=null;
		ResultSet rst=null;
		
		ptmt = conn.prepareStatement(sql);	
		ptmt.setString(1, id);
		rst = ptmt.executeQuery();	
		while(rst.next())
		{
		admin.setId(id);
		admin.setPassword(rst.getString("password"));
		admin.setName(rst.getString("name"));
		admin.setTelephone(rst.getString("telephone"));
		admin.setEmail(rst.getString("email"));
		admin.setoId(rst.getInt("oid"));
		admin.setoName(rst.getString("oName"));
		
		}
		ConnectionManager.close(conn,rst,ptmt);
		return admin;
	}
	
	
}
