<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>  
    <title>群组聊天</title>  
    <meta charset="utf-8" />  
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <link href="/mychat/static/css/index.css" rel="stylesheet" />  

   <style type="text/css">html{width=300;}</style>
   <link rel="shortcut icon" href="static/Image/favicon.ico" type="image/x-icon" />
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
  
                </div>  
                <div class="box_ft">  
                    <div class="box_ft_bd hide">  
                        <div class="emoji_panel">  
                            <ul class="exp_hd">  
                                <li class="exp_hd_item active" data-i="0">  
                                    <a href="javascript:;">QQ表情</a>  
                                </li>  
                                <li class="exp_hd_item" data-i="1">  
                                    <a href="javascript:;">符号表情</a>  
                                </li>  
                                <li class="exp_hd_item" data-i="2">  
                                    <a href="javascript:;">动画表情</a>  
                                </li>  
                            </ul>  
                            <div class="exp_bd">  
                                <div class="exp_cont active">  
                                    <a title="微笑" type="qq" class="qqface qqface0">微笑</a> <a title="撇嘴" type="qq" class="qqface qqface1">撇嘴</a> <a title="色" type="qq" class="qqface qqface2">色</a> <a title="发呆" type="qq" class="qqface qqface3">发呆</a> <a title="得意" type="qq" class="qqface qqface4">得意</a> <a title="流泪" type="qq" class="qqface qqface5">流泪</a> <a title="害羞" type="qq" class="qqface qqface6">害羞</a> <a title="闭嘴" type="qq" class="qqface qqface7">闭嘴</a> <a title="睡" type="qq" class="qqface qqface8">睡</a> <a title="大哭" type="qq" class="qqface qqface9">大哭</a> <a title="尴尬" type="qq" class="qqface qqface10">尴尬</a> <a title="发怒" type="qq" class="qqface qqface11">发怒</a> <a title="调皮" type="qq" class="qqface qqface12">调皮</a> <a title="呲牙" type="qq" class="qqface qqface13">呲牙</a> <a title="惊讶" type="qq" class="qqface qqface14">惊讶</a> <a title="难过" type="qq" class="qqface qqface15">难过</a> <a title="酷" type="qq" class="qqface qqface16">酷</a> <a title="冷汗" type="qq" class="qqface qqface17">冷汗</a> <a title="抓狂" type="qq" class="qqface qqface18">抓狂</a> <a title="吐" type="qq" class="qqface qqface19">吐</a> <a title="偷笑" type="qq" class="qqface qqface20">偷笑</a> <a title="愉快" type="qq" class="qqface qqface21">愉快</a> <a title="白眼" type="qq" class="qqface qqface22">白眼</a> <a title="傲慢" type="qq" class="qqface qqface23">傲慢</a> <a title="饥饿" type="qq" class="qqface qqface24">饥饿</a> <a title="困" type="qq" class="qqface qqface25">困</a> <a title="惊恐" type="qq" class="qqface qqface26">惊恐</a> <a title="流汗" type="qq" class="qqface qqface27">流汗</a> <a title="憨笑" type="qq" class="qqface qqface28">憨笑</a> <a title="悠闲" type="qq" class="qqface qqface29">悠闲</a> <a title="奋斗" type="qq" class="qqface qqface30">奋斗</a> <a title="咒骂" type="qq" class="qqface qqface31">咒骂</a> <a title="疑问" type="qq" class="qqface qqface32">疑问</a> <a title="嘘" type="qq" class="qqface qqface33">嘘</a> <a title="晕" type="qq" class="qqface qqface34">晕</a> <a title="疯了" type="qq" class="qqface qqface35">疯了</a> <a title="衰" type="qq" class="qqface qqface36">衰</a> <a title="骷髅" type="qq" class="qqface qqface37">骷髅</a> <a title="敲打" type="qq" class="qqface qqface38">敲打</a> <a title="再见" type="qq" class="qqface qqface39">再见</a> <a title="擦汗" type="qq" class="qqface qqface40">擦汗</a> <a title="抠鼻" type="qq" class="qqface qqface41">抠鼻</a> <a title="鼓掌" type="qq" class="qqface qqface42">鼓掌</a> <a title="糗大了" type="qq" class="qqface qqface43">糗大了</a> <a title="坏笑" type="qq" class="qqface qqface44">坏笑</a> <a title="左哼哼" type="qq" class="qqface qqface45">左哼哼</a> <a title="右哼哼" type="qq" class="qqface qqface46">右哼哼</a> <a title="哈欠" type="qq" class="qqface qqface47">哈欠</a> <a title="鄙视" type="qq" class="qqface qqface48">鄙视</a> <a title="委屈" type="qq" class="qqface qqface49">委屈</a> <a title="快哭了" type="qq" class="qqface qqface50">快哭了</a> <a title="阴险" type="qq" class="qqface qqface51">阴险</a> <a title="亲亲" type="qq" class="qqface qqface52">亲亲</a> <a title="吓" type="qq" class="qqface qqface53">吓</a> <a title="可怜" type="qq" class="qqface qqface54">可怜</a> <a title="菜刀" type="qq" class="qqface qqface55">菜刀</a> <a title="西瓜" type="qq" class="qqface qqface56">西瓜</a> <a title="啤酒" type="qq" class="qqface qqface57">啤酒</a> <a title="篮球" type="qq" class="qqface qqface58">篮球</a> <a title="乒乓" type="qq" class="qqface qqface59">乒乓</a> <a title="咖啡" type="qq" class="qqface qqface60">咖啡</a> <a title="饭" type="qq" class="qqface qqface61">饭</a> <a title="猪头" type="qq" class="qqface qqface62">猪头</a> <a title="玫瑰" type="qq" class="qqface qqface63">玫瑰</a> <a title="凋谢" type="qq" class="qqface qqface64">凋谢</a> <a title="嘴唇" type="qq" class="qqface qqface65">嘴唇</a> <a title="爱心" type="qq" class="qqface qqface66">爱心</a> <a title="心碎" type="qq" class="qqface qqface67">心碎</a> <a title="蛋糕" type="qq" class="qqface qqface68">蛋糕</a> <a title="闪电" type="qq" class="qqface qqface69">闪电</a> <a title="炸弹" type="qq" class="qqface qqface70">炸弹</a> <a title="刀" type="qq" class="qqface qqface71">刀</a> <a title="足球" type="qq" class="qqface qqface72">足球</a> <a title="瓢虫" type="qq" class="qqface qqface73">瓢虫</a> <a title="便便" type="qq" class="qqface qqface74">便便</a> <a title="月亮" type="qq" class="qqface qqface75">月亮</a> <a title="太阳" type="qq" class="qqface qqface76">太阳</a> <a title="礼物" type="qq" class="qqface qqface77">礼物</a> <a title="拥抱" type="qq" class="qqface qqface78">拥抱</a> <a title="强" type="qq" class="qqface qqface79">强</a> <a title="弱" type="qq" class="qqface qqface80">弱</a> <a title="握手" type="qq" class="qqface qqface81">握手</a> <a title="胜利" type="qq" class="qqface qqface82">胜利</a> <a title="抱拳" type="qq" class="qqface qqface83">抱拳</a> <a title="勾引" type="qq" class="qqface qqface84">勾引</a> <a title="拳头" type="qq" class="qqface qqface85">拳头</a> <a title="差劲" type="qq" class="qqface qqface86">差劲</a> <a title="爱你" type="qq" class="qqface qqface87">爱你</a> <a title="NO" type="qq" class="qqface qqface88">NO</a> <a title="OK" type="qq" class="qqface qqface89">OK</a> <a title="爱情" type="qq" class="qqface qqface90">爱情</a> <a title="飞吻" type="qq" class="qqface qqface91">飞吻</a> <a title="跳跳" type="qq" class="qqface qqface92">跳跳</a> <a title="发抖" type="qq" class="qqface qqface93">发抖</a> <a title="怄火" type="qq" class="qqface qqface94">怄火</a> <a title="转圈" type="qq" class="qqface qqface95">转圈</a> <a title="磕头" type="qq" class="qqface qqface96">磕头</a> <a title="回头" type="qq" class="qqface qqface97">回头</a> <a title="跳绳" type="qq" class="qqface qqface98">跳绳</a> <a title="投降" type="qq" class="qqface qqface99">投降</a> <a title="激动" type="qq" class="qqface qqface100">激动</a> <a title="乱舞" type="qq" class="qqface qqface101">乱舞</a> <a title="献吻" type="qq" class="qqface qqface102">献吻</a> <a title="左太极" type="qq" class="qqface qqface103">左太极</a> <a title="右太极" type="qq" class="qqface qqface104">右太极</a>  
                                </div>  
                                <div class="exp_cont emoji_face"></div>  
                                <div class="exp_cont tuzki_face"></div>  
                            </div>  
                        </div>  
                    </div>  
                    <div class="box_ft_hd">  
                        <div class="eaitWrap">  
                            <pre id="editArea" class="editArea" contenteditable="true"></pre>  
                        </div>  
                        <a href="javascript:;" class="web_wechat_face" id="web_wechat_face"></a>  
                        
                        <a href="javascript:;" class="web_wechat_pic" id="web_wechat_pic"></a>  
                        <input type="hidden" id="countUtil" />
                         <a href="javascript:;" class="btn btn-primary btn-xs glyphicon glyphicon-pencil" id="btn_send">发送</a>
                           
                           <a href="javascript:;"  class="glyphicon glyphicon-sort-by-attributes btn-xs" id="my_wechat_pic"></a>     
                            <a href="javascript:;"  class="glyphicon glyphicon-user   btn-xs" id="show_users"></a>     
                                          
                    </div> 
                      
                </div>  
            </div>  
        </div>  
    </div>  
   
    <script src="/mychat/static/js/index.js"></script>  
