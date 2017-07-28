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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/message.css" media="screen" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/dropdownlist.css" media="screen" type="text/css" />
    <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/message.js"></script>
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
 <div class="inner">
            <div>
			<a href="/format/" class="siteLogo"></a>
			</div>
            <div class="nav">
                <ul>
                    
                    <li><a href="#">部门管理</a></li>
                    <li><a href="#">成员管理</a></li>
                    <li><a href="#">审核情况</a> 
                    <li><a href="#">数据统计</a> 
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
						    ${admin.name}
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