package com.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.CommitterDao;
import com.model.Committer;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/committer")
public class CommitterController {
	
	
	@RequestMapping("/getList")
	public @ResponseBody String getList(String userId,HttpServletRequest request, HttpServletResponse response) 
	{
		if(userId==null)return null;
        //System.out.println("userId:"+userId);
		CommitterDao cd = new CommitterDao();
		List<Committer> list = cd.getCommitterForAdminList(userId);
        if(list==null)
        	{System.out.println("list null");
        	return null;
        	}
		JSONArray array = new JSONArray();
		Iterator itor = list.iterator();
		while (itor.hasNext()) {
			Committer temp = (Committer) itor.next();
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
		Committer committer=new Committer();
		committer.setId(jsonObject.getString("id"));
		committer.setName(jsonObject.getString("name"));
		committer.setTelephone(jsonObject.getString("telephone"));
		committer.setEmail(jsonObject.getString("email"));
		committer.setdName(jsonObject.getString("dname"));
		
		
		CommitterDao od = new CommitterDao();
		boolean b=od.updateCommitter(committer);
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
		CommitterDao od = new CommitterDao();
		od.deleteCommitter(id);

	}

	@RequestMapping("/deleteManyRecords")
	public void deleteManyRecords(HttpServletRequest request) {

		String jsonString = request.getParameter("data");
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		// System.out.println(jsonString);
		for (int i = 0; i < jsonArray.size(); i++) {

			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String id = jsonObject.getString("id");
			CommitterDao od = new CommitterDao();
			od.deleteCommitter(id);

		}

	}
	
	@RequestMapping("/add")
	public String add(Model model,String addName,String addId,String adddName) {

		CommitterDao cd = new CommitterDao();
		boolean b=cd.addCommitter(addId,addName,adddName);
		if(b==false)
			 model.addAttribute("message","添加失败");
		else model.addAttribute("message","操作成功");
		 System.out.println(b);
        return "/jsp/admin/committer";

	}
}
