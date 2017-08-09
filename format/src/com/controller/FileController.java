package com.controller;

import java.io.File;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.dao.StandardDao;
import com.model.Standard;

@Controller
@RequestMapping("/file")
public class FileController {

	@RequestMapping("/uploadStandard")
	public String upload(MultipartFile document,Standard standard,HttpServletRequest request,HttpSession session) throws SQLException
	{
		
		if(document!=null)
		{
		System.out.println("文件不空");	
		String fileName=document.getOriginalFilename();
		standard.setUrl("../standard/"+fileName);

		//StandardDao sd=new StandardDao();
		//sd.create(standard);
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);  
        System.out.println("fileName:"+suffix); 
        
        if(suffix.equals("doc")||suffix.equals("docx"))
        {
		String uploadPath="D:\\Github\\FormatSystem\\format\\WebContent\\standard\\";
		System.out.print("request.getRequestURI(): "+request.getRequestURI() );
		File targetFile1 = new File(uploadPath,standard.getUrl());  
          if(!targetFile1.exists())
           {  
            targetFile1.mkdirs();  
           }  
        //保存  
          try {  
        	document.transferTo(targetFile1);  
            //return true;
        	System.out.println("上传成功");
              } catch (Exception e) 
              {  
            e.printStackTrace();  
            System.out.println("上传失败"+e);
            //return false;
             }  
        }
        
        else {System.out.println("类型错误");}
		
		}
		else System.out.println("未选中文件");
		return "jsp/committer/index";
		
		
	}
}
