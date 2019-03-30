<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
	<head>


		

	
		
		<style type="text/css">
		.main-w3l .container .col-md-4 .panel-body .form-horizontal .form-group .col-sm-9 #inputEmail3 {
		
	color: #F60;
}
        .main-w3l .container .navbar.navbar-inverse .container-fluid #bs-example-navbar-collapse-1 .navbar-form.navbar-left .form-group .form-control {
	color: #F60;

}
        .main-w3l .container .col-md-4 .panel-body .form-horizontal .form-group .col-sm-9 #inputPassword3 {
	color: #F60;

}
        </style>
		<%@ include file="Hd.jsp" %>
	<%
	pageContext.setAttribute("ICHAT_PATH",request.getContextPath());
%>






<!-- Meta tag Keywords -->

<!-- css files -->

	</head>

	<body>
<canvas id="myCanvas"></canvas>

		<div class="main-w3l">
		
		
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
		

		<div  class="container">
		
		
  <div class="row">
  <div class="col-md-3 "></br></div>
  <div class="col-md-3 "></br></div>
  <div class="col-md-3 "></br></div>
  <div class="col-md-3 "></br></div>
  <div class="col-md-3 "></br></div>
  <div class="col-md-3 "></br></div>
  <div class="col-md-3 "></br></div>
  <div class="col-md-3 "></br></div>
  <div class="col-md-3 "></br></div>
  <div class="col-md-3 "></br></div>
  <div class="col-md-3 "></br></div>
  <div class="col-md-3 "></br></div>
    <div class="col-md-3 "></br></div>  
    <div class="col-md-3 "></br></div> 
     <div class="col-md-3 "></br></div> 
      <div class="col-md-3 "></br></div>  
      <div class="col-md-3 "></br></div>  
      <div class="col-md-3 "></br></div>  
      <div class="col-md-3 "></br></div>  
      <div class="col-md-3 "></br></div>  
      <div class="col-md-3 "></br></div> 
     <div class="col-md-3 "></br></div>
</div>  	

<div class="div1" class="panel panel-default">
						<div class="panel-heading">
							用户登录
						</div>
						<div  class="panel-body"  >


							<form class="form-horizontal"  method="post" action="${ICHAT_PATH}/loginUsers">
								<div class="form-group">
									<label for="inputEmail3"  class="col-sm-3 control-label">
										用户名
									</label>
									<div class="col-sm-6" >
										<input style="border:0px;background:rgba(255,255,255, 0.1);" type="text" name="username" class="form-control" 
											placeholder="username">
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword3"  class="col-sm-3 control-label">
										密码
									</label>
									<div class="col-sm-6">
										<input type="password"  style="border:0px;background:rgba(255,255,255, 0.1); " class="form-control" name="password"
											id="inputPassword3"  placeholder="Password">
									</div>
								</div>
								

								<div  class="form-group" >
									<div class="col-sm-offset-3 col-sm-6" >
										<button style="border:0px;background:rgba(255,255,255, 0.1); color: #F60;" type="submit" class="btn btn-default">
											登录
										</button>
										<button  style="border:0px;background:rgba(255,255,255, 0.1); color: #F60;" type="reset" class="btn btn-default">
											reset
										</button>
										<button style="border:0px;background:rgba(255,255,255, 0.1); color: #F60; "  type="button" class="btn btn-default">
											取消
										</button>
										
										
									</div>
									<div class="col-sm-offset-8 col-sm-3" >
									<button style="border:0px;background:rgba(255,255,255, 0.1); color: #F60; " onclick="regfunction()"  type="button" class="btn btn-default">
											注册账号
										</button>
								</div>
								</div>
							</form>



						</div>
	</div>
		
			

				





				</div>
			</div>





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

