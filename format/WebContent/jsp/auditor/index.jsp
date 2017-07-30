d<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="com.zhuozhengsoft.pageoffice.*"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>格文致知—审核主页</title>


<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"
	type="text/javascript"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"
	type="text/javascript"></script>

<!-- PageOffice.js文件和jquery.min.js引用 -->
<script type="text/javascript" src="../jquery.min.js"></script>
<script type="text/javascript" src="../pageoffice.js" id="po_js_main"></script>
</head>
<head></head>


<script type="text/javascript">
	function showScmb() {
		document.getElementById("scmb").style.display = "";
		document.getElementById("wdmb").style.display = "none";
		document.getElementById("shwd").style.display = "none";
		document.getElementById("wdsh").style.display = "none";
	}

	function showWdmb() {

		document.getElementById("scmb").style.display = "none";
		document.getElementById("wdmb").style.display = "";
		document.getElementById("shwd").style.display = "none";
		document.getElementById("wdsh").style.display = "none";

	}

	function showShwd() {

		document.getElementById("scmb").style.display = "none";
		document.getElementById("wdmb").style.display = "none";
		document.getElementById("shwd").style.display = "";
		document.getElementById("wdsh").style.display = "none";
	}

	function showWdsh() {
		document.getElementById("scmb").style.display = "none";
		document.getElementById("wdmb").style.display = "none";
		document.getElementById("shwd").style.display = "none";
		document.getElementById("wdsh").style.display = "";
	}

	function Save() {
		document.getElementById("PageOfficeCtrl1").WebSave();
	}
	function AfterDocumentOpened() {

		$("#btn1").removeAttr("disabled");
	}

	function OpenDocument(strUrl) {
		//使打开按钮变灰
		$('#btn1').attr('disabled', 'true');
		//使用post请求打开文档的action
		$.post(strUrl, {
			param2 : "456"
		}, function(data) {
			$("#divDocView").html(data);
		});
	}
</script>

<body
	style='background: url("<%=request.getContextPath()%>/images/6.jpg") no-repeat;'>
	<jsp:include page="up.jsp" />

	<div class="container" style="min-height: 900px;">
		<br> <br>
		<div class="row clearfix">

			<div class="col-md-2 column">
				<div class="panel-group" id="panel-699894">
					<div class="panel panel-default">
						<div class="panel-heading">
							<a class="panel-title collapsed" data-parent="#panel-699894"
								href="javascript:showScmb();">上传模板</a>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading">
							<a class="panel-title collapsed" data-parent="#panel-699894"
								href="javascript:showWdmb();">我的模板</a>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading">
							<a class="panel-title collapsed" data-parent="#panel-699894"
								href="javascript:showShwd();">审核文档</a>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading">
							<a class="panel-title collapsed" data-parent="#panel-699894"
								href="javascript:showWdsh();">我的审核</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-10 column" id="scmb" style="display:">
				<!-- 上传模板部分开始 -->
				
				
				
				<form class="navbar-form navbar-left" role="search" action="/format/file/uploadStandard">
				
				        
				        <div class="form-group">
					    <label for="exampleInputFile">选择文件</label>
					    <input  name="aid"  id="aid" type="hidden" value="1"/>
					    <input type="file" class="form-control" id="document"
						   name="document" style="border: none" />
					    <p class="help-block">
						支持.doc/.docx 格式的文件
					    </p>
				        </div>
				
				        <br>   
						<div class="form-group">
						<label for="title">模板名称</label>
							<input class="form-control" name="title" id="title" type="text" />
						</div> 
						
						<br>
						<input type="submit" class="btn btn-default"/>创建模板
						
				</form>
				
				
				<!-- 上传模板部分结束 -->
			</div>


			<div class="col-md-10 column" id="wdmb" style="display: none">
				<!-- 我的模板部分开始 -->
				我的模板
				<!-- 我的模板部分结束 -->
			</div>


			<div class="col-md-10 column" id="shwd" style="display: none">
				<!-- 审核文档部分开始 -->
				审核文档
				<!-- 审核文档部分结束 -->
			</div>

			<div class="col-md-10 column" id="wdsh" style="display: none">
				<!-- 我的审核部分开始 -->
				我的审核
				<!-- 我的审核部分结束 -->
			</div>



		</div>
	</div>
	<jsp:include page="../down.jsp" />
</body>
</html>