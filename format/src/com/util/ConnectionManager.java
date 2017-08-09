package com.util;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionManager {
	
    private static ConnectionManager instance;  
    private ComboPooledDataSource dataSource;
	
	
	private static String DBIP="127.0.0.1";
	
	
	//public static String picUploadPath="D:\\Apache Software Foundation\\Tomcat 9.0\\webapps\\yzwish\\verifiedImg\\";
	public static String picUploadPath="D:\\Apache Software Foundation\\Tomcat 9.0\\webapps\\yzwish\\WebContent\\verifiedImg\\";
	

	
    private ConnectionManager() throws SQLException, PropertyVetoException {  
        dataSource = new ComboPooledDataSource(); 
        
      
        dataSource.setUser("root");  
        dataSource.setPassword("0000"); 
        dataSource.setJdbcUrl("jdbc:mysql://"+DBIP+":3306/format?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");  
        dataSource.setInitialPoolSize(5); 
        dataSource.setMinPoolSize(1); 
        dataSource.setMaxPoolSize(10);  
        dataSource.setMaxStatements(50);
        dataSource.setMaxIdleTime(60);
    }  
  
    public static final ConnectionManager getInstance() {  
        if (instance == null) {  
            try {  
                instance = new ConnectionManager();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return instance;  
    }  
  
    public synchronized final Connection getConnection() {  
        Connection conn = null;  
        try {  
            conn = dataSource.getConnection();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return conn;  
    }  
    
    public static void close(Connection conn){
    	try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void close(Connection conn,PreparedStatement ptmt) {
    	
    	if(ptmt!=null){
    		try {
				ptmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(conn!=null){
    		try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    
}
  
    public static void close(Connection conn,ResultSet rst,PreparedStatement ptmt) {
    	
        	if(rst!=null){
        		try {
					rst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	if(ptmt!=null){
        		try {
					ptmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	if(conn!=null){
        		try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        
	}

	
	public static ResultSet excuteSelect(String sql,Connection conn,PreparedStatement ptmt,ResultSet rs) {
		 try {
			
			 ptmt=conn.prepareStatement(sql);
			
			 rs = ptmt.executeQuery();  
			 return rs;
			} catch (SQLException e) {  
	             e.printStackTrace();  
	             return null;
	        }	 
	}
	
	
	public static boolean excuteIUD(String sql,Connection conn,PreparedStatement ptmt){
	     int n=0;
         try {  
      		ptmt=conn.prepareStatement(sql);
      		n= ptmt.executeUpdate(); 
          } catch (SQLException e) {  
              e.printStackTrace();  
          } 
         if(n!=0)return true;
 		 return false;         
	}
	

}

