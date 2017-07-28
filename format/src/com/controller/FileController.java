package com.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.StandardDao;
import com.model.Standard;

@Controller
@RequestMapping("/file")
public class FileController {

	@RequestMapping("/uploadStandard")
	public String upload(Standard standard,HttpServletRequest request,HttpSession session) throws SQLException
	{
		if(standard.getDocument()!=null)
		{
			
		standard.setUrl("../standard/"+standard.getDocument().getOriginalFilename());

		StandardDao sd=new StandardDao();
		sd.create(standard);
		
		}
		else System.out.println("未选中文件");
		return "format/jsp/auditor/auditorIndex";
		
		
	}
}
