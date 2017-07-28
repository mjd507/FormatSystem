package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.model.*;
import com.util.ConnectionManager;

public class DepartmentDao {

	public List<Department> getDepartmentList(int oId)
	{
		List<Department> list=new ArrayList<Department>();
		String sql=null; 
		ResultSet rst=null;
		PreparedStatement ptmt=null;
		sql="SELECT * FROM format.organization;";
        Connection conn = ConnectionManager.getInstance().getConnection();
        
       
		try {
			ptmt = conn.prepareStatement(sql);
			rst=ptmt.executeQuery();
	        while(rst.next())
	        {
	        	Department department=new Department();
	        	department.setId(rst.getInt("id"));
	        	department.setName(rst.getString("name"));
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
	
	public boolean deleteDepartment(int id,int oId)
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
}
