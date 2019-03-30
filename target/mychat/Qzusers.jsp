<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>  
    <title>群组信息</title>  
    <meta charset="utf-8" />  
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <link href="/mychat/static/css/index.css" rel="stylesheet" />  
   <link rel="shortcut icon" href="static/Image/favicon.ico" type="image/x-icon" />
   <style type="text/css">html{width=300;}</style>
</head>  

<%
	pageContext.setAttribute("ICHAT_PATH",request.getContextPath());
%>
<!-- 引入jquery -->
<script type="text/javascript"
	src="${ICHAT_PATH}/static/js/jquery-1.12.4.min.js"></script>
<!-- Bootstrap -->
<link
	href="${ICHAT_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${ICHAT_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<body>  
 
     <div class="main" >  
        <div class="main_inner clearfix">  
            <div class="panel"></div>  
            <div id="chatArea" class="box chat">  
                <div class="box_hd"></div>  
                <div class="box_bd" id="messageList">  
                创建人<div id='creater'></div>
  <!-- 显示表格数据 -->
		<div class="row">
			<div class=col-md-12>
				<table class="table table-hover" id="qzusers_tables">
					<thead>
						<tr>

							<th>用户名</th>
							<th>用户状态</th>
							

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
			<div class="col-md-6" id="qzusers_page_info"></div>

			<!-- 分页条 -->
			<div class="col-md-6" id="qzusers_page_nav"></div>
		</div>
	
  
                </div>  
               
            </div>  
        </div>  
     
   </div>
    <script src="/mychat/static/js/index.js"></script>  
<script>    


var curPage=1;
function winResize(){   
	   var ToH=525;   
	   var ToW=700;   
	if(window.navigator.appName=="Netscape"){ //firefox   
	       window.innerHeight=ToH;   
	       window.innerWidth=ToW;   
	    }else{//ie   
	       var cWinwidth=window.document.documentElement.clientWidth;   
	       var cWinheight=window.document.documentElement.clientHeight;   
	       window.resizeBy(ToW-cWinwidth,ToH-cWinheight);  
	       cWinwidth=window.document.documentElement.clientWidth;   
	       cWinheight=window.document.documentElement.clientHeight;   
	       window.resizeBy(ToW-cWinwidth,ToH-cWinheight);   
	   }   
	}  

	winResize();
$(function(){
	
	to_page(1);
	
findQzcreater();
	
	
});

function findQzcreater(){
	
	$.ajax({
		
		url:"${ICHAT_PATH}/FindQzcreater",
		data:"qzid="+'${param.qzid}',
		type:"POST",
		success:function(result){
			
			if(result.code==100){
				
				
					$("#creater").html(result.extend.creater);
				
			}
			
			
		}
	});
	
}
function to_page(pn){
$.ajax({
	url:"${ICHAT_PATH}/QueryQzusers",
	data:"qzid="+'${param.qzid}'+"&pn="+pn,
	type:"POST",
	success:function(result){
		//console.log(result);
		if(result.code==100)
			{
			if(result.extend.pageInfo.pageNum==curPage)
			{
		
		build_users_table(result);

		build_page_info(result);
	
		build_page_nav(result);
			}
			
				
			
			}
		
  
	}
});
}


function build_users_table(result){
	$("#qzusers_tables tbody").empty();
	var usersList = result.extend.pageInfo.list;
	$.each(usersList,function(index,item){
		
		var user2; 
		
		if(item.satus==1)var user2 = $("<td></td>").append('在线');
		if(item.satus==0)var user2 = $("<td></td>").append('离线');
		
		var user1 = $("<td></td>").append(item.username); 
		
	
	
		
		
		
		
		
			  
				  
				  		
                         		  	
				  
			  
		
			  
		$("<tr></tr>").append(user1)
			.append(user2)
			
	
			.appendTo("#qzusers_tables tbody");
			  
					
					 
					 
					 
				
				
				
	        
			
			
			
		
	
	});
}

//解析显示分页信息
function build_page_info(result){
	$("#qzusers_page_info").empty();
	$("#qzusers_page_info").append("第"+result.extend.pageInfo.pageNum+"页,共"
			+result.extend.pageInfo.pages+"页,本群组共  "
			+result.extend.pageInfo.total+"位用户");
	totalRecord = result.extend.pageInfo.total;
	currentPage = result.extend.pageInfo.pageNum;
}
//解析显示分页条
function build_page_nav(result){
	$("#qzusers_page_nav").empty();
	var ul = $("<ul></ul>").addClass("pagination");
	
	var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
	var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
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
	var lastPageLi = $("<li></li>").append($("<a href='#'></a>").append("尾页").attr("href","#"));
	
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
	navEle.appendTo("#qzusers_page_nav");
}



var timer=self.setInterval("to_page(curPage)",2000);


	</script>
</body>

</html>