<script>    

var height=0;
var flag=true;
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
	var qzid='${param.qzid}';
	function addNotification()
	{
		
		$.ajax({
			url:"${ICHAT_PATH}/AddQzNotification",
			data:"&qzid="+'${param.qzid}',
			type:"POST",
			success:function(result){
				if(result.code==100)	{
			
					
				}
			
				}
			
			});
		
		
		
	}
$("#btn_send").click(function(){
	
	$.ajax({
		url:"${ICHAT_PATH}/InsertQzContent",
		data:"qzid="+'${param.qzid}'+"&content="+$('#editArea').text() ,
		type:"POST",
		success:function(result){
			if(result.code==100)	{
				$("#editArea").empty();
				addNotification();
				
			}
		
			}
		
		});
			
			
	
	
	
	
	
});
	
	
function query_qz_content_first(qzid) {
	
	
	$.ajax({
		url:"${ICHAT_PATH}/QueryQzContentWithJsonFirst",
		data:"qzid="+qzid,
		type:"POST",
		success:function(result){
			
			if(result.code==100){
		
			//1.解析并显示聊天数据
			build_content_table(result,"#messageList");
		     
			$("#countUtil").val(result.extend.count);
	     
			
	       
			}
			
			qz_query_content(qzid);
			
			
	    	
		}
	});
	
}

