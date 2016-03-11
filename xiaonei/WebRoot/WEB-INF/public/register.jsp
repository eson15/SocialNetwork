<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="/xiaonei/css/common.css" />
    <link rel="stylesheet" type="text/css" href="/xiaonei/css/register.css" />
    <script type="text/javascript" src="/xiaonei/js/jquery-1.3.1.js"></script>
    <script type="text/javascript" src="/xiaonei/js/publicJs.js"> </script>
    <script type="text/javascript" src="/xiaonei/myAJAX/ajax_uni.js"></script>
  </head>
  
  <body>
    <jsp:include page="head.jsp"></jsp:include>
    <div class="reg_main_frame">
    	<!-- 左边：加入校内后可以选择干啥 -->
    	<div class="play_item">
    		<img src="/xiaonei/images/front/jiaru.jpg" />
    	</div>
    	<!-- 注册用的表格 -->
    	<div class="reg_table1">
    		<span class="font6">简单一步，快速注册</span>
    		<form action="/xiaonei/register/registerAction.action" method="post">
	    		<table>
	    			<tr>
	    				<td class="tab_td1">真实姓名：</td>
	    				<td class="tabl_td2"><input type="text" name="name"/></td>
	    				<td><span class="spanVal">请输入真实姓名</span></td>
	    			</tr>
	    			<tr>
	    				<td class="tab_td1">性别：</td>
	    				<td>
	    					<input type="radio" name="sex" value="男"/><span class="font3">男</span>
	    					<input type="radio" name="sex" value="女"/><span class="font3">女</span>
	    				</td>
	    				<td></td>
	    			</tr>
	    			<tr>
	    				<td class="tab_td1">身份：</td>
	    				<td>
	    					<select onchange="changeStatus(this);">
	    						<option value="worker">已工作</option>
	    						<option value="graduate">大学生</option>
	    						<option value="midstu">中学生/中专生</option>
	    						<option value="nothing">以上都不是</option>
	    					</select>
	    				</td>
	    				<td></td>
	    			</tr>
	    			<!-- 考虑已经工作的情况 start-->
	    			<tr class="spe_worker">
	    				<td class="tab_td1">居住地：</td>
	    				<td>
	    					<select>
	    						<option>--请选择省份--</option>
	    						<option>安徽省</option>
	    						<option>上海市</option>
	    						<option>江苏省</option>
	    					</select>
	    				</td>
	    				<td></td>
	    			</tr>
	    			<tr class="spe_worker">
	    				<td class="tab_td1">选择城市：</td>
	    				<td>
	    					<select>
	    						<option>--请选择城市--</option>
	    						<option></option>
	    						<option></option>
	    						<option></option>
	    						<option></option>
	    					</select>
	    				</td>
	    				<td></td>
	    			</tr>
	    			<tr class="spe_worker">
	    				<td class="tab_td1">公司：</td>
	    				<td><input type="text" name="??"/></td>
	    				<td></td>
	    			</tr>
	    			<!-- 考虑已经工作的情况 end-->
	    			
	    			<!-- 考虑大学生的情况 start -->
	    			<tr class="spe_graduate">
	    				<td class="tab_td1">类型：</td>
	    				<td>
	    					<select name="userType" >
	    						<option value="graduate">本科</option>
	    						<option value="master">硕士</option>
	    						<option value="doctor">博士</option>
	    					</select>
	    				</td>
	    				<td></td>
	    			</tr>
	    			<tr class="spe_graduate">
	    				<td class="tab_td1">大学：</td>
	    				<td>
	    					<input id="university" type="text" onclick="showUniTbl()" name=""/>
		    				<!-- 隐藏一个大学的id，注册一个用户， 应当已大学的编号为准，不能已名字，因为可能重名-->
		    				<input type="hidden" id="uuniversity" name="universityId">
	    				</td>
	    				<td></td>
	    			</tr>
	    			<!-- 考虑大学生的情况 end -->
	    			
	    			<tr>
	    				<td class="tab_td1">电子邮箱：</td>
	    				<td><input type="text" name="email"/>
	    		<!--		<img src="/xiaonei/images/front/tanhao.png">
	    					<span class="font3">如果没有邮箱，请注册：<br/>
	    					&nbsp;&nbsp;<a href="#">163</a>&nbsp;
	    					<a href="#">126</a>&nbsp;
	    					<a href="#">qq</a>&nbsp;
	    					<a href="#">hotmail</a>&nbsp;
	    					<a href="#">gmail</a></span> -->
	    				</td>  				
	    				<td></td>
	    			</tr>
	    			<tr>
	    				<td class="tab_td1">设置密码：</td>
	    				<td><input type="password" name="pwd"/></td>
	    				<td></td>
	    			</tr>
	    			<tr>
	    				<td class="tab_td1">确认密码：</td>
	    				<td><input type="password" name="pwd2"/></td>
	    				<td></td>
	    			</tr>
	    			<tr>
	    				<td class="tab_td1">验证码：</td>
	    				<td><input type="text"/></td>
	    				<td>【1234】<a href="#">看不清？换一张</a></td>
	    			</tr>
	    			<tr>
	    				<td></td>
	    				<td><input name="submit" type="submit" value="" class="button1" /></td>
	    				<td></td>
	    			</tr>
	    			<tr>
	    				<td></td>
	    				<td><input name="??" type="checkbox"/><span class="font3">&nbsp;我已同意并遵守<a href="#">校内网条款</a></span></td>
	    				<td></td>
	    			</tr>
	    		</table>
    		</form>
    	</div>
    </div>
    <jsp:include page="foot.jsp"></jsp:include>
    
    <!-- 准备显示的大学表格 start -->
	<div class="divSch" id="uniDiv"
		style="display: none; position: absolute; top: 130px; left: 1040px">
		<table border="1" align="center" height="380px" width="590px"
			bordercolor="#3B5888">
			<!-- 显示所有国家 -->
			<tr>
				<td bordercolor="#C3C3C3" width="500px">

					<c:forEach var="country" items="${countrylist }">
						<a id="${country.id }" onclick="setCoUnis(this)" class="xh"
						href="javascript:void(0);">${country.name }</a> |
					</c:forEach>
				</td>
			</tr>
			<!-- 显示当前国家的所有直辖市和省份 -->
			<tr>
				<td bordercolor="#C3C3C3">
					<div id="proTbl">
						<table width="100%">
							<tr>							
								<td>
									<c:forEach var="province" items="${provincelist}">
										<a onclick="setProUnis(this)" href="javascript:void(0);"
										class="xh" id="${province.id}" name="${province.country.id }">
										${province.name } </a>
									</c:forEach>
								</td>							
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<!-- 显示当前省或者直辖市的大学 -->
			<tr>
				<td valign="top" bordercolor="#C3C3C3">
					<div style="width: 590px; height: 280px; overflow: auto" id="uniTbl">
						<table width="100%">
							<tr>
								<c:forEach var="university" items="${universitylist}" varStatus="vs">
									<td>
										<li>
											<a onclick="showMyUni(this)" href="javascript:void(0);"
											class="xh"  id="${university.id }">${university.name }</a>
										</li>
									</td>
									<c:if test="${vs.count%3==0}"></tr><tr></c:if>
								</c:forEach>
							</tr>							
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td align="right" bordercolor="#FFFFFF">
					<input type="button" value="关闭窗口" onclick="closeUniTbl()"
						style="color: white; background-color: #3B5888; padding: 3px;" />
				</td>
			</tr>
		</table>
	</div>
	<!-- 准备显示的大学表格 end -->
  </body>
</html>
