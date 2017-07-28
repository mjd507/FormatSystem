<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>格文致知—超级管理主页</title>


<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>


</head>


<script type="text/javascript">

function showZz()
{
	document.getElementById("zz").style.display="";
	document.getElementById("bm").style.display="none";
	document.getElementById("gly").style.display="none";
}
						
						
function showBm()
{
	document.getElementById("zz").style.display="none";
	document.getElementById("bm").style.display="";
	document.getElementById("gly").style.display="none";
	
}

function showGly()
{
	
	document.getElementById("zz").style.display="none";
	document.getElementById("bm").style.display="none";
	document.getElementById("gly").style.display="";
	
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
								 <a class="panel-title collapsed"  data-parent="#panel-699894" href="javascript:showZz();">组织</a>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								 <a class="panel-title collapsed"  data-parent="#panel-699894" href="javascript:showBm();">部门</a>
							</div>
						</div>
						
						<div class="panel panel-default">
							<div class="panel-heading">
								 <a class="panel-title collapsed"  data-parent="#panel-699894" href="javascript:showGly();">管理员</a>
							</div>
						</div>
						
						
					</div>
  </div>
   

  <div class="col-md-10 column" id="zz" style="display:">
  <!-- 组织开始 -->
  组织
  <!-- 组织结束 -->
  </div>
  

  <div class="col-md-10 column" id="bm" style="display:none">
  <!-- 部门开始 -->
  部门 
  <!-- 部门结束 -->
  </div>
 
 
  <div class="col-md-10 column" id="gly" style="display:none">
  <!-- 管理员开始 -->
  管理员  
  <!-- 管理员结束 -->
  </div>
  
	
		

</div>
</div>
<jsp:include page="../down.jsp" />
</body>
</html>