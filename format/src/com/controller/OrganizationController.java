package com.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.AdminDao;
import com.dao.OrganizationDao;
import com.model.Organization;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/organization")
public class OrganizationController {

	@RequestMapping("/getList")
	public @ResponseBody String getList(HttpServletRequest request, HttpServletResponse response) {

		OrganizationDao od = new OrganizationDao();
		List<Organization> list = od.getOrganizationList();

		JSONArray array = new JSONArray();
		Iterator itor = list.iterator();
		while (itor.hasNext()) {
			Organization temp = (Organization) itor.next();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("id", temp.getId());
			jsonObj.put("name", temp.getName());
			array.add(jsonObj);
		}

		return array.toString();

	}
	
	@RequestMapping("/getOutList")
	public @ResponseBody String getOutList(HttpServletRequest request, HttpServletResponse response) {
   //try to add to select but fail
		
		//System.out.println("start");
		OrganizationDao od = new OrganizationDao();
		List<Organization> list = od.getOrganizationList();

		JSONArray array = new JSONArray();
		Iterator itor = list.iterator();
		JSONObject jsonOutObj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		
		while (itor.hasNext()) {
			Organization temp = (Organization) itor.next();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("id", temp.getId());
			jsonObj.put("name", temp.getName());
			array.add(jsonObj);
		}
		jsonOutObj.put("data", array);
		jsonArray.add(jsonOutObj);

		return array.toString();

	}
	

	@RequestMapping("/changeName")
	public void changeName(HttpServletRequest request) {

		String jsonString = request.getParameter("data");
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		JSONObject jsonObject = jsonArray.getJSONObject(0);
		int id = jsonObject.getInt("id");
		String name = jsonObject.getString("name");
		OrganizationDao od = new OrganizationDao();
		od.updateOrganization(id, name);

	}

	@RequestMapping("/deleteRecord")
	public void deleteRecord(HttpServletRequest request) {

		String jsonString = request.getParameter("data");
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		JSONObject jsonObject = jsonArray.getJSONObject(0);
		int id = jsonObject.getInt("id");
		OrganizationDao od = new OrganizationDao();
		od.deleteOrganization(id);

	}

	@RequestMapping("/deleteManyRecords")
	public void deleteManyRecords(HttpServletRequest request) {

		String jsonString = request.getParameter("data");
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		// System.out.println(jsonString);
		for (int i = 0; i < jsonArray.size(); i++) {

			JSONObject jsonObject = jsonArray.getJSONObject(i);
			int id = jsonObject.getInt("id");
			OrganizationDao od = new OrganizationDao();
			od.deleteOrganization(id);

		}

	}
	
	@RequestMapping("/add")
	public String add(Model model,String addName) {

		OrganizationDao od = new OrganizationDao();
		boolean b=od.addOrganization(addName);
		if(b==false)
			 model.addAttribute("message","添加失败");
		else model.addAttribute("message","操作成功");
		 System.out.println(b);
        return "/jsp/superAdmin/index";

	}
}
