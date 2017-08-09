package com.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.AuditorDao;
import com.dao.CommitterDao;
import com.model.Auditor;
import com.model.Committer;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/auditor")
public class AuditorController {
	@RequestMapping("/getList")
	public @ResponseBody String getList(String userId,HttpServletRequest request, HttpServletResponse response) 
	{
		if(userId==null)return null;
        System.out.println("userId:"+userId);
		AuditorDao ad = new AuditorDao();
		List<Auditor> list = ad.getAuditorForAdminList(userId);
        if(list==null)
        	{System.out.println("list null");
        	return null;
        	}
		JSONArray array = new JSONArray();
		Iterator itor = list.iterator();
		while (itor.hasNext()) {
			Auditor temp = (Auditor) itor.next();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("id", temp.getId());
			jsonObj.put("name", temp.getName());
			jsonObj.put("dName", temp.getdName());
			jsonObj.put("telephone", temp.getTelephone());
			jsonObj.put("email", temp.getEmail());
			array.add(jsonObj);
		}

		return array.toString();

	}

	@RequestMapping("/update")
	public void update(HttpServletRequest request,Model model) {

		String jsonString = request.getParameter("data");
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		JSONObject jsonObject = jsonArray.getJSONObject(0);
		Auditor auditor=new Auditor();
		auditor.setId(jsonObject.getString("id"));
		auditor.setName(jsonObject.getString("name"));
		auditor.setTelephone(jsonObject.getString("telephone"));
		auditor.setEmail(jsonObject.getString("email"));
		auditor.setdName(jsonObject.getString("dname"));
		
		
		AuditorDao ad = new AuditorDao();
		boolean b=ad.updateAuditor(auditor);
		if(b==false)
			 model.addAttribute("message","添加失败");
		else model.addAttribute("message","操作成功");

	}

	@RequestMapping("/deleteRecord")
	public void deleteRecord(HttpServletRequest request) {

		String jsonString = request.getParameter("data");
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		JSONObject jsonObject = jsonArray.getJSONObject(0);
		String id = jsonObject.getString("id");
		AuditorDao od = new AuditorDao();
		od.deleteAuditor(id);

	}

	@RequestMapping("/deleteManyRecords")
	public void deleteManyRecords(HttpServletRequest request) {

		String jsonString = request.getParameter("data");
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		// System.out.println(jsonString);
		for (int i = 0; i < jsonArray.size(); i++) {

			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String id = jsonObject.getString("id");
			AuditorDao od = new AuditorDao();
			od.deleteAuditor(id);

		}

	}
	
	@RequestMapping("/add")
	public void add(Model model,String addName,String addId,String adddName) {

		AuditorDao ad = new AuditorDao();
		boolean b=ad.addAuditor(addId,addName,adddName);
		if(b==false)
			 model.addAttribute("message","添加失败");
		else model.addAttribute("message","操作成功");
		 System.out.println(b);
        //return "/jsp/superAdmin/index";

	}
}

