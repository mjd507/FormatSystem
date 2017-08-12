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

	public String create(Standard s) throws SQLException {// create a standard
         System.out.println("StandardDao"+s.toString());
		// insert a standard record
         
		String sql = "INSERT INTO `format`.`standard` (`title`, `url`, `updatetime`, `aid`) VALUES (?, ?, ?, ?);";
		Connection conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);

		Date date = new Date(System.currentTimeMillis());
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeNow = format.format(date);

		ptmt.setString(1, s.getTitle());
		ptmt.setString(2, s.getUrl());
		ptmt.setString(3, timeNow);
		ptmt.setString(4, s.getaId());

		int rs = ptmt.executeUpdate();

		if (rs == 0) {
			ConnectionManager.close(conn, ptmt);
			return "新建文档失败";
		}

		else {
			ConnectionManager.close(conn, ptmt);
			FileDao fd=new FileDao();
			fd.upload(s);
			return "新建文档成功";
		}
		

	}
}
