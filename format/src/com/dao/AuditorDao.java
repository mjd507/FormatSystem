package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Auditor;
import com.model.Committer;
import com.util.ConnectionManager;

public class AuditorDao {

	public Auditor GetAuditor(String id) throws SQLException
	{//get auditor by id
		
		Auditor auditor=new Auditor();
		String sql = "select auditor.name,auditor.password,auditor.telephone,auditor.email,auditor.did,department.name as dName,organization.id as oId,organization.name as oName from auditor,department,organization where auditor.id=? and auditor.did=department.id and department.oid=organization.id;";
		Connection conn = ConnectionManager.getInstance().getConnection();  
		PreparedStatement ptmt=null;
		ResultSet rst=null;
		
		ptmt = conn.prepareStatement(sql);	
		ptmt.setString(1, id);
		rst = ptmt.executeQuery();	
		while(rst.next())
		{
		auditor.setId(id);
		auditor.setPassword(rst.getString("password"));
		auditor.setName(rst.getString("name"));
		auditor.setTelephone(rst.getString("telephone"));
		auditor.setEmail(rst.getString("email"));
		auditor.setoId(rst.getInt("oId"));
		auditor.setoName(rst.getString("oName"));
		auditor.setdId(rst.getInt("did"));
		auditor.setdName(rst.getString("dName"));
		
		}
		ConnectionManager.close(conn,rst,ptmt);
		return auditor;
		
		
	}

	public List<Auditor> getAuditorForAdminList(String userId) {
		// TODO Auto-generated method stub
		List<Auditor> list=new ArrayList<Auditor>();
		String sql=null; 
		ResultSet rst=null;
		PreparedStatement ptmt=null;
		sql="select auditor.id,auditor.name,auditor.telephone,auditor.email,department.name as dName from auditor,department,organization,admin where admin.oid=organization.id and department.oid=organization.id and auditor.did=department.id and admin.id=?;";
        Connection conn = ConnectionManager.getInstance().getConnection();
        
       
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1,userId);
			rst=ptmt.executeQuery();
	        while(rst.next())
	        {
	        	Auditor auditor=new Auditor();
	        	auditor.setId(rst.getString("id"));
	        	auditor.setName(rst.getString("name"));
	        	auditor.setdName(rst.getString("dName"));
	        	auditor.setTelephone(rst.getString("telephone"));
	        	auditor.setEmail(rst.getString("email"));
	        	System.out.println(auditor.toString());
	        	list.add(auditor);
	        }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ConnectionManager.close(conn,rst,ptmt);
	        return null;
		}
         
        
        ConnectionManager.close(conn,rst,ptmt);
        return list;
	}
	

	public boolean updateAuditor(Auditor auditor) {
		// TODO Auto-generated method stub
		
		String sql=null; 
		PreparedStatement ptmt=null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        sql="UPDATE `format`.`auditor` SET `name`=?, `telephone`=?, `email`=?, did=(select id from department where name=?)WHERE `id`=?;";
       
		try {
			ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1,auditor.getName());
	        ptmt.setString(2,auditor.getTelephone());
	        ptmt.setString(3,auditor.getEmail());
	        ptmt.setString(4,auditor.getdName());
	        ptmt.setString(5,auditor.getId());
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

	public boolean deleteAuditor(String id) {
		// TODO Auto-generated method stub
		String sql=null; 
		PreparedStatement ptmt=null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        sql="DELETE FROM `format`.`auditor` WHERE `id`=?;";

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

	public boolean addAuditor(String addId, String addName, String adddName) {
		// TODO Auto-generated method stub
		String sql=null;
		PreparedStatement ptmt=null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        sql="INSERT INTO `format`.`auditor` (id,`name`,password,did) VALUES (?,?,?,(select id from department where name=?));";

       
	try {
		ptmt = conn.prepareStatement(sql);
		ptmt.setString(1,addId);
		ptmt.setString(2,addName);
		ptmt.setString(3,addId);
		ptmt.setString(4,adddName);
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

