<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>好友列表</title>
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
	
	<link href="static/css/wall.css" rel="stylesheet" type="text/css">
<script
	src="${ICHAT_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<script src="${ICHAT_PATH}/static/js/three.min.js" type="text/javascript"></script>

<body >
	

	<div class="container wall-body" >

		<!-- 标题 -->
		<div class="row">
			<div class="col-md-9">
				<h2>好友列表</h2>
			</div>
			<div class="col-md-3">
				<h3>您好！${username}</h3>
				<h4>
					&nbsp&nbsp&nbsp&nbsp在线状态：
					<c:if test="${status==1}">在线</c:if>
					<c:if test="${status!=1}">离线</c:if>
				</h4>

			</div>
		</div>
		<div class="row">

			<c:if test="${status!=null}">
				<div class="col-md-1 col-md-offset-10">
					<form action="${ICHAT_PATH}/loginOut">
						<button type="submit" class="btn btn-primary btn-sm">注销</button>
					</form>
				</div>
			</c:if>
			<c:if test="${status==1}">
				<div class="col-md-1">
					<form action="${ICHAT_PATH}/outLine">
						<input type="hidden" value="${username}" name="username">
						<button type="submit" class="btn btn-primary btn-sm">隐身</button>
					</form>
				</div>
			</c:if>
			<c:if test="${status==0}">
				<div class="col-md-1">
					<form action="${ICHAT_PATH}/onLine">
						<input type="hidden" value="${username}" name="username">
						<button type="submit" class="btn btn-primary btn-sm">取消隐身</button>
					</form>
				</div>
			</c:if>




		</div>

		<!-- 按钮 -->
		<div class="row">

			<div class="col-md-4 col-md-offset-6">
				<button type="button" class="btn btn-primary btn-sm"
					id="friends_add_modal_btn">添加好友</button>
				<button type="button" class="btn btn-danger btn-sm"
					id="qz_create_modal_btn">建立群组</button>
				<button type="button" class="btn btn-danger btn-sm"
					id="qz_join_modal_btn">加入群组</button>
			</div>
		</div>
		<div class='row'>
			<div class="col-md-1 col-md-offset-11">
				<button type="button" id="msg_btn" class="btn btn-default"
					aria-label="Right Align">
					<font color="red"></font> <span
						class="glyphicon glyphicon-align-right" aria-hidden="true"></span>
				</button>
			</div>
		</div>

		<div class='row'>
			<div class="col-md-1 col-md-offset-11">
				<button type="button" id="qz_msg_btn" class="btn btn-default"
					aria-label="Right Align">
					<font color="red"></font> <span
						class="glyphicon glyphicon-align-right" aria-hidden="true"></span>
				</button>
			</div>
		</div>
		<!-- 显示好友表格数据 -->
		<div class="row">
			<div class=col-md-12>
				<table class="table table-hover" id="friends_tables">
					<thead>
						<tr>

							<th>用户名</th>
							<th>在线状态</th>

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

		<p></p>

		<!-- 显示群组表格数据 -->
		<div class="row">
			<div class=col-md-12>
				<table class="table table-hover" id="qz_tables">
					<thead>
						<tr>

							<th>群组ID</th>
							<th>群组名称</th>



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
			<div class="col-md-6" id="qz_page_info"></div>

			<!-- 分页条 -->
			<div class="col-md-6" id="qz_page_nav"></div>
		</div>

	</div>

