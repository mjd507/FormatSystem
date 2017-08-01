package com.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.OrganizationDao;
import com.model.Organization;

@Controller
@RequestMapping("/page")
public class TransController {
	
	
	@RequestMapping("/superAdminToBm")
	public String superAdminIndexToBm(String userName,String userId,Model model,HttpServletRequest request) throws SQLException
	{
		//System.out.println("-------"+request.getParameter("userName")+"---------");
		request.setAttribute("login_status", 1);
		request.setAttribute("userId", userId);
		request.setAttribute("userName", userName);
		
		OrganizationDao od=new OrganizationDao();
		List<Organization> orgList = od.getOrganizationList();
		model.addAttribute("orgList",orgList);
	    return "/jsp/superAdmin/bm";
	}

	
	@RequestMapping("/superAdminToGly")
	public String superAdminIndexToGly(String userName,String userId,Model model,HttpServletRequest request) throws SQLException
	{
		//System.out.println("-------"+request.getParameter("userName")+"---------");
		request.setAttribute("login_status", 1);
		request.setAttribute("userId", userId);
		request.setAttribute("userName", userName);
		
		OrganizationDao od=new OrganizationDao();
		List<Organization> orgList = od.getOrganizationList();
		model.addAttribute("orgList",orgList);
	    return "/jsp/superAdmin/gly";
	}
	
	@RequestMapping("/superAdminToIndex")
	public String superAdminIndexToIndex(String userName,String userId,Model model,HttpServletRequest request) throws SQLException
	{
	
		request.setAttribute("login_status", 1);
		request.setAttribute("userId", userId);
		request.setAttribute("userName", userName);
		
		OrganizationDao od=new OrganizationDao();
		List<Organization> orgList = od.getOrganizationList();
		model.addAttribute("orgList",orgList);
	    return "/jsp/superAdmin/index";
	}
	
	@RequestMapping("/adminToIndex")
	public String adminToIndex(String userName,String userId,Model model,HttpServletRequest request) throws SQLException
	{
	
		request.setAttribute("login_status", 1);
		request.setAttribute("userId", userId);
		request.setAttribute("userName", userName);
		
		OrganizationDao od=new OrganizationDao();
		List<Organization> orgList = od.getOrganizationList();
		model.addAttribute("orgList",orgList);
	    return "/jsp/admin/index";
	}
	

	
	@RequestMapping("/adminToMember")
	public String adminToMember(String userName,String userId,Model model,HttpServletRequest request) throws SQLException
	{
	
		request.setAttribute("login_status", 1);
		request.setAttribute("userId", userId);
		request.setAttribute("userName", userName);
		
		OrganizationDao od=new OrganizationDao();
		List<Organization> orgList = od.getOrganizationList();
		model.addAttribute("orgList",orgList);
	    return "/jsp/admin/member";
	}
	
	@RequestMapping("/adminToAudit")
	public String adminToAudit(String userName,String userId,Model model,HttpServletRequest request) throws SQLException
	{
	
		request.setAttribute("login_status", 1);
		request.setAttribute("userId", userId);
		request.setAttribute("userName", userName);
		
		OrganizationDao od=new OrganizationDao();
		List<Organization> orgList = od.getOrganizationList();
		model.addAttribute("orgList",orgList);
	    return "/jsp/admin/audit";
	}
	@RequestMapping("/adminToData")
	public String adminToData(String userName,String userId,Model model,HttpServletRequest request) throws SQLException
	{
	
		request.setAttribute("login_status", 1);
		request.setAttribute("userId", userId);
		request.setAttribute("userName", userName);
		
		OrganizationDao od=new OrganizationDao();
		List<Organization> orgList = od.getOrganizationList();
		model.addAttribute("orgList",orgList);
	    return "/jsp/admin/data";
	}
}
