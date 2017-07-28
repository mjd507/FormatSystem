<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>格文致知—提交者主页</title>


<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>


</head>


<script type="text/javascript">

function showGsjc()
{
	document.getElementById("gsjc").style.display="";
	document.getElementById("scwd").style.display="none";
	document.getElementById("lsjl").style.display="none";
	
}
						
						
function showScwd()
{
	
	document.getElementById("gsjc").style.display="none";
	document.getElementById("scwd").style.display="";
	document.getElementById("lsjl").style.display="none";
	
}

function showLsjl()
{
	
	document.getElementById("gsjc").style.display="none";
	document.getElementById("scwd").style.display="none";
	document.getElementById("lsjl").style.display="";
	
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
								 <a class="panel-title collapsed"  data-parent="#panel-699894" href="javascript:showGsjc();">格式检测</a>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								 <a class="panel-title collapsed"  data-parent="#panel-699894" href="javascript:showScwd();">上传文档</a>
							</div>
						</div>
						
						<div class="panel panel-default">
							<div class="panel-heading">
								 <a class="panel-title collapsed"  data-parent="#panel-699894" href="javascript:showLsjl();">历史记录</a>
							</div>
						</div>
					</div>
  </div>
   

  <div class="col-md-10 column" id="gsjc" style="display:">
  <!-- 格式检测部分开始 -->
  格式检测
  
  
  
  <br>
      <a id="modal-6988" href="#modal-container-6988" role="button" class="btn" data-toggle="modal">上传文档</a>
			
			<div class="modal fade" id="modal-container-6988" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								选择文档
							</h4>
						</div>
						<div class="modal-body">
							
							
							<div class="form-group">
					            <input id="exampleInputFile" type="file" />
					            <p class="help-block">
						             选择doc...文件类型
					            </p>
				            </div>
				
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
							 <button type="button" class="btn btn-primary">确认</button>
						</div>
					</div>
					
				</div>
				
			</div>
 
  <!-- 格式检测部分结束 -->
  </div>
  

  <div class="col-md-10 column" id="scwd" style="display:none">
  <!-- 上传文档部分开始 -->
  上传文档
  
  <!-- 上传文档部分结束 -->
  </div>
 
 
 
 
 
  <div class="col-md-10 column" id="lsjl" style="display:none">
  <!-- 历史记录部分开始 -->
  历史记录
  <!-- 历史记录部分结束 -->
  </div>
	
		

</div>
</div>
<jsp:include page="../down.jsp" />
</body>
</html>