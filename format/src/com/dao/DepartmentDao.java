package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.model.*;
import com.util.ConnectionManager;

public class DepartmentDao {

	public List<Department> getDepartmentList()
	{
		List<Department> list=new ArrayList<Department>();
		String sql=null; 
		ResultSet rst=null;
		PreparedStatement ptmt=null;
		sql="select organization.id as oId,organization.name as oName,department.id,department.name from organization,department where department.oid=organization.id;";
        Connection conn = ConnectionManager.getInstance().getConnection();
        
       
		try {
			ptmt = conn.prepareStatement(sql);
			rst=ptmt.executeQuery();
	        while(rst.next())
	        {
	        	Department department=new Department();
	        	department.setId(rst.getInt("id"));
	        	department.setName(rst.getString("name"));
	        	department.setoId(rst.getInt("oId"));
	        	department.setoName(rst.getString("oName"));
	        	list.add(department);
	        }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ConnectionManager.close(conn,rst,ptmt);
	        return null;
		}
         
        
        ConnectionManager.close(conn,rst,ptmt);
        return list;
        
	}
	
	public boolean updateDepartment(int dId,String newName) 
	{
		
		String sql=null; 
		PreparedStatement ptmt=null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        sql="UPDATE `format`.`department` SET `name`=? WHERE `id`=?;";
       
		try {
			ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1,newName);
	        ptmt.setInt(2,dId);
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
	
	public boolean deleteDepartment(int id)
	{
		String sql=null; 
		PreparedStatement ptmt=null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        sql="DELETE FROM `format`.`department` WHERE `id`=?;";

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

	public boolean addDepartment(String addName, String orgName) {
		// TODO Auto-generated method stub
		String sql=null,sqlFindId=null; 
		int oId=0;
		PreparedStatement ptmt=null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        sqlFindId="select id from organization where name=?";
        sql="INSERT INTO `format`.`department` (`name`, `oid`) VALUES (£¿, £¿);";

        try {
    		ptmt = conn.prepareStatement(sqlFindId);
    		ptmt.setString(1,orgName);
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
		ptmt.setString(1,addName);
		ptmt.setInt(2,oId);
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

	public List<Department> getDepartmentForAdminList(String userId) {
		// TODO Auto-generated method stub
		
		List<Department> list=new ArrayList<Department>();
		String sql=null; 
		ResultSet rst=null;
		PreparedStatement ptmt=null;
		sql="select organization.id as oId,organization.name as oName,department.id,department.name from organization,department,admin where department.oid=organization.id and admin.oid=organization.id and admin.id=?;";
        Connection conn = ConnectionManager.getInstance().getConnection();
        
       
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1,userId);
			rst=ptmt.executeQuery();
	        while(rst.next())
	        {
	        	Department department=new Department();
	        	department.setId(rst.getInt("id"));
	        	department.setName(rst.getString("name"));
	        	department.setoId(rst.getInt("oId"));
	        	department.setoName(rst.getString("oName"));
	        	list.add(department);
	        }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ConnectionManager.close(conn,rst,ptmt);
	        return null;
		}
         
        
        ConnectionManager.close(conn,rst,ptmt);
        return list;
	}
	
	
}
