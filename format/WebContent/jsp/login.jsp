<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<title>登录/注册</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/bootstrap-social.css" rel="stylesheet" type="text/css">	
	<link href="<%=request.getContextPath()%>/css/templatemo_style.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/css/colrank.css" rel='stylesheet' type='text/css' />
    <link href="<%=request.getContextPath()%>/css/nav.css" rel='stylesheet' type='text/css' />
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
    <link href="<%=request.getContextPath()%>/css/lbt.css" rel='stylesheet' type='text/css' />
    <script src="<%=request.getContextPath()%>/js/lbt.js"></script>
	<script src="<%=request.getContextPath()%>/js/uploadPreview.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/login.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.js" type="text/javascript"></script>
	<style type="text/css">
	span{
         color:red;
         }
	/*
	div{
	border:1px solid red;
	}
	*/
	</style>	
</head>



<body class="templatemo-bg-image-1">

<script type="text/javascript">
function checkForm()
{
	
	if(document.getElementById("id").value=="")
		{
		
		alert("账号不能为空");
		return false;
		}
	
	if(document.getElementById("password").value=="")
	{
	
	alert("密码不能为空");
	return false;
	}
	
	if(document.getElementById("id").value.length>11)
	{
	
	alert("账号长度不超过11个字符");
	return false;
	}
	
	if(document.getElementById("password").value.length>20)
	{
	
	alert("密码长度不超过20个字符");
	return false;
	}

    return true;
	
}
</script>

	 <div class="header-top">
	    <div class="inner">
			<div class="siteLogo">
			<a href="<%=request.getContextPath()%>/"></a>
			</div>
            <div class="user fr">
            </div>
        </div>
	</div>

	    <div class="container">
	   
		<div class="col-md-12">	
		<%String from=request.getParameter("from"); %>
		<%//request.setAttribute("uri", request.getParameter("uri")); %>
			<form id=f1 class="form-horizontal templatemo-login-form-2"  action="/format/user/login"  onSubmit="return checkForm()" method="post">
					<input type=hidden name="from" id="from" value="<%=from %>"/>
					<div class="col-md-12" style="text-align:center;background-color: rgba(13,13,13,0.25);">
						<a href="javascript:openLogin();">
						    <font size=15px color=#fff>登录</font>
						</a>
					</div>
					<div id=login-1 class="templatemo-one-signin col-md-12">
				        <div class="form-group">
				        <div>
				        <br>
				        <br>
				        <p>身份选择:</p>
				        
				        <input type=radio id="r0" name="duty" checked="checked" value="committer" />
						<span style="color:#FFFFFF">用户</span>
						<input type=radio id="r1" name="duty" value="auditor" />
						<span style="color:#FFFFFF">审核人</span>
						<input type=radio id="r2" name="duty" value="admin" />
						<span style="color:#FFFFFF">管理员</span>
						<input type=radio id="r3" name="duty" value="superAdmin" />
						<span style="color:#FFFFFF">超级管理员</span> 
						
						<div style="height:20px"></div>
				        </div>
				          <div class="col-md-12">		          	
				            <label for="username" class="control-label">账号</label>
				            <div class="templatemo-input-icon-container">
				            	<i class="fa fa-user"></i>
				            	<input type="text" class="form-control" name="id" id="id" >
				            </div>		            		            		            
				          </div>              
				        </div>
				        <div class="form-group">
				          <div class="col-md-12">
				            <label for="password" class="control-label">密码</label>
				            <div class="templatemo-input-icon-container">
				            	<i class="fa fa-lock"></i>
				            	<input type="password" class="form-control" name="password" id="password" >
				            </div>
				          </div>
				        </div>
				        <div class="form-group">
				          <div class="col-md-12">
				            <div class="checkbox">
				                <label>
				                   <span>${message}</span>
				                </label>
				            </div>
				          </div>
				        </div>
				        <div class="form-group">
				          <div class="col-md-12">
				            <input type="submit" id="loginCheck" value="登录" class="btn btn-warning">
				          </div>
				        </div>
				        <div class="form-group">
				          	<div class="col-md-12">
				        		<a href="#" class="text-center">无法登陆?</a>
				       	 	</div>
				    	</div>
					</div>
			</form>			
		</div>				 	   		      
	</div>
	<div style="height:170px"></div>
    <jsp:include page="down.jsp" />
    
</body>

</html>