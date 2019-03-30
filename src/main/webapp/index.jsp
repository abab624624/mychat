<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>
<head>
	<%
	pageContext.setAttribute("ICHAT_PATH",request.getContextPath());
%>
<link rel="shortcut icon" href="static/Image/favicon.ico" type="image/x-icon" />
	<title>MyChat在线交流平台</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Effective Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements"
	/>
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- Meta tag Keywords -->
	<!-- css files -->
	<link rel="stylesheet" href="static/myui/css/style1.css" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link rel="stylesheet" href="static/myui/css/font-awesome.css">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //css files -->
	<!-- web-fonts -->
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
	<!-- //web-fonts -->
	
	<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" >
<script type="text/javascript" src="static/js/jquery-1.12.4.min.js"></script>


<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js" ></script>
</head>

<body>

	<div class="video-w3l" data-vide-bg="static/myui/video/1">
	
	
		<div class="modal fade" id="RegisterModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">注册账号</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal">
			 <div class="form-group">
			    <label for="inputEmail2" class="col-sm-2 control-label">账号</label>
			    
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="username" id="username_add"  placeholder="username">
			      <span id="helpBlock2" class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="password" id="password_add"  placeholder="******">
			      <span id="helpBlock2" class="help-block"></span>
			    </div>
			  </div>
			
			
			  
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="modal_register_btn">注册</button>
	      </div>
	    </div>
	  </div>
	</div>
	
		<!--header-->
		<div class="header-w3l">
			<h1>
				<span>MY</span>chat
				<span>arrow</span>APP
				<span>在线交流平台</span>
			</h1>
		</div>
		<!--//header-->
		<div class="main-content-agile">
			<div class="sub-main-w3">
				<h2>Login Here
					<i class="fa fa-hand-o-down" aria-hidden="true"></i>
				</h2>
				<form method="post" action="${ICHAT_PATH}/loginUsers">
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span>
						<input placeholder="Username" name="username" class="user" type="text" required="required">
					</div>
					<div class="pom-agile">
						
						<input placeholder="Password" name="password" class="pass" type="password" required="required">
					</div>
					<div class="sub-w3l">
						<div class="sub-agile">
							<input type="checkbox" id="brand1" value="">
							<label for="brand1">
								<span></span>Remember me</label>
						</div>
						<a onclick="regfunction()"  href="javascript:;">注册账号</a>
						<div class="clear"></div>
					</div>
					<div class="right-w3l">
						<input type="submit" value="Login">
					</div>
				</form>
			</div>
		</div>
		<!--//main-->
		<!--footer-->
		<div class="footer">
			<p>&copy; 2018 Mychat. All rights reserved | Design by
				<a href="http://arrow.nat123.cc">ArrowApp</a>
			</p>
		</div>
		<!--//footer-->
	</div>

	<!-- js -->

	<script src="static/myui/js/jquery.vide.min.js"></script>
	<!-- //js -->

	<script>
	function reset_form(ele) {
		$(ele)[0].reset();
		//清空表单样式
		$(ele).find("*").removeClass("has-success has-error");
		$(ele).find(".help-block").text("");
	}
	function regfunction(){
		//清除表格、样式数据 
		

		reset_form("#RegisterModal form");
		$('#RegisterModal').modal({
			backdrop:"static"		
		});
		
		
		
	}
	
	//校验数据
	function validate_add_form() {
		//1. 校验账号
		var username = $("#username_add").val();
		var regName = /(^[a-zA-Z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
		if(!regName.test(username)) {
			//alert("姓名格式为2-5位字符或3-16位数字和字母组合");
			show_validate_msg("#username_add", "error", "账号格式为2-5位字符或3-16位数字和字母组合");
			return false;
		}else {
			show_validate_msg("#username_add", "success", "");
		}
		
		
		//2. 校验密码
		var password = $("#password_add").val();
		var regPassword =/^[A-Za-z]+[0-9]+[A-Za-z0-9]*|[0-9]+[A-Za-z]+[A-Za-z0-9]*$/g;
		if(!regPassword.test(password)) {
			//alert("密码格式错误");
			show_validate_msg("#password_add", "error", "密码必须由6-16个英文字母和数字的字符串组成！");
			return false;
		}else {
			show_validate_msg("#password_add", "success", "");
		}
		return true;
	}
	
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
	
	
	$("#modal_register_btn").click(function(){
		
		
		//1. 对提交给服务器的数据进行第一层校验
		if(!validate_add_form()) {
			return false;
		}
		//2.进行第二层校验
		if($(this).attr("ajax-val") =="error"){
			return false;
		}
		
	
		
		//2. 发送ajax请求
		$.ajax({
			url:"${ICHAT_PATH}/registerUsers",
			type:"GET",
			data:$("#RegisterModal form").serialize(),
			success:function(result){
				//alert(result.msg);
				if(result.code == 100) {
					//保存成功，关闭模态框，跳转到数据最后一页
					alert("注册成功!");
					$("#RegisterModal").modal('hide');
					
				}else {
					if(undefined != result.extend.errorFields.username) {
						show_validate_msg("#username_add", "error", result.extend.errorFields.username);
					}
					if(undefined != result.extend.errorFields.password) {
						show_validate_msg("#password_add", "error", result.extend.errorFields.password);
					}
					}
					
				
			}
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
					show_validate_msg("#username_add", "success", "用户名可用");
					$("#modal_register_btn").attr("ajax-val","success");
				}else {
					show_validate_msg("#username_add", "error", "用户名已经存在");
					$("#modal_register_btn").attr("ajax-val","error");
				}
			}
		});
	});

	
	</script>
</body>
</html>