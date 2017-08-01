package com.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.CommitterDao;
import com.dao.DepartmentDao;
import com.model.Committer;
import com.model.Department;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/committer")
public class CommitterController {
	
	
	@RequestMapping("/getList")
	public @ResponseBody String getList(String userId,String userName,HttpServletRequest request, HttpServletResponse response) {


		if(userId==null)return null;
		CommitterDao cd = new CommitterDao();
		List<Committer> list = cd.getCommitterForAdminList(userId);

		JSONArray array = new JSONArray();
		Iterator itor = list.iterator();
		while (itor.hasNext()) {
			Committer temp = (Committer) itor.next();
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
