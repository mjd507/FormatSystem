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
import com.dao.DepartmentDao;
import com.model.Department;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@RequestMapping("/getList")
	public @ResponseBody String getList(HttpServletRequest request, HttpServletResponse response) {
System.out.println("------------getlist");
		DepartmentDao od = new DepartmentDao();
		List<Department> list = od.getDepartmentList();

		JSONArray array = new JSONArray();
		Iterator itor = list.iterator();
		while (itor.hasNext()) {
			Department temp = (Department) itor.next();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("id", temp.getId());
			jsonObj.put("name", temp.getName());
			jsonObj.put("oName", temp.getoName());
			jsonObj.put("oId", temp.getoId());
			array.add(jsonObj);
		}

		return array.toString();

	}

	@RequestMapping("/changeName")
	public void changeName(HttpServletRequest request,Model model) {

		String jsonString = request.getParameter("data");
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		JSONObject jsonObject = jsonArray.getJSONObject(0);
		int id = jsonObject.getInt("id");
		String name = jsonObject.getString("name");
		DepartmentDao od = new DepartmentDao();
		boolean b=od.updateDepartment(id, name);
		if(b==false)
			 model.addAttribute("message","添加失败");
		else model.addAttribute("message","操作成功");

	}

	@RequestMapping("/deleteRecord")
	public void deleteRecord(HttpServletRequest request) {

		String jsonString = request.getParameter("data");
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		JSONObject jsonObject = jsonArray.getJSONObject(0);
		int id = jsonObject.getInt("id");
		DepartmentDao od = new DepartmentDao();
		od.deleteDepartment(id);

	}

	@RequestMapping("/deleteManyRecords")
	public void deleteManyRecords(HttpServletRequest request) {

		String jsonString = request.getParameter("data");
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		for (int i = 0; i < jsonArray.size(); i++) {

			JSONObject jsonObject = jsonArray.getJSONObject(i);
			int id = jsonObject.getInt("id");
			DepartmentDao od = new DepartmentDao();
			od.deleteDepartment(id);

		}

	}
	
	@RequestMapping("/add")
	public String add(Model model,String orgName,String addName) {

		DepartmentDao od = new DepartmentDao();
		boolean b=od.addDepartment(addName,orgName);
		if(b==false)
			 model.addAttribute("message","添加失败");
		else model.addAttribute("message","操作成功");
        return "/jsp/superAdmin/bm";

		}

	
	@RequestMapping("/getListForAdmin")
	public @ResponseBody String getListForAdmin(String userId,HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------getlist");
        if(userId==null)return null;
		DepartmentDao od = new DepartmentDao();
		List<Department> list = od.getDepartmentForAdminList(userId);

		JSONArray array = new JSONArray();
		Iterator itor = list.iterator();
		while (itor.hasNext()) {
			Department temp = (Department) itor.next();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("id", temp.getId());
			jsonObj.put("name", temp.getName());
			jsonObj.put("oName", temp.getoName());
			jsonObj.put("oId", temp.getoId());
			array.add(jsonObj);
		}

		return array.toString();

	}

}
