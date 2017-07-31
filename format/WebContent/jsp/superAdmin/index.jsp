<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>格文致知—超级管理主页</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="/format/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/format/assets/bootstrap-table/src/bootstrap-table.css">
<link rel="stylesheet" href="/format/assets/examples.css">
<link rel="stylesheet"
	href="//rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/css/bootstrap-editable.css">

<script src="/format/assets/jquery.min.js"></script>
<script src="/format/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/format/assets/bootstrap-table/src/bootstrap-table.js"></script>
<script
	src="/format/assets/bootstrap-table/src/extensions/editable/bootstrap-table-editable.js"></script>
<script
	src="//rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script src="/format/js/ga.js"></script>

<script
	src="/format/assets/bootstrap-table/src/extensions/reorder-columns/bootstrap-table-reorder-columns.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script
	src="https://rawgit.com/akottr/dragtable/master/jquery.dragtable.js"></script>
</head>


<body style='background: url("<%=request.getContextPath()%>/images/6.jpg") no-repeat;'>
     <jsp:include page="up.jsp" />
     <div class="container" style="min-height: 800px; min-width: 1000px;">
    
		<div id="toolbar">
			<button id="delete" class="btn btn-default">批量删除</button>
			<button id="load" class="btn btn-default">刷新</button>
			<div class="col-md-2 column"style="float:right">
							<a id="modal-createTopic" href="#modal-container-217103"
								role="button" class="btn  btn-success glyphicon glyphicon-plus"
								data-toggle="modal" style="font-size: 15px;float:right">新建组织</a>
			</div>
			<span style="color:red">${message}</span>
			<br>
			<br>
			<br>
			
		</div>

		<table id="table" 
		    data-toggle="table" 
		    data-pagination="true"
			data-show-export="true" 
			data-sort-name="id" 
			data-sort-order="asc"
			data-row-style="rowStyle" 
			data-toolbar="#toolbar" 
			data-height="550"
			data-width="10px" 
			data-click-to-select="true"
			data-url="/format/organization/getList" 
			data-show-columns="true"
			data-search="true" 
			data-show-toggle="true"
			data-reorderable-columns="true">
			<thead>
				<tr>
					<th data-field="state" data-checkbox="true"></th>
					<th data-field="id" data-editable="true" data-sortable="true">编号</th>
					<th data-field="name" data-editable="true" data-sortable="true">名称</th>
					<th data-formatter="operateFormatter" data-events="operateEvents"
						data-sortable="false">操作</th>
				</tr>
			</thead>
		</table>
		
		 <!-- fade遮罩层 --> 
			<div class="modal fade" id="modal-container-217103" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								新建组织
							</h4>
						</div>
						<div class="modal-body">
							 
							 
							 
							 <div class="row clearfix">
											<div class="col-md-12 column">
												<form class="form-horizontal" role="form"
													action="/format/organization/add" method="POST" onsubmit="return checkOrg()"
													enctype="multipart/form-data">
													
												
													<div class="form-group">
														<label for="addName"
															class="col-md-2 control-label">名称</label>
														<div class="col-md-10">
															<input type="text" class="form-control"
																id="addName" name="addName" />
																<p id="addName-hint" style="color:red;"></p>
														</div>
													</div>
													
													<div class="modal-footer">
														<button type="reset" class="btn btn-default"
															data-dismiss="modal">关闭</button>
														<button type="submit" class="btn btn-primary">保存</button>
													</div>

												</form>
											</div>
										</div>
						</div>
						
					</div>
					
				</div>

      </div>    
		
	</div>

	<script>
		//edit
		window.operateEvents = {
			'click .like' : function(e, value, row) {
				var mymessage = confirm("确定修改吗？");
				if (mymessage == true) {

					$.ajax({
						type : "POST",
						url : "/format/organization/changeName",
						data : "data=[" + JSON.stringify(row) + "]",
						dataType : "json",
						success : alert("修改成功")
					});
				}

			},
			'click .remove' : function(e, value, row) {
				var mymessage = confirm("确定删除吗？");
				if (mymessage == true) {

					$.ajax({
						type : "POST",
						url : "/format/organization/deleteRecord",
						data : "data=[" + JSON.stringify(row) + "]",
						dataType : "json",
						success : alert("删除成功")
					});
				}
			}
		};

		function operateFormatter(value, row, index) {
			return [ '<div class="pull-left">',
					'<a class="like" href="javascript:void(0)" title="修改">',
					'<i class="glyphicon glyphicon-pencil"></i>', '</a>  ',
					'<a class="remove" href="javascript:void(0)" title="删除">',
					'<i class="glyphicon glyphicon-remove"></i>', '</a>',
					'</div>' ].join('');
		}

		//style  
		function rowStyle(row, index) {
			var classes = [ 'active', 'success', 'info', 'warning', 'danger' ];

			if (index % 2 === 0 ) {
				return {
					classes : classes[index % 5]
				};
			}
			return {};
		}

		//getSelections
		$(function() {
			$("#delete")
					.click(
							function() {
								//alert('getSelections: ' + JSON.stringify($("#table").bootstrapTable('getSelections')));
								if (JSON.stringify($("#table").bootstrapTable(
										'getSelections')) == "[]")
									alert("请选择");
								else {
									var mymessage = confirm("确定批量删除吗？");
									if (mymessage == true) {

										$
												.ajax({
													type : "POST",
													url : "/format/organization/deleteManyRecords",
													data : "data="
															+ JSON
																	.stringify($(
																			"#table")
																			.bootstrapTable(
																					'getSelections')),
													dataType : "json",
													success : alert("修改成功")
												});
									}
								}
							});
		});

		//refresh
		$(function() {
			$("#load").click(function() {
				$("#table").bootstrapTable('refresh');
			});
		});
		//checkOrg
		function checkOrg()
		{
			
			
			if(document.getElementById("addName").value=="")
			{
			
			alert("名称不能为空");
			return false;
			}
			
			if(document.getElementById("addName").value.length>20)
			{
			
			alert("名称不能超过20字");
			return false;
			}

		    return true;
			
		}	
	</script>
	<jsp:include page="../down.jsp" />
</body>
</html>