package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Auditor;
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
	
}
