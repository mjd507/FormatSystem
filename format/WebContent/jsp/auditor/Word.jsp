<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*"
	pageEncoding="utf-8"%>
<%
	//获取客户端传递的参数
	out.println("param1:" + request.getParameter("param1"));
	out.println("<br>");
	out.println("param2:" + request.getParameter("param2"));
	
	PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
	//设置服务器页面
	poCtrl.setServerPage(request.getContextPath() + "/poserver.zz");
	poCtrl.setJsFunction_AfterDocumentOpened("AfterDocumentOpened");
	poCtrl.addCustomToolButton("保存","Save",1);
	poCtrl.setSaveFilePage("SaveFile.jsp");
	poCtrl.webOpen("/format/doc/test.doc", OpenModeType.docNormalEdit, "张佚名");
    out.println(poCtrl.getHtmlCode("PageOfficeCtrl1"));
    
%>

