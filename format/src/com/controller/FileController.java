package com.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.dao.StandardDao;
import com.model.Standard;

@Controller
@RequestMapping("/file")
public class FileController {

	@RequestMapping("/uploadStandard")
	public String  upload(Model model,MultipartFile document,String title,String userName,String userId,HttpServletRequest request,HttpSession session) throws SQLException
	{
		
		StandardDao sd=new StandardDao();
		Standard s=new Standard();
		s.setFile(document);
		s.setTitle(title);
		s.setaId(userId);
		String fileName = document.getOriginalFilename();
		s.setUrl("../standard/" + fileName);
		String message=sd.create(s);
		model.addAttribute("message",message);
		
		return "jsp/auditor/index";
		
		
	}
}
