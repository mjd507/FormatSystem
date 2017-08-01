package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Committer;
import com.util.ConnectionManager;

public class CommitterDao {

	
	public Committer GetCommitter(String id) throws SQLException
	{//get committer by id
		
		Committer committer=new Committer();
		String sql = "select committer.name,committer.password,committer.telephone,committer.email,committer.did,department.name as dName,organization.id as oId,organization.name as oName from committer,department,organization where committer.id=? and committer.did=department.id and department.oid=organization.id;";
		Connection conn = ConnectionManager.getInstance().getConnection();  
		PreparedStatement ptmt=null;
		ResultSet rst=null;
		
		ptmt = conn.prepareStatement(sql);	
		ptmt.setString(1, id);
		rst = ptmt.executeQuery();	
		while(rst.next())
		{
			committer.setId(id);
			committer.setPassword(rst.getString("password"));
			committer.setName(rst.getString("name"));
			committer.setTelephone(rst.getString("telephone"));
			committer.setEmail(rst.getString("email"));
			committer.setoId(rst.getInt("oId"));
			committer.setoName(rst.getString("oName"));
			committer.setdId(rst.getInt("did"));
			committer.setdName(rst.getString("dName"));
		}
		ConnectionManager.close(conn,rst,ptmt);
		return committer;
		
	}

	public List<Committer> getCommitterForAdminList(String userId) {
		// TODO Auto-generated method stub
		 
		List<Committer> list=new ArrayList<Committer>();
		String sql=null; 
		ResultSet rst=null;
		PreparedStatement ptmt=null;
		sql="select committer.id,committer.name,committer.department.name as dName from committer,department,organization,admin where admin.oid=organization.id and department.oid=organization.id and committer.did=department.id and admin.id=?;";
        Connection conn = ConnectionManager.getInstance().getConnection();
        
       
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1,userId);
			rst=ptmt.executeQuery();
	        while(rst.next())
	        {
	        	Committer committer=new Committer();
	        	committer.setId(rst.getString("id"));
	        	committer.setName(rst.getString("name"));
	        	committer.setdName(rst.getString("dName"));
	        	committer.setTelephone(rst.getString("telephone"));
	        	committer.setEmail(rst.getString("email"));
	        	list.add(committer);
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