<script src="static/js/wallbgcanvas.js" type="text/javascript"></script>

	<!-- 	添加好友模态框 -->
	<div class="modal fade" id="friendsAddModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">添加朋友</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" action="${ICHAT_PATH}/queryUsers">

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">用户名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="username"
									id="username_add" placeholder="输入用户名查找用户"> <span
									id="helpBlock2" class="help-block"></span>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
								<button type="submit" class="btn btn-primary"
									id="friends_add_btn">查找</button>
							</div>
						</div>



					</form>
				</div>

			</div>
		</div>
	</div>

	<!-- 	加入群组模态框 -->
	<div class="modal fade" id="qzJoinModal" tabindex="-1" role="dialog"
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
					<form class="form-horizontal" action="${ICHAT_PATH}/QueryQz">

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">群组id</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="qzid"
									id="qzid_join_add" placeholder="输入群组id查找群组"> <span
									id="helpBlock2" class="help-block"></span>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
								<button type="submit" class="btn btn-primary"
									id="qzjoin_add_btn">查找</button>
							</div>
						</div>



					</form>
				</div>

			</div>
		</div>
	</div>

	<div class="modal fade" id="qzxxAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">建立群组</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="inputEmail2" class="col-sm-2 control-label">群组ID</label>

							<div class="col-sm-10">
								<input type="text" class="form-control" name="qzid"
									id="qzid_add" placeholder="群组id"> <span id="helpBlock2"
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">群组名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="qzname"
									id="qzname_add" placeholder="群组名称"> <span
									id="helpBlock2" class="help-block"></span>
							</div>
						</div>



					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="modal_qzxx_btn">建立</button>
				</div>
			</div>
		</div>
	</div>


	<!-- 	好友邀请模态框 -->
	<div class="modal fade" id="invitesModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">添加朋友邀请</h4>
				</div>
				<div class="modal-body">
					<!-- 显示表格数据 -->
					<div class="row">
						<div class=col-md-12>
							<table class="table table-hover" id="invites_tables">
								<thead>
									<tr>

										<th>用户名</th>
										<th>邀请信息</th>

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
						<div class="col-md-6" id="invites_page_info"></div>

						<!-- 分页条 -->
						<div class="col-md-6" id="invites_page_nav"></div>
					</div>
				</div>

			</div>
		</div>
	</div>




	<!-- 	群组邀请模态框 -->
	<div class="modal fade" id="qzinvitesModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">加入群组邀请</h4>
				</div>
				<div class="modal-body">
					<!-- 显示表格数据 -->
					<div class="row">
						<div class=col-md-12>
							<table class="table table-hover" id="qz_invites_tables">
								<thead>
									<tr>

										<th>用户名</th>
										<th>邀请信息</th>
										<th>申请加入的群组id</th>
										<th>申请加入的群组名</th>
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
						<div class="col-md-6" id="qz_invites_page_info"></div>

						<!-- 分页条 -->
						<div class="col-md-6" id="qz_invites_page_nav"></div>
					</div>
				</div>

			</div>
		</div>
	</div>

	
	
	<script>
	
	//页面加载完成以后，直接去发送ajax请求，接收到分页数据
		
	var curPage=1;
	var curInvitesPage=1;
	var curQzInvitesPage=1;
	var curQzPage=1;
		function to_page(pn) {
			
		
			$.ajax({
				url:"${ICHAT_PATH}/QueryFriendsWithStatus",
				data:"pn="+pn+"&username="+'<%=(String)(request.getSession().getAttribute("username"))%>',
				type:"GET",
				success:function(result){
					
					if(result.extend.pageInfo.list.length==0){
						$("#friends_tables tbody").empty();
						$("#page_info").empty();
						$("#page_nav").empty();
						
						return;}
					if(result.extend.pageInfo.pageNum==curPage){
					//console.log(result);
					//1.解析并显示员工数据
					build_friends_table(result,"#friends_tables tbody");
					//2.解析并显示分页信息
					build_page_info(result,"#page_info");
					//3.解析显示分页条
					build_page_nav(result,"#page_nav");
					}
			  
				}
			});
			
		}
	
		
		
		function qz_to_page(pn) {
			
			
			$.ajax({
				url:"${ICHAT_PATH}/QueryQzxxWithCn",
				data:"pn="+pn,
				type:"POST",
				success:function(result){
				
					if(result.extend.pageInfo.pageNum==curQzPage){
					//console.log(result);
					//1.解析并显示员工数据
					build_friends_table(result,"#qz_tables tbody");
					//2.解析并显示分页信息
					build_page_info(result,"#qz_page_info");
					//3.解析显示分页条
					build_page_nav(result,"#qz_page_nav");
					}
			  
				}
			});
			
		}
		
	
		
		$(function(){
			to_page(1);
			
		});	
		
		function build_friends_table(result,ele){
			$(ele).empty();
			var friends = result.extend.pageInfo.list;
		
		
			$.each(friends,function(index,item){
				
				var user1;
				var user2;
				var user;
				var user3;
				var user4;
				if(item.users!=undefined)
				{
					var statusString;
				if(item.users.satus==1)statusString='在线';
				else statusString='离线';
			 user=('${username}'==item.user1?item.user2:item.user1);
				 user1 = $("<td></td>").append(user); 
				 user2 = $("<td></td>").append(statusString); }
			  if(item.message!=undefined&&item.qzxx==undefined)
					{
					
					 user1=$("<td></td>").append(item.sender);
					 user2= $("<td></td>").append(item.message);
					
					
					}
				if(item.qzxx!=undefined)
					{
					user1=$("<td></td>").append(item.sender);
					 user2= $("<td></td>").append(item.message);
					 user3=$("<td></td>").append(item.qzxx.qzid);
						 user4=$("<td></td>").append(item.qzxx.qzname);
					
					
					}
				
				if(item.chat_notification!=undefined&&item.users==undefined)
					{
					user1=$("<td></td>").append(item.qzid);
					 user2= $("<td></td>").append(item.qzname);
					
					
					
					}
				
				
				
				var chatBtn ;
				var delBtn;
				if(item.users!=undefined)
					{
				chatBtn= $("<button></button>").addClass("btn btn-primary btn-xs chat_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append(item.chat_notification.count);
				//自定义属性
				chatBtn.attr("chat_name",user);
				
				delBtn = $("<button></button>").addClass("btn btn-danger btn-xs del_btn")
				.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除好友");
				//自定义属性
				delBtn.attr("del_name",user);
					}
				
			
					if(item.message!=undefined&&item.qzxx==undefined)
						{
						
						chatBtn= $("<button></button>").addClass("btn btn-primary btn-xs agree_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("同意邀请").attr("ajax-val",item.sender);
				
					
					delBtn = $("<button></button>").addClass("btn btn-danger btn-xs refuse_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("拒绝邀请").attr("ajax-val",item.sender);
					
						
						}
					
					if(item.qzxx!=undefined)
						{
						
						chatBtn= $("<button></button>").addClass("btn btn-primary btn-xs qz_agree_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("同意邀请").attr("ajax-val",item.sender).attr("ajax-val1",item.qzid);
				
					
					delBtn = $("<button></button>").addClass("btn btn-danger btn-xs qz_refuse_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("拒绝邀请").attr("ajax-val",item.sender).attr("ajax-val1",item.qzid);
						
						}
					
					if(item.chat_notification!=undefined&&item.users==undefined)
						
						{
							chatBtn= $("<button></button>").addClass("btn btn-primary btn-xs qz_chat_btn")
								.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append(item.chat_notification.count);
							//自定义属性
							chatBtn.attr("chat_qzid",item.qzid);
							
							delBtn = $("<button></button>").addClass("btn btn-danger btn-xs qz_del_btn")
							.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("退出群组");
							//自定义属性
							delBtn.attr("del_qzid",item.qzid);
						
					}
				
				var btnTd = $("<td></td>").append(chatBtn).append(" ").append(delBtn);
				if(item.qzxx==undefined){
				$("<tr></tr>").append(user1)
					.append(user2)
					.append(btnTd)
					.appendTo(ele);}
				
				
				if(item.qzxx!=undefined){
					
					$("<tr></tr>").append(user1)
					.append(user2)
					.append(user3)
					.append(user4)
					.append(btnTd)
					.appendTo(ele);
					
					
					
				}
				
			});
		}
		
		//解析显示分页信息
		function build_page_info(result,ele){
			$(ele).empty();
			$(ele).append("第"+result.extend.pageInfo.pageNum+"页,共"
					+result.extend.pageInfo.pages+"页,共  "
					+result.extend.pageInfo.total+"条记录");
			totalRecord = result.extend.pageInfo.total;
			currentPage = result.extend.pageInfo.pageNum;
		}
		//解析显示分页条
		function build_page_nav(result,ele){
			$(ele).empty();
			var ul = $("<ul></ul>").addClass("pagination");
			
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
			if(result.extend.pageInfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else {
				//首页
				if(result.extend.pageInfo.list[0].users!=undefined)
				firstPageLi.click(function(){
					
					curPage=1;
					to_page(curPage);
					
				});
				
				if(result.extend.pageInfo.list[0].chat_notification!=undefined&&result.extend.pageInfo.list[0].users==undefined)
					firstPageLi.click(function(){
						
						curQzPage=1;
						qz_to_page(curQzPage);
						
					});
				if(result.extend.pageInfo.list[0].message!=undefined&&result.extend.pageInfo.list[0].qzxx==undefined)
					firstPageLi.click(function(){
				curInvitesPage=1;
			    });
				if(result.extend.pageInfo.list[0].qzxx!=undefined)
					{
					curQzInvitesPage=1;
					
					
					}
				//前一页
				if(result.extend.pageInfo.list[0].users!=undefined)
				prePageLi.click(function(){
					
						curPage=result.extend.pageInfo.pageNum - 1;
					     to_page(curPage);
						
					
				});
				
				if(result.extend.pageInfo.list[0].chat_notification!=undefined&&result.extend.pageInfo.list[0].users==undefined)
					prePageLi.click(function(){
						
						curQzPage=result.extend.pageInfo.pageNum - 1;
					     qz_to_page(curQzPage);
						
					
				});
				
				if(result.extend.pageInfo.list[0].message!=undefined&&result.extend.pageInfo.list[0].qzxx==undefined)
					prePageLi.click(function(){
						
				curInvitesPage=result.extend.pageInfo.pageNum - 1;
			});
				
				if(result.extend.pageInfo.list[0].qzxx!=undefined)
					prePageLi.click(function(){
						
						curQzInvitesPage=result.extend.pageInfo.pageNum - 1;
					});
				
			}
			
			
			var nextPageLi = $("<li></li>").append($("<a href='#'></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append($("<a href='#'></a>").append("尾页"));
			
			if(result.extend.pageInfo.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else {
				//后一页
				if(result.extend.pageInfo.list[0].users!=undefined)
				nextPageLi.click(function(){
					
					
						curPage=result.extend.pageInfo.pageNum + 1;
					to_Page(curPage);
					
				});
				
				if(result.extend.pageInfo.list[0].chat_notification!=undefined&&result.extend.pageInfo.list[0].users==undefined)
					nextPageLi.click(function(){
						
						
						curQzPage=result.extend.pageInfo.pageNum + 1;
					qz_to_Page(curQzPage);
					
				});
					
				if(result.extend.pageInfo.list[0].message!=undefined&&result.extend.pageInfo.list[0].qzxx==undefined)
					nextPageLi.click(function(){
						
						curInvitesPage=result.extend.pageInfo.pageNum + 1;
					
				});
				if(result.extend.pageInfo.list[0].qzxx!=undefined)
	            nextPageLi.click(function(){
						
						curQzInvitesPage=result.extend.pageInfo.pageNum + 1;
					
				});
		     
				//尾页
				if(result.extend.pageInfo.list[0].users!=undefined)
				lastPageLi.click(function(){
					
						curPage=result.extend.pageInfo.pages;
					     to_page(curPage);
						
					});
				if(result.extend.pageInfo.list[0].chat_notification!=undefined&&result.extend.pageInfo.list[0].users==undefined)
					lastPageLi.click(function(){
						
						curQzPage=result.extend.pageInfo.pages;
					     qz_to_page(curQzPage);
						
					});
					
				if(result.extend.pageInfo.list[0].message!=undefined&&result.extend.pageInfo.list[0].qzxx==undefined)
				
					
lastPageLi.click(function(){curInvitesPage=result.extend.pageInfo.pages;
					
					
				});
				
				
				if(result.extend.pageInfo.list[0].qzxx!=undefined)
					lastPageLi.click(function(){curQzInvitesPage=result.extend.pageInfo.pages;
					
					
					});
			}
			
			
			
			ul.append(firstPageLi).append(prePageLi);
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				var numLi = $("<li></li>").append($("<a href='#'></a>").append(item));
				if(result.extend.pageInfo.pageNum == item) {
					numLi.addClass("active");
				}
				if(result.extend.pageInfo.list[0].users!=undefined)
				numLi.click(function(){
					
						
						curPage=item;
						to_page(curPage);});
				
				if(result.extend.pageInfo.list[0].chat_notification!=undefined&&result.extend.pageInfo.list[0].users==undefined)
		        numLi.click(function(){
					
						
						curQzPage=item;
						qz_to_page(curQzPage);});
				
				
					if(result.extend.pageInfo.list[0].message!=undefined&&result.extend.pageInfo.list[0].qzxx==undefined)
						numLi.click(function(){		
					curInvitesPage=item;
				
				
				});
					
					if(result.extend.pageInfo.list[0].qzxx!=undefined)
						numLi.click(function(){		
							curQzInvitesPage=item;
						
						
						});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo(ele);
		}
		
		
		
		
		function reset_form(ele) {
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-success has-error");
			$(ele).find(".help-block").text("");
		}
		
			
			
			$("#friends_add_modal_btn").click(function(){
				
				//清除表格、样式数据 
				reset_form("#friendsAddModal form");
				
				
				
				//弹出模态框
				$('#friendsAddModal').modal({
					backdrop:"static"		
				});
			     
				
				
			});
			
			
			$("#qz_create_modal_btn").click(function(){
				
				//清除表格、样式数据 
				reset_form("#qzxxAddModal form");
				
				
				
				//弹出模态框
				$('#qzxxAddModal').modal({
					backdrop:"static"		
				});
			     
				
				
			});
			
			
$("#qz_join_modal_btn").click(function(){
				
				//清除表格、样式数据 
				reset_form("#qzJoinModal form");
				
				
				
				//弹出模态框
				$('#qzJoinModal').modal({
					backdrop:"static"		
				});
			     
				
				
			});
			
			//校验用户名是否可用
			$("#username_add").change(function(){
				//发送ajax请求验证姓名是否可用
				var username = this.value;
				$.ajax({
					url:"${ICHAT_PATH}/checkUsers",
					data:"username="+username,
					type:"POST",
					success:function(result){
						if(result.code == 100) {
							show_validate_msg("#username_add", "error", "用户名不存在");
							$("#friends_add_btn").attr("ajax-val","error");
						}else {
							show_validate_msg("#username_add", "success", "用户名已经存在");
							$("#friends_add_btn").attr("ajax-val","success");
						}
					}
				});
			});
			//显示验证信息
			function show_validate_msg(ele,status,msg) {
				//清楚当前元素校验状态
				$(ele).parent().removeClass("has-success has-error");
				$(ele).next("span").text("");
				if("success" == status) {
					$(ele).parent().addClass("has-success");
					$(ele).next("span").text(msg);
				}else if("error" == status) {
					$(ele).parent().addClass("has-error");
					$(ele).next("span").text(msg);
				}
			}
			
			$("#msg_btn").click(function(){	
			
			
				
				
				
				//弹出模态框
				$('#invitesModal').modal({
					backdrop:"static"		});
					
				
				
			});
			$("#qz_msg_btn").click(function(){	
			
			
				
				
				
				//弹出模态框
				$('#qzinvitesModal').modal({
					backdrop:"static"		});
					
				
				
			});
			
			function QueryCount(){
				
				
				$.ajax({
					url:"${ICHAT_PATH}/queryInvitesCount",
					data:"username="+'${username}',
					type:"GET",
					success:function(result){
						if(result.code == 100) {
							
							$("#msg_btn font").html(result.extend.count);
						}else {
							
						}
					}
				});
				
			}
			
	function QueryQzCount(){
				
				
				$.ajax({
					url:"${ICHAT_PATH}/QueryQzInvitesCount",
					
					type:"GET",
					success:function(result){
						if(result.code == 100) {
							
							$("#qz_msg_btn font").html(result.extend.qzcount);
						}else {
							
						}
					}
				});
				
			}
			function invites_to_page(pn) {
				$.ajax({
					url:"${ICHAT_PATH}/queryInvitesWithJson",
					data:"pn="+pn+"&username="+'<%=(String)(request.getSession().getAttribute("username"))%>',
					type:"GET",
					success:function(result){
					
						//console.log(result);
						//1.解析并显示员工数据
						build_friends_table(result,"#invites_tables tbody");
						//2.解析并显示分页信息
						build_page_info(result,"#invites_page_info");
						//3.解析显示分页条
						build_page_nav(result,"#invites_page_nav");}
				  
					
				});
			}
			
			
			function qz_invites_to_page(pn) {
				$.ajax({
					url:"${ICHAT_PATH}/QueryQzInvitesWithJson",
					data:"pn="+pn,
					type:"POST",
					success:function(result){
					
						//console.log(result);
						//1.解析并显示员工数据
						build_friends_table(result,"#qz_invites_tables tbody");
						//2.解析并显示分页信息
						build_page_info(result,"#qz_invites_page_info");
						//3.解析显示分页条
						build_page_nav(result,"#qz_invites_page_nav");}
				  
					
				});
			}
			//同意好友邀请-绑定事件
			$(document).on("click",".agree_btn",function() {
				
				
			var	sender=$(this).attr("ajax-val");
				
			$.ajax({
				url:"${ICHAT_PATH}/agreeInvites",
				data:"sender="+sender+"&receiver="+'<%=(String)(request.getSession().getAttribute("username"))%>',
				type:"POST",
				success:function(result){
					//console.log(result);
					
					
			  
				}
			});});
			
			//同意群组邀请-绑定事件
			$(document).on("click",".qz_agree_btn",function() {
				
				
			var	sender=$(this).attr("ajax-val");
			var qzid=$(this).attr("ajax-val1");
				
			$.ajax({
				url:"${ICHAT_PATH}/JoinQz",
				data:"sender="+sender+"&qzid="+qzid,
				type:"POST",
				success:function(result){
					//console.log(result);
					
					
			  
				}
			});
				
				
				
			     
			
				
				
			});
			
			//拒绝邀请-绑定事件
			$(document).on("click",".refuse_btn",function() {
				
				
			var	sender=$(this).attr("ajax-val");
				
			$.ajax({
				url:"${ICHAT_PATH}/refuseInvites",
				data:"sender="+sender+"&receiver="+'<%=(String)(request.getSession().getAttribute("username"))%>',
				type:"POST",
				success:function(result){
					//console.log(result);
					
					
			  
				}
			});});
			
				
			//拒绝群组邀请-绑定事件
			$(document).on("click",".qz_refuse_btn",function() {
				
				var sender=$(this).attr("ajax-val");
			var	qzid=$(this).attr("ajax-val1");
				
			$.ajax({
				url:"${ICHAT_PATH}/RefuseQzInvites",
				data:"sender="+sender+"&qzid="+qzid,
				type:"POST",
				success:function(result){
					//console.log(result);
					
					
			  
				}
			});});
			
			//删除好友-绑定事件
			$(document).on("click",".del_btn",function() {
				
				
			var	user2=$(this).attr("del_name");
			if(confirm('确实要删除该好友吗?')){
				
			
			$.ajax({
				url:"${ICHAT_PATH}/deleteFriends",
				data:"user1="+'<%=(String)(request.getSession().getAttribute("username"))%>'+"&user2="+user2,
				type:"POST",
				success:function(result){
					//console.log(result);
					if(result.code==100)alert("删除成功！");
					else alert("删除失败！");
					
			  
				}
			});
			
			
			
			}
			
					
				
				
			     
			
				
				
			});
			
			
			//退出群组-绑定事件
			$(document).on("click",".qz_del_btn",function() {
				
				
			var	qzid=$(this).attr("del_qzid");
			if(confirm('确实要退出群组吗?')){
				
			
			$.ajax({
				url:"${ICHAT_PATH}/LeaveQz",
				data:"qzid="+qzid,
				type:"POST",
				success:function(result){
					//console.log(result);
					if(result.code==100)alert("退出成功！");

                       if(result.code==101)if(result.extend.msg!=undefined)alert(result.extend.msg);
					
			  
				}
			});
			
			
			
			}
			
					
				
				
			     
			
				
				
			});
			
			
			
			//好友聊天按钮-绑定事件
	$(document).on("click",".chat_btn",function() 
					{
				
				
			var	chatname=$(this).attr("chat_name");
			
				
			
	
			
			 window.open('ChatUI.jsp?user2='+chatname, '_blank', 'height=600, width=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=yes, status=no'); 
			
			});
			


	
	//群组聊天按钮-绑定事件
$(document).on("click",".qz_chat_btn",function() 
			{
		
		
	var	qzid=$(this).attr("chat_qzid");
	
		
	

	
	 window.open('QzChatUI.jsp?qzid='+qzid, '_blank', 'height=600, width=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=yes, status=no'); 
	
	});
	

		
	//校验数据
	function validate_qzxxadd_form() {
		//1. 校验账号
		var qzid = $("#qzid_add").val();
		var regName = /(^[a-zA-Z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
		if(!regName.test(qzid)) {
			//alert("姓名格式为2-5位字符或3-16位数字和字母组合");
			show_validate_msg("#qzid_add", "error", "群组id格式为2-5位字符或3-16位数字和字母组合");
			return false;
		}else {
			show_validate_msg("#qzid_add", "success", "");
		}
		
		
		//2. 校验密码
		var password = $("#qzname_add").val();
		var regPassword =/(^[a-zA-Z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
		if(!regPassword.test(password)) {
			//alert("密码格式错误");
			show_validate_msg("#qzname_add", "error", "群组名称格式为2-5位字符或3-16位数字和字母组合");
			return false;
		}else {
			show_validate_msg("#qzname_add", "success", "");
		}
		return true;
	}
	
			
$("#modal_qzxx_btn").click(function(){
		
		
		//1. 对提交给服务器的数据进行第一层校验
		if(!validate_qzxxadd_form()) {
			return false;
		}
		//2.进行第二层校验
		if($(this).attr("ajax-val") =="error"){
			return false;
		}
		
	
		
		//2. 发送ajax请求
		$.ajax({
			url:"${ICHAT_PATH}/qzxxCreate",
			type:"GET",
			data:$("#qzxxAddModal form").serialize(),
			success:function(result){
				//alert(result.msg);
				if(result.code == 100) {
					//保存成功，关闭模态框，跳转到数据最后一页
					alert("建立成功!");
					$("#qzxxAddModal").modal('hide');
					
				}else {
					if(undefined != result.extend.qzerrorFields.qzid) {
						show_validate_msg("#qzid_add", "error", result.extend.qzErrorFields.qzid);
					}
					if(undefined != result.extend.qzerrorFields.qzname) {
						show_validate_msg("#qzname_add", "error", result.extend.qzErrorFields.qzname);
					}
					}
					
				
			}
		}); 
		
		
		
		
	});
	
//校验群组id是否可用
$("#qzid_add").change(function(){
	//发送ajax请求验证姓名是否可用
	var qzid = this.value;
	$.ajax({
		url:"${ICHAT_PATH}/queryQzid",
		data:"qzid="+qzid,
		type:"POST",
		success:function(result){
			if(result.code == 100) {
				show_validate_msg("#qzid_add", "success", "群组id可用");
				$("#modal_qzxx_btn").attr("ajax-val","success");
			}else {
				show_validate_msg("#qzid_add", "error", "群组id已经存在");
				$("#modal_qzxx_btn").attr("ajax-val","error");
			}
		}
	});
});
	
	
	

	
			
			var timer=self.setInterval("to_page(curPage),qz_to_page(curQzPage),qz_invites_to_page(curQzInvitesPage),QueryCount(),QueryQzCount(),invites_to_page(curInvitesPage)",2000);



	</script>
</body>
</html>