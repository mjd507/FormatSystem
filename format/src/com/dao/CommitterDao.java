package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
}
