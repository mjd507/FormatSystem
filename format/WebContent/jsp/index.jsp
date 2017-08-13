<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URLDecoder"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>格文致知—文档格式检测与规范平台</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link href="<%=request.getContextPath()%>/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<meta http-equiv="charset" content="UTF-8">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->

<link href='http://fonts.lug.ustc.edu.cn/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.lug.ustc.edu.cn/css?family=Niconne' rel='stylesheet' type='text/css'>
<link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/bootstrap-social.css" rel="stylesheet" type="text/css">	
<link href="<%=request.getContextPath()%>/css/templatemo_style.css" rel="stylesheet" type="text/css">
<script type="application/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/js/demo.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/message.css" media="screen" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/message.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/dropdownlist.css" media="screen" type="text/css" />
<!--/script-->
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			})
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

<%
  System.out.println("index.jsp:");
  String qs=request.getQueryString();
   if(qs!=null)//参数不空
 {
   if(qs.indexOf("from")!=-1)//找得到from参数
  {
  
	   String from=request.getParameter("from");
	   System.out.println("URL里有from");
  
	   if(from!=null&&!from.equals("null")&&!from.equals("")) 
	  {
		  
		  System.out.println("firstfrom: "+from);
		  from=from.replace("&amp;", "&");
		  System.out.println("初始前端得到的from: "+from);
		  //from=URLEncoder.encode(from,"UTF-8");
		  System.out.println("前端得到的加码from:"+from);
		  //from=java.net.URLDecoder.decode(from, "UTF-8");
		  //from=from.replace("%3F", "?").replace("%3D","=").replace("%26", "&");
		  System.out.println("前端转发前的from:"+from);
		  response.sendRedirect("/format/"+from);
	  
      } 
	   else{
		  // System.out.println("不进入上面！");
	   }
  }
  else
  {
	 // System.out.println("from kong!");
  }
 }
  %>
  
	<!-- header-section-starts -->
	<div class="header-banner">
		<div class="container">
			<div class="header-top">
				<div class="social-icons">
				<c:if test="${sessionScope.login_status!=1}">
				  <a href="/format/jsp/login.jsp" id="login" style="font-size:20px;">注册/登录</a>
				</c:if>
				
				<c:if test="${sessionScope.login_status==1}">
				<ul id="navigation">
						<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"> 
						    <a href="#">
						    ${userName}
						    <c:if test="${requestScope.unReadMsgNum!=0}">
						    <span class="unread">${requestScope.unReadMsgNum }</span>
						    </c:if>
						    </a>
							<ul>
								<li>
								     <c:if test="${requestScope.unReadMsgNum==0  }">
									 <a href="#">个人中心</a>
									 </c:if>
									 
									 <c:if test="${requestScope.unReadMsgNum!=0  }">
									 <div >
									 <div style="float:left">
									 <a href="#">个人中心<span class="unread">${requestScope.unReadMsgNum }</span>
									 </a>
									 </div>
									 </div>
									 </c:if>
								</li>
								<li>
									 <a href="#">个人主页</a>
								</li>
							</ul>
						</li>
						<li class="dropdown">
							 <a href="#">退出</a>							
						</li>
					</ul>
					</c:if>
				</div>
			
				
				<!-- script for menu -->
					<script> 
						$( "span.menu" ).click(function() {
						$( ".top-menu ul" ).slideToggle( 300, function() {
						 // Animation complete.
						});
						});
					</script>
				<!-- //script for menu -->

				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
			<!--标题-->
			<div class="banner-info text-center">
				<h1><a href="<%=request.getContextPath()%>/">Format Controller</a></h1>
			</div>


			<!--四个导航-->
			<div class="header-bottom-grids text-center">
				<div class="header-bottom-grid1">
					<span class="glyphicon glyphicon-leaf"></span>
					<br/>
					<br/>
					<br/>
					<a href="#">用户</a>
				</div>
				<div class="header-bottom-grid2">
					<span class="glyphicon glyphicon-certificate"></span>
					<br/>
					<br/>
					<br/>
					<a href="#">部门审核人</a>
				</div>
				<div class="header-bottom-grid3">
					<span class="glyphicon glyphicon-tree-deciduous"></span>
					<br/>
					<br/>
					<br/>
					<a href="#">管理员</a>
				</div>
				<div class="header-bottom-grid4">
					<span class="glyphicon glyphicon-screenshot"></span>
					<br/>
					<br/>
					<br/>
					<a href="#">超级管理员</a> 
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!--注册登录框-->
		<div id="loginForm" class="text-center">
		</div>
	</div>
	<!-- header-section-ends -->
	<!-- content-section-starts -->
	<div class="services">
		<div class="container">
			<!--四个导航概述-->
			<div class="services-top-grids text-center">
				<div class="secvice-top-grid-1">
					<h3>用户</h3>
					<p>文档格式检测，自动规范，提交审核</p>
					<div class="icon1">
						<i class="icon1"></i>
					</div>
				</div>
				<div class="secvice-top-grid-2">
					<h3>部门审核人</h3>
					<p>审核提交的规范化文档，提交审核意见</p>
					<div class="icon1">
						<i class="icon2"></i>
					</div>
				</div>
				<div class="secvice-top-grid-3">
					<h3>管理员</h3>
					<p>用户和部门审核人职能分配，查看审核数据</p>
					<div class="icon1">
						<i class="icon3"></i>
					</div>
				</div>
				<div class="secvice-top-grid-4">
					<h3>超级管理员</h3>
					<p>组织管理，保证隐私权限，给予绝对的数据安全</p>
					<div class="icon1">
						<i class="icon4"></i>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>

		</div>
		<div style="height:100px"></div>
		<div class="footer">
		<div class="container">
			<div class="copyright text-center">
				<p>Copyright © 2017 Format Controller All Rights Reserved.</p>
                <p>Format Controller 版权所有</p>
			</div>
		</div>
	</div>
	</div>
</body>
</html>