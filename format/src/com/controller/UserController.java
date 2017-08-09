package com.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.*;
import com.model.*;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/login")
	public String login(Model model,String id,String password,String duty,HttpServletRequest request) throws SQLException
	{
		
		boolean isRight=false;
		UserDao ud=new UserDao();
		isRight=ud.checkLogin(id, password, duty);
		
		if(isRight==true)
	{
		request.setAttribute("login_status", 1);
	    //
		OrganizationDao od=new OrganizationDao();
		List<Organization> orgList = od.getOrganizationList();
		model.addAttribute("orgList",orgList);
		
		if(duty.equals("admin"))
		{
			AdminDao ad=new AdminDao();
			Admin admin=new Admin();
			admin=ad.GetAdmin(id);
			request.setAttribute("admin", admin);
			request.setAttribute("userId", admin.getId());
			request.setAttribute("userName", admin.getName());
			return "/jsp/admin/index";
		}
		else if(duty.equals("auditor"))
		{
			AuditorDao ad=new AuditorDao();
			Auditor auditor=new Auditor();
			auditor=ad.GetAuditor(id);
			request.setAttribute("auditor", auditor);
			return "/jsp/auditor/index";
		}
		else if(duty.equals("committer"))
		{
			CommitterDao cd=new CommitterDao();
			Committer committer=new Committer();
			committer=cd.GetCommitter(id);
			request.setAttribute("committer", committer);
			return "/jsp/committer/index";
		}
		else if(duty.equals("superAdmin"))
		{
			SuperAdminDao sd=new SuperAdminDao();
			SuperAdmin superAdmin=new SuperAdmin();
			superAdmin=sd.GetSuperAdmin(id);
			request.setAttribute("superAdmin", superAdmin);
			request.setAttribute("userId", superAdmin.getId());
			request.setAttribute("userName", superAdmin.getName());
			return "/jsp/superAdmin/index";
		}
	}
		request.setAttribute("login_status", 0);
		request.setAttribute("message", "账号或密码错误");
		return "/jsp/login";
		
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET) 
    public ModelAndView logout(HttpSession session,HttpServletRequest request,String from){  
		if(from!=null)
		{
		
			from=from.replace("&amp;", "&");
			try {
				from=URLEncoder.encode(from,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("from", from);
		System.out.println("from:"+from);
		
		//清除会话域状态
		if(session!=null)
		{
			System.out.println("清除此次会话");
			session.invalidate();
		}

		return new ModelAndView("redirect:/jsp/index.jsp?from="+from);
	}
	
}
