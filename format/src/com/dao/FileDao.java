package com.dao;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.model.Standard;

public class FileDao {

	public boolean upload(Standard s) {
		MultipartFile document=s.getDocument();
		
		if (document != null) {
			String fileName = document.getOriginalFilename();


			String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
			System.out.println("fileName:" + suffix);

			if (suffix.equals("doc") || suffix.equals("docx")) {
				String uploadPath = "C:\\Users\\Caihui\\Desktop\\format808\\format\\WebContent\\standard\\";// D:\\Github\\FormatSystem\\format\\WebContent\\standard\\";
				File targetFile = new File(uploadPath, s.getUrl());
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				// 保存
				try {
					document.transferTo(targetFile);
					System.out.println("上传成功");
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("上传失败" + e);
					return false;
				}
			}

			else {
				System.out.println("类型错误");
			}

		} else
			System.out.println("未选中文件");
        return false;
	}
}