//var t=setTimeout("qz_query_content(qzid)",3000);
	function qz_query_content(qzid) {
		
	
		$.ajax({
			url:"${ICHAT_PATH}/QueryQzContentWithJson",
			data:"qzid="+qzid+"&count="+$("#countUtil").val(),
			type:"POST",
			success:function(result){
				
				if(result.code==100){
			
				//1.解析并显示聊天数据
				build_content_table(result,"#messageList");
				$("#countUtil").val(result.extend.QzLtlbList.length);
		        
				qz_query_content(qzid);
				
				}
		      
		    	 
				 
		    	
			}
		});
		
	}
	

	
	function build_content_table(result,ele){
		$(ele).empty();
		var contents = result.extend.QzLtlbList;
		$.each(contents,function(index,item){

			
		
			var rootdiv;
	
			var img;
			var contentdiv;
			var nicknamediv;
			var timespan;
			var divdirect;
			var divbubble;
			var divplain;
		var fontred;
		var fontdefault;
			if(item.content!=undefined)
			{
				
			
		      if(item.username!='${username}')
		      { 
		       rootdiv = $("<div></div>").addClass("message"); 
		      divdirect=$("<div></div>").addClass("bubble bubble_default left");
		      img=$("<img></img>").addClass("avatar").attr("src","static/Image/p11.png");
		      }
		      if(item.username =='${username}')
		    	  {
		    	  
		    	  rootdiv = $("<div></div>").addClass("message me"); 
			      divdirect=$("<div></div>").addClass("bubble bubble_primary right");
			      img=$("<img></img>").addClass("avatar").attr("src","static/Image/p12.png");
		    	  
		    	  }
			
	     
			 contentdiv=$("<div></div>").addClass("content");
			 nicknamediv=$("<div></div>").addClass("nickname");
			 timespan=$("<span></span>").addClass("time").append(item.sjCn);
			
			 divbubble=$("<div></div>").addClass("bubble_cont");
			 divplain=$("<div></div>").addClass("plain");
			 
			 
			 divplain.append(item.content).appendTo(divbubble);
			 divbubble.appendTo(divdirect);
			 if(item.username =='${username}')
				 nicknamediv.append(timespan).append(item.username);
				 if(item.username !='${username}')
					 nicknamediv.append(item.username).append(timespan);
			 fontred=$("<font></font>");
	    	  fontdefault=$("<font></font>");
			  if(item.username=='${username}'){
				  if(item.myqzread==0)
			 contentdiv.append(nicknamediv).append(fontred).append(divdirect);
				  
				  if(item.myqzread==1)
						 contentdiv.append(nicknamediv).append(fontdefault).append(divdirect);
			  }
			  else{
				if(item.myqzread==0)
				  contentdiv.append(nicknamediv).append(divdirect).append(fontred);
				
			    if(item.myqzread==1)  contentdiv.append(nicknamediv).append(divdirect).append(fontdefault);
			  }
			 rootdiv.append(img).append(contentdiv).appendTo(ele);
			 
			 
			}
			
		
				
			
		});
	}
/* 	var timer=self.setInterval("qz_query_content('${param.qzid}')",500); */
	

	$("#show_users").click(function(){
		
		
		
		
		var	qzid='${param.qzid}';
		
		 window.open('Qzusers.jsp?qzid='+qzid, '_blank', 'height=600, width=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=yes, status=no'); 
		
	});
	
	$(function(){
		
		
		query_qz_content_first(qzid);
		
		
	});
	</script>
</body>

</html>
