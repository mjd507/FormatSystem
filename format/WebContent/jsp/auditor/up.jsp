<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <link href="../css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/navf.css" rel='stylesheet' type='text/css' />
    <link href="<%=request.getContextPath()%>/css/colrankf.css" rel='stylesheet' type='text/css' />
    <link href="<%=request.getContextPath()%>/css/lbtf.css" rel='stylesheet' type='text/css' />
    <link href="<%=request.getContextPath()%>/font-awesome-4.7.0/css/font-awesome.min.css" rel='stylesheet' type='text/css' />
    <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <!-- 
    <script src="<%=request.getContextPath()%>/js/cbs.js"></script>
    <script src="<%=request.getContextPath()%>/js/lbt.js"></script>
     -->    
     <link rel="stylesheet" href="<%=request.getContextPath()%>/css/message.css" media="screen" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/message.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/dropdownlist.css" media="screen" type="text/css" />
 <script type="text/javascript">

			function displaySubMenu(li) { 
				var subMenu = li.getElementsByTagName("ul")[0]; 
				subMenu.style.display = "block"; 
				} 
				function hideSubMenu(li) { 
				var subMenu = li.getElementsByTagName("ul")[0]; 
				subMenu.style.display = "none"; 
				} 
</script>
 </head>
<body>   
<div class="header-top">
 <% 
   String proName= this.getServletContext().getContextPath()+"/";//项目名称 
  
   //当前页面链接
  String uri= (String)pageContext.getRequest().getAttribute("javax.servlet.forward.request_uri");
  //用于action
    if(uri!=null)
  {
     uri=uri.replace(proName, "");
     //out.println("uri:"+uri);
  }
    else
  {
    	//out.println("uri:null");
  }
  String qs=request.getQueryString();
  System.out.println("QueryString:"+qs);
  //用于jsp
     
	  String url=request.getRequestURL().toString();
	 // out.println("url:"+url);
	 
	 String address=null;//登录前页面
				String adType=null;//登录前页面类型：action。。。
				//结果为action
				if(uri!=null&&!uri.equals("null"))
				{
					//uri中含有?代表request是url编码，地址就为uri
					//非url编码，qs若为空，则处理uri
					if(qs!=null)
					{
					
						if(!qs.equals("null")&&uri.indexOf("?")==-1)
						{
							address=uri+"?"+qs;
						}
					}
					else
						address=uri;
					adType="action";
				}
				//结果为jsp
				else if(url!=null&&!url.equals("null"))
				{
					url=url.substring(url.indexOf("bcnf/")+5);
					if(qs!=null)
					{
						if(!qs.equals("null")&&url.indexOf("?")==-1)//有参数的jsp或html
							address=url+"?"+qs;
					}
					
					else
						address=url;
					adType="jsp";
				}
				String from=address;
				if(from!=null)
				{
					from=from.replace("&", "&amp;");
					from=URLEncoder.encode(from,"UTF-8");
				}
				System.out.println("up.jspfrom："+from);
  %>
  
        <div class="inner">
            <div>
			<a href="/format/" class="siteLogo"></a>
			</div>
            <div class="nav">
                <ul>
                    
                    <li><a href="#">上传模板</a></li>
                    <li><a href="#">我的模板</a></li>
                    <li><a href="#">审核文档</a></li>
                    <li><a href="#">我的审核</a></li>
                </ul>
            </div>
           
            <div class="user fr">

                  <c:if test="${requestScope.login_status!=1}">
				  <a href="<%=request.getContextPath()%>/jsp/login.jsp" class="log signUp">登录/注册</a>
				  </c:if>
				  <c:if test="${requestScope.login_status==1}">
				  <ul id="navigation">
						<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
						    <a href="#">
						    ${auditor.name}
						     <c:if test="${requestScope.unReadMsgNum!=0}">
						    <span class="unread">${requestScope.unReadMsgNum }</span>
						    </c:if>
						    </a>
							<ul>
								<li>
								     <c:if test="${requestScope.unReadMsgNum==0  }">
									 <a href="#">消息中心</a>
									 </c:if>
									 
									 <c:if test="${requestScope.unReadMsgNum!=0  }">
									 <div >
									 <div style="float:left">
									 <a href="#" >
									 个人中心<span class="unread">${requestScope.unReadMsgNum }</span>
									 </a>
									 </div>
									 </div>
									 </c:if>
									 
								</li>
								<li>
									 <a href="#">个人主页</a>
								</li>
								<li>
									 <a href="#">修改密码</a>
								</li>
							</ul>
						</li>
						<li class="dropdown">
							 <a href="/format/">退出</a>							
						</li>
					</ul>
					</c:if>

            </div>

        </div>
</div>
</body> 