<%@ page language="java" contentType="text/html;charset=UTF-8"
	import="java.util.*,com.zufe.mychat.bean.Friends" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>群组列表</title>
<%
	pageContext.setAttribute("ICHAT_PATH",request.getContextPath());
%>
<link rel="shortcut icon" href="static/Image/favicon.ico" type="image/x-icon" />
<!-- 引入jquery -->
<script type="text/javascript"
	src="${ICHAT_PATH}/static/js/jquery-1.12.4.min.js"></script>
<!-- Bootstrap -->
<link
	href="${ICHAT_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${ICHAT_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	
		<script src="${ICHAT_PATH}/static/js/three.min.js" type="text/javascript"></script>
	<link href="static/css/wall.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- 搭建显示页面 -->
	<div class="container wall-body">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-9">
				<h2>群组列表</h2>
			</div>

		</div>





		<!-- 显示表格数据 -->
		<div class="row">
			<div class=col-md-12>
				<table class="table table-hover" id="qzxx_tables">
					<thead>
						<tr>

							<th>群组名</th>
							<th>群组id</th>
							<th>群组创建人</th>
							<th>群组人数</th>

						</tr>
					</thead>
					<tbody>
					</tbody>

				</table>
			</div>
		</div>

		<!-- 分页 -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div class="col-md-6" id="page_info"></div>

			<!-- 分页条 -->
			<div class="col-md-6" id="page_nav"></div>
		</div>
	</div>
<script src="static/js/wallbgcanvas.js" type="text/javascript"></script>

	<!-- 	添加好友模态框 -->

	<div class="modal fade" id="joinQzModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">加入群组</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">加入群组邀请信息</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="message"
									id="message_add" placeholder="输入您想发送的加入邀请信息"> <span
									id="helpBlock2" class="help-block"></span>

							</div>
						</div>


					</form>
				</div>
				<div class="modal-footer">
					<button type="button" type="button" class="btn btn-default"
						data-dismiss="modal">取消</button>
					<button type="button" type="button" class="btn btn-primary"
						id="qz_join_btn" ajax_val="">发送</button>
				</div>
			</div>
		</div>
	</div>


	<script>
	
	//页面加载完成以后，直接去发送ajax请求，接收到分页数据
		
	var curPage=1;
		function to_page(pn) {
			$.ajax({
				url:"${ICHAT_PATH}/queryQzxxWithJson",
				data:"pn="+pn+"&qzid="+'${keyword}',
				type:"GET",
				success:function(result){
					if(result.extend.pageInfo.pageNum==curPage)
						{
					
					build_users_table(result);
			
					build_page_info(result);
				
					build_page_nav(result);
						}
			  
				}
			});
		}
	
		$(function(){
			to_page(1);
		});	
		
		function build_users_table(result){
			$("#qzxx_tables tbody").empty();
			var qzxxList = result.extend.pageInfo.list;
			$.each(qzxxList,function(index,item){
				
			
				
				
				
				var user1 = $("<td></td>").append(item.qzid); 
				var user2 = $("<td></td>").append(item.qzname); 
				var user3=$("<td></td>").append(item.qzcreater);
				var user4 = $("<td></td>").append(item.qzcount.count);
			
				
				var editBtn = $("<button></button>").addClass("btn btn-primary btn-xs edit_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("加入群组").attr("ajax-val",item.qzid);
				//自定义属性
				editBtn.attr("edit_id",item.usersId);
				var delBtn = $("<button></button>").addClass("btn btn-danger btn-xs del_btn")
				.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("加入黑名单");
				//自定义属性
				delBtn.attr("del_id",item.usersId);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
				
				
				
					  
						  
						  		
	                             		  	
						  
					  
				
					  
				$("<tr></tr>").append(user1)
					.append(user2)
					.append(user3)
					.append(user4)
					.append(btnTd)
					.appendTo("#qzxx_tables tbody");
					  
							
							 
							 
							 
						
						
						
			        
					
					
					
				
			
			});
		}
		
		//解析显示分页信息
		function build_page_info(result){
			$("#page_info").empty();
			$("#page_info").append("第"+result.extend.pageInfo.pageNum+"页,共"
					+result.extend.pageInfo.pages+"页,共  "
					+result.extend.pageInfo.total+"条记录");
			totalRecord = result.extend.pageInfo.total;
			currentPage = result.extend.pageInfo.pageNum;
		}
		//解析显示分页条
		function build_page_nav(result){
			$("#page_nav").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
			if(result.extend.pageInfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else {
				//首页
				firstPageLi.click(function(){
					curPage=1;
					to_page(curPage);
				});
				//前一页
				prePageLi.click(function(){
					curPage=result.extend.pageInfo.pageNum - 1;
					to_page(curPage);
				});
			}
			
			
			var nextPageLi = $("<li></li>").append($("<a href='#'></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append($("<a href='#'></a>").append("尾页"));
			
			if(result.extend.pageInfo.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else {
				//后一页
				nextPageLi.click(function(){
					curPage=result.extend.pageInfo.pageNum + 1;
					to_page(curPage);
				});
				//尾页
				lastPageLi.click(function(){
					curPage=result.extend.pageInfo.pages;
					to_page(curPage);
				});
			}
			
			
			
			ul.append(firstPageLi).append(prePageLi);
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				var numLi = $("<li></li>").append($("<a href='#'></a>").append(item));
				if(result.extend.pageInfo.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function(){
					curPage=item;
					to_page(curPage);
				});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav");
		}
		
		
		
		
		function reset_form(ele) {
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-success has-error");
			$(ele).find(".help-block").text("");
		}
		
			
			

			
			
			//添加好友-绑定事件
			$(document).on("click",".edit_btn",function() {
				
				
			var	qzid=$(this).attr("ajax-val");
				
				$("#qz_join_btn").attr("ajax_val",qzid);
				
				//清除表格、样式数据 
				reset_form("#joinQzModal form");
				
				
				
				//弹出模态框
				$('#joinQzModal').modal({
					backdrop:"static",
				keyboard:true
					
				});
			     
			
				
				
			});
			$("#qz_join_btn").click(function(){
				$.ajax({
					url:"${ICHAT_PATH}/SendQzInvites",
					data:"&message="+$("#message_add").val()+"&qzid="+$("#qz_join_btn").attr("ajax_val"),
					type:"POST",
					success:function(result){
						if(result.code == 100) {
							//保存成功，关闭模态框
							$("#joinQzModal").modal('hide');
						
						}else {
							alert("发送失败!");
						}
							
						}
				});
				
				
				
				
			});
			var timer=self.setInterval("to_page(curPage)",2000);
			document.onkeydown = function () {
		        if (window.event && window.event.keyCode == 13) {
		            window.event.returnValue = false;
		        }
		    }
	</script>
</body>
</html>