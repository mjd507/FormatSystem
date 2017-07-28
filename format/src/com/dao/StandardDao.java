package com.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;
import com.model.Standard;
import com.util.ConnectionManager;

public class StandardDao {

	public static boolean uploadDocument(MultipartFile file){
		String path=file.getName();
		System.out.println(file);
		String uploadPath="D:\\Apache Software Foundation\\Tomcat 9.0\\webapps\\yzwish\\WebContent\\topicImages\\";
		File targetFile = new File(uploadPath,path);  
        if(!targetFile.exists()){  
        	targetFile.mkdirs();  
        }  
        //保存  
        try {  
            file.transferTo(targetFile);
            return true;
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;
        }  
		
	}
	
	public String  create(Standard s) throws SQLException
	{//create a standard
		
		 //check repeat title
        String sql=null; 
        sql="SELECT * FROM standard WHERE title=?";
		Connection conn = ConnectionManager.getInstance().getConnection();  
		PreparedStatement ptmt=null;
		ResultSet rst=null;
		try {
			ptmt = conn.prepareStatement(sql);	
			ptmt.setString(1, s.getTitle());
			rst = ptmt.executeQuery();	
    		//服务器错误
    		if(rst.next()){
    			return "该文件名已存在!";
    		}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//upload document
		if(!uploadDocument(s.getDocument())){
			return "error";
		}
        
        //insert a standard record
        sql="INSERT INTO `format`.`standard` (`title`, `url`, `updatetime`, `aid`) VALUES (?, ?, ?, ?);";
        ptmt = conn.prepareStatement(sql);
        
        Date date=new Date(System.currentTimeMillis()); 
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeNow=format.format(date);
        
        ptmt.setString(1, s.getTitle());
		ptmt.setString(2, s.getUrl());
		ptmt.setString(3, timeNow);
		ptmt.setString(4, s.getaId());  
		
		int rs = ptmt.executeUpdate();
		
		if(rs==0)
		{
			ConnectionManager.close(conn,ptmt);
			return "新建文档失败";
		}
		
		else
		{
			ConnectionManager.close(conn,ptmt);
			return "新建文档成功";
		}
	 
	}
}
