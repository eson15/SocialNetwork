<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>校内网首页</title>
    <link rel="stylesheet" type="text/css" href="/xiaonei/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/xiaonei/css/common.css" />
    <script type="text/javascript">
    	function register() {
    		window.location.href = "/xiaonei/register/register.action";
    	}
    </script>
  </head>
  
  <body>
  <!-- 引入头页面 -->
  <jsp:include page="head.jsp"></jsp:include>
    <div class="main">
    	<!-- 左边注册和登录 -->
    	<div class="reg_login">
    		<div class="logForm">
    			<form action="/xiaonei/profile/login.action" method="post">
				    <span class="font4">登录邮箱:</span><br/>
				    <input type="text" name="email" value="${user.email }"/><br/> 
				    <span  class="font4">登录密码:</span><br/>
				    <input type="password" name="pwd"/><br/>
				    <c:if test="${message == 'error' }">
				    	<span style="color: red; font-size: 12px;">邮箱或密码错误</span><br>
				    </c:if>			    
				    <input type="checkbox" /> 自动登录<br/>
				    <input type="submit" value="　登录　" class="sub" />
				    　    <a href="#">找回密码</a>
			    </form>
    		</div>
    		<div class="reg">
    			<span class="font5">注册</span><br/>
    			<a href="/xiaonei/register/register.action">校内期待你的加入</a>
    		</div>
    		<div class="mobile_login">
    			<span class="font5">手机登录</span><br/>
    			<a href="#">请访问m.xiaonei.com </a>
    		</div>
    	</div>
    	
    	<!-- 右边正文 -->
    	<div class="banner1">
    		<img class="img" src="/xiaonei/images/front/ay-0812-658-280.jpg"> 
    	</div>
    	<!-- 校内网介绍 -->
    	<div class="intro">
    		<p class="font2">校内网是一个真实社交网络，加入她你可以：</p>
    		<ul>
    			<li>联络朋友，了解他们的最新动态</li>
    			<li>用照片和日志记录生活，展示自我</li>
    			<li>找到老同学，结识新朋友</li>
    			<li>和朋友分享相片、音乐和电影</li>
    			<li>自由、安全地控制个人隐私</li>
    		</ul>
    	</div>
    	<!-- 注册第二个入口 -->
    	<div class="reg2">
    		<p class="font2">因为真实 所以精彩</p>
    		<p>校内存知己<br>
    		<input type="image" src="/xiaonei/images/front/register.jpg" onclick="register()"> 		    		
			</p>    		
    	</div>
		<!-- 搜索好友 -->
	    <div class="sea_friend">
	    	<span class="font2">寻找你的朋友</span>　<input type="text" name="sea_friend" />
    		<input type="image" src="/xiaonei/images/front/sou.jpg" onclick=""/><br/>
    		* <span class="font3">校内网目前已开通<font class="font1">海外1500所大学</font>、 <font class="font1">国内3000所大学</font>、 <font class="font1">56000所中学</font>及 <font class="font1">85000家公司</font>。</span>
	    </div>
	    <!-- 建议 -->
	    <div class="advice">
		    <span class="font4">我要提建议我们每天都在快乐地进步着：</span><br/> 
			10月16日 狗狗：全新界面登场 <br/>
			10月15日 相册预加载和FLASH版上传，浏览相册更快更爽<br/>
			10月14日 留言板新增“悄悄话”功能 <br/>
	    </div>
    </div>
    <jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>
