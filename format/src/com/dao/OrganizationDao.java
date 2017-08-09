package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.model.*;
import com.util.ConnectionManager;

public class OrganizationDao {

	public List<Organization> getOrganizationList()
	{
		List<Organization> list=new ArrayList<Organization>();
		String sql=null; 
		ResultSet rst=null;
		PreparedStatement ptmt=null;
		sql="SELECT * FROM format.organization order by id asc;";
        Connection conn = ConnectionManager.getInstance().getConnection();
        
       
		try {
			ptmt = conn.prepareStatement(sql);
			rst=ptmt.executeQuery();
	        while(rst.next())
	        {
	        	Organization organization=new Organization();
	        	organization.setId(rst.getInt("id"));
	        	organization.setName(rst.getString("name"));
	        	list.add(organization);
	        }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ConnectionManager.close(conn,rst,ptmt);
	        return null;
		}
         
        
        ConnectionManager.close(conn,rst,ptmt);
        return list;
        
	}
	
	public boolean updateOrganization(int id,String newName) 
	{
		
		String sql=null; 
		PreparedStatement ptmt=null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        sql="UPDATE `format`.`organization` SET `name`=? WHERE `id`=?;";
       
		try {
			ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1,newName);
	        ptmt.setInt(2,id);
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
	
	public boolean deleteOrganization(int id)
	{
		String sql=null; 
		PreparedStatement ptmt=null;
    Connection conn = ConnectionManager.getInstance().getConnection();
    sql="DELETE FROM `format`.`organization` WHERE `id`=?;";

	try {
		ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1,id);
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

	public boolean addOrganization(String addName) {
		// TODO Auto-generated method stub
		

		String sql=null; 
		PreparedStatement ptmt=null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        sql="INSERT INTO `format`.`organization` (`name`) VALUES (?);";

        try {
    		ptmt = conn.prepareStatement(sql);
    		ptmt.setString(1,addName);
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
