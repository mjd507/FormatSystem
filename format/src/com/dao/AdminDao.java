package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Admin> getAdminList() throws SQLException
	{//get AdminList
		
		
		List<Admin> list=new ArrayList<Admin>();
		String sql = "select admin.id,admin.password,admin.name,admin.telephone,admin.email,admin.oid,organization.name as oName from admin,organization where admin.oid=organization.id;";
		Connection conn = ConnectionManager.getInstance().getConnection();  
		PreparedStatement ptmt=null;
		ResultSet rst=null;
		
		ptmt = conn.prepareStatement(sql);	
		rst = ptmt.executeQuery();	
		while(rst.next())
		{
		Admin admin=new Admin();
		admin.setId(rst.getString("id"));
		admin.setPassword(rst.getString("password"));
		admin.setName(rst.getString("name"));
		admin.setTelephone(rst.getString("telephone"));
		admin.setEmail(rst.getString("email"));
		admin.setoId(rst.getInt("oid"));
		admin.setoName(rst.getString("oName"));
		list.add(admin);
		}
		ConnectionManager.close(conn,rst,ptmt);
		return list;
	}
	
	public boolean updateAdmin(Admin admin) 
	{
		
		String sql=null; 
		PreparedStatement ptmt=null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        sql="UPDATE `format`.`admin` SET `name`=?, `telephone`=?, `email`=? WHERE `id`=?;";
       
		try {
			ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1,admin.getName());
	        ptmt.setString(2,admin.getTelephone());
	        ptmt.setString(3,admin.getEmail());
	        ptmt.setString(4,admin.getId());
	        int rs = ptmt.executeUpdate();
	        if(rs!=0)
			{
				ConnectionManager.close(conn,ptmt);
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ConnectionManager.close(conn,ptmt);
			return false;
		}
        
		ConnectionManager.close(conn,ptmt);
		return false;
        
        
	}
	
	public boolean deleteAdmin(String id)
	{
		String sql=null; 
		PreparedStatement ptmt=null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        sql="DELETE FROM `format`.`admin` WHERE `id`=?;";

	try {
		ptmt = conn.prepareStatement(sql);
		ptmt.setString(1,id);
        int rs = ptmt.executeUpdate();
        if(rs!=0)
		{
			ConnectionManager.close(conn,ptmt);
			return true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		ConnectionManager.close(conn,ptmt);
		return false;
	}
	ConnectionManager.close(conn,ptmt);
    return false;
		
	}
	
	
	public Boolean addAdmin(String id,String name,String oName)
	{
		String sql=null,sqlFindId=null; 
		int oId=0;
		PreparedStatement ptmt=null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        sqlFindId="select id from organization where name=?";
        sql="INSERT INTO `format`.`admin` (`id`, `password`, `name`, `oid`) VALUES (?, ?, ?, ?);";

        try {
    		ptmt = conn.prepareStatement(sqlFindId);
    		ptmt.setString(1,oName);
    		ResultSet rs = ptmt.executeQuery();
            while(rs.next())
    		{
    			oId=rs.getInt("id");
    		}
        } catch (SQLException e) {
    		// TODO Auto-generated catch block
    		ConnectionManager.close(conn,ptmt);
    		return false;
    	}
        
	try {
		ptmt = conn.prepareStatement(sql);
		ptmt.setString(1,id);
		ptmt.setString(2,id);
		ptmt.setString(3,name);
		ptmt.setInt(4,oId);
        int rs = ptmt.executeUpdate();
        if(rs!=0)
		{
			ConnectionManager.close(conn,ptmt);
			return true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		ConnectionManager.close(conn,ptmt);
		return false;
	}
	ConnectionManager.close(conn,ptmt);
    return false;
		
		
		
	}
	
	
}
