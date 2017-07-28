<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>格文致知—管理主页</title>


<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>


</head>


<script type="text/javascript">

function showBmgl()
{
	document.getElementById("bmgl").style.display="";
	document.getElementById("cygl").style.display="none";
	document.getElementById("shqk").style.display="none";
	document.getElementById("sjtj").style.display="none";
}
						
						
function showCygl()
{
	
	document.getElementById("bmgl").style.display="none";
	document.getElementById("cygl").style.display="";
	document.getElementById("shqk").style.display="none";
	document.getElementById("sjtj").style.display="none";
	
}

function showShqk()
{
	
	document.getElementById("bmgl").style.display="none";
	document.getElementById("cygl").style.display="none";
	document.getElementById("shqk").style.display="";
	document.getElementById("sjtj").style.display="none";
	
}

function showSjtj()
{
	
	document.getElementById("bmgl").style.display="none";
	document.getElementById("cygl").style.display="none";
	document.getElementById("shqk").style.display="none";
	document.getElementById("sjtj").style.display="";
	
}

</script>

<body style="background:url('<%=request.getContextPath()%>/images/6.jpg') no-repeat;">
<jsp:include page="up.jsp"/>

<div class="container" style="min-height:600px;">
<br>
<br>
<div class="row clearfix">

  <div class="col-md-2 column">
					<div class="panel-group" id="panel-699894">
						<div class="panel panel-default">
							<div class="panel-heading">
								 <a class="panel-title collapsed"  data-parent="#panel-699894" href="javascript:showBmgl();">部门管理</a>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								 <a class="panel-title collapsed"  data-parent="#panel-699894" href="javascript:showCygl();">成员管理</a>
							</div>
						</div>
						
						<div class="panel panel-default">
							<div class="panel-heading">
								 <a class="panel-title collapsed"  data-parent="#panel-699894" href="javascript:showShqk();">审核情况</a>
							</div>
						</div>
						
						<div class="panel panel-default">
							<div class="panel-heading">
								 <a class="panel-title collapsed"  data-parent="#panel-699894" href="javascript:showSjtj();">数据统计</a>
							</div>
						</div>
					</div>
  </div>
   

  <div class="col-md-10 column" id="bmgl" style="display:">
  <!-- 部门管理部分开始 -->
  部门管理
  <!-- 部门管理部分结束 -->
  </div>
  

  <div class="col-md-10 column" id="cygl" style="display:none">
  <!-- 成员管理部分开始 -->
  成员管理 
  <!-- 成员管理部分结束 -->
  </div>
 
 
  <div class="col-md-10 column" id="shqk" style="display:none">
  <!-- 审核情况部分开始 -->
  审核情况  
  <!-- 审核情况部分结束 -->
  </div>
  
  <div class="col-md-10 column" id="sjtj" style="display:none">
  <!-- 数据统计部分开始 -->
  数据统计  
  <!-- 数据统计部分结束 -->
  </div>
	
		

</div>
</div>
<jsp:include page="../down.jsp" />
</body>
</html>