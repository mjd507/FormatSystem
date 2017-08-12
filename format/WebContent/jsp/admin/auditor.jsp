<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>格文致知—管理员主页</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/format/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/format/assets/bootstrap-table/src/bootstrap-table.css">
    <link rel="stylesheet" href="/format/assets/examples.css">
    <script src="/format/assets/jquery.min.js"></script>
    <script src="/format/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="/format/assets/bootstrap-table/src/bootstrap-table.js"></script>
    <script src="/format/assets/bootstrap-table/src/extensions/filter-control/bootstrap-table-filter-control.js"></script>
        <script src="/format/assets/bootstrap-table/src/extensions/editable/bootstrap-table-editable.js"></script>
    <script src="/format/js/ga.js"></script>
<!-- 
<script src="//rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/js/bootstrap-editable.js"></script>
   <link rel="stylesheet"href="//rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/css/bootstrap-editable.css">
    
 -->

</head>
<body style='background: url("<%=request.getContextPath()%>/images/6.jpg") no-repeat;'>
     <jsp:include page="up.jsp" />
     <div class="container" style="min-height: 800px; min-width: 1000px;">
  		<div id="toolbar">
			<button id="delete" class="btn btn-default">批量删除</button>
			<button id="load" class="btn btn-default">刷新</button>
			
			<a href="/format/jsp/admin/committer.jsp">提交者</a>
		    <a href="/format/jsp/admin/auditor.jsp">审核者</a>
		
			<span style="color:red">${message}</span>
			<br>
			<br>
			<br>
			
		</div>
		
		
		<div class="col-md-2 column"style="float:right">
							<a id="modal-createTopic" href="#modal-container-217103"
								role="button" class="btn  btn-success glyphicon glyphicon-plus"
								data-toggle="modal" style="font-size: 15px;float:right">新建审核人</a>
		</div>
		<br>
		<br>
<!-- table -->		
        <table id="table"
           data-toggle="table"
           data-url="/format/auditor/getList?userName=<%=session.getAttribute("userName")%>&userId=<%=session.getAttribute("userId")%>"  
           data-filter-control="true"
           data-filter-show-clear="true"
           data-pagination="true"
           data-show-export="true"
           data-search="true"
           data-row-style="rowStyle"
            data-detail-view="true"
            data-detail-formatter="detailFormatter" >
        <thead>
        <tr>
           <th data-field="state" data-checkbox="true"></th>
			<th data-field="id" data-editable="false" data-sortable="true" >账号名</th>
			<th data-field="name" data-editable="false" data-sortable="true" >姓名</th>
			<th data-field="telephone" data-editable="false" data-sortable="true">联系方式</th>
			<th data-field="email" data-editable="false" data-sortable="true" >邮箱</th>
            <th data-field="dName" data-filter-control="select">学院</th>
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
								新建审核人
							</h4>
							
						</div>
						<div class="modal-body">
							 <div class="row clearfix">
											<div class="col-md-12 column">
												<form class="form-horizontal" role="form"
													action="/format/auditor/add" method="POST" onsubmit="return checkAdmin()"
													enctype="multipart/form-data">
													
													<div class="form-group">
														<label for="addId" class="col-md-2 control-label">分配组织</label>
														<div class="col-md-10">
														 <c:if test="${depList!=null}">
															<select style="width:150px" class="form-control" id="adddName" name="adddName">
				            	                              <c:forEach var="depList" items="${sessionScope.depList}">
				            	                              
				            		                          <option value="${depList.name}">${depList.name}</option>
				            		                          </c:forEach>   	
			                                               </select>
			                                               </c:if>
			                                               <c:if test="${depList==null}">
			                                               服务器暂无数据，无法新建
			                                               </c:if>
														</div>
													</div>
													<div class="form-group">
														<label for="addId" class="col-md-2 control-label">账号</label>
														<div class="col-md-10">
															<input type="text" class="form-control" id="addId"
																name="addId" />
																<p id="addId-hint" style="color:red;"></p>
														</div>
													</div>
													<div class="form-group">
														<label for="addName"
															class="col-md-2 control-label">姓名</label>
														<div class="col-md-10">
															<input type="text" class="form-control"
																id="addName" name="addName" />
																<p id="addName-hint" style="color:red;"></p>
																<p class="help-block">初始密码与账号相同</p>
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
						url : "/format/auditor/update",
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
						url : "/format/auditor/deleteRecord",
						data : "data=[" + JSON.stringify(row) + "]",
						dataType : "json",
						success : alert("删除成功")
					});
				}
			},
			
			
			
			'click .add' : function(e, value,row) {
				var mymessage = confirm("确定添加吗？");
				//if(key=='oName')
				alert(JSON.stringify(row));
					//html.push('<input type="submit" name="org" value="'+value+'>)');
				return html.join('');
			}
		};

		function operateFormatter(value, row, index) {
			return [ '<div class="pull-left">',
					'<a class="like" href="javascript:void(0)" title="修改">',
					'<i class="glyphicon glyphicon-pencil"></i>', '</a>  ',
					'<a class="remove" href="javascript:void(0)" title="删除">',
					'<i class="glyphicon glyphicon-remove"></i>', '</a>' ].join('');
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
													url : "/format/auditor/deleteManyRecords",
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
		
		
		
		
		//expland
		function detailFormatter(index, row) {
	        var html = [];
	        $.each(row, function (key, value) {
	            html.push('<p><b>' + key + ':</b> ' + value + '</p>');
	        });
	        return html.join('');
	    }
		
		//check admin-Fade input
		function checkAdmin()
		{
			
			if(document.getElementById("orgName").value=="")
				{
				
				alert("请选择组织");
				return false;
				}
			if(document.getElementById("addId").value=="")
			{
			
			alert("账号内容不能为空");
			return false;
			}
			if(document.getElementById("addName").value=="")
			{
			
			alert("姓名不能为空");
			return false;
			}
			
			if(document.getElementById("addId").value.length>20)
			{
			
			alert("账号不能超过20字");
			return false;
			}
			if(document.getElementById("addName").value.length>20)
			{
			
			alert("姓名不能超过20字");
			return false;
			}

		    return true;
			
		}
	</script>
	<jsp:include page="../down.jsp" />
</body>
</html>