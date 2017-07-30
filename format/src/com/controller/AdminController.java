package com.controller;

import java.sql.SQLException;
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
import com.model.Admin;
import com.model.Organization;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin")
	public class AdminController {

		@RequestMapping("/getList")
		public @ResponseBody String getList(Model model,HttpServletRequest request, HttpServletResponse response) throws SQLException {

			AdminDao ad=new AdminDao();
			List<Admin> list = ad.getAdminList();
			JSONArray array = new JSONArray();
			Iterator itor = list.iterator();
			while (itor.hasNext()) {
				Admin temp = (Admin) itor.next();
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("id", temp.getId());
				jsonObj.put("name", temp.getName());
				jsonObj.put("telephone", temp.getTelephone());
				jsonObj.put("email", temp.getEmail());
				jsonObj.put("oName", temp.getoName());
				array.add(jsonObj);
			}

			
			
			
			return array.toString();

		}
		

		@RequestMapping("/update")
		public void changeName(HttpServletRequest request) {

			String jsonString = request.getParameter("data");
			JSONArray jsonArray = JSONArray.fromObject(jsonString);
			JSONObject jsonObject = jsonArray.getJSONObject(0);
			
			Admin admin=new Admin();
			admin.setId(jsonObject.getString("id"));
			admin.setName(jsonObject.getString("name"));
			admin.setTelephone(jsonObject.getString("telephone"));
			admin.setEmail(jsonObject.getString("email"));
			AdminDao od = new AdminDao();
			od.updateAdmin(admin);

		}

		@RequestMapping("/deleteRecord")
		public void deleteRecord(HttpServletRequest request) {

			String jsonString = request.getParameter("data");
			JSONArray jsonArray = JSONArray.fromObject(jsonString);
			JSONObject jsonObject = jsonArray.getJSONObject(0);
			String id = jsonObject.getString("id");
			AdminDao od = new AdminDao();
			od.deleteAdmin(id);

		}

		@RequestMapping("/deleteManyRecords")
		public void deleteManyRecords(HttpServletRequest request) {

			String jsonString = request.getParameter("data");
			JSONArray jsonArray = JSONArray.fromObject(jsonString);
			// System.out.println(jsonString);
			for (int i = 0; i < jsonArray.size(); i++) {

				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String id = jsonObject.getString("id");
				AdminDao od = new AdminDao();
				od.deleteAdmin(id);

			}

		}
		
		@RequestMapping("/add")
		public String addRecord(Model model,String orgName,String addId,String addName) {

			//System.out.println(orgName+"-"+addId+"-"+addName+"-");
           
			AdminDao ad=new AdminDao();
			boolean b=ad.addAdmin(addId, addName,orgName);
			if(b==false)
				 model.addAttribute("message","添加失败");
			else model.addAttribute("message","操作成功");
            return "/jsp/superAdmin/gly";
		}
	}
		
