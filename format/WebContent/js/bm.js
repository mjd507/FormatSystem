window.operateEvents = {
			'click .like' : function(e, value, row) {
				var mymessage = confirm("确定修改吗？");
				if (mymessage == true) {

					$.ajax({
						type : "POST",
						url : "/format/department/changeName",
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
						url : "/format/department/deleteRecord",
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

			if (index % 2 === 0 && index / 2 < classes.length) {
				return {
					classes : classes[index / 2]
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
													url : "/format/department/deleteManyRecords",
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