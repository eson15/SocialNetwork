<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<link rel="stylesheet" href="/xiaonei/css/css/updPersonInfo.css" type="text/css"></link>
	</head>
	<body>

		<jsp:include page="head.jsp"></jsp:include>
		<div class="info_main">
			<div class="info_left">
			<table width="100%">
			<tr>
			<td width="80%" valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="5"
						>
						<tr>
							<td  style="border-bottom: 1px #898989 solid;">
								<img src="/xiaonei/images/front/photo.gif" />
								<font class="word2" > 上传新照片
								</font>
							</td>
						</tr>
						<tr>
							<td >
								<img src="/xiaonei/images/front/photo.gif" />
								<font class="word2" > 创建相册
								</font>
							</td>
						</tr>
						<tr>
							<td valign="top"  align="center" style="border-bottom: 1px #D8DFEA solid;">
								<form action="/xiaonei/album/addAlbum.action" method="post">
								<table width="80%" cellpadding="5" cellspacing="5" border="0">
								
									<tr>
										<td align="right" width="20%">
											<font class="word3" style="font-weight: bold;">名字:</font>
										</td>
										<td align="left">
											<input type="text" id="aname" name="name" class="wby" size="30" />
											<!-- 隐藏字段，用来处理中文路径问题 -->
											<input type="hidden" name="virname" value="<%=String.valueOf(System.currentTimeMillis()) %>"/>
											<c:if test="${message == 'error' }">
										    	<span style="color: red; font-size: 12px;">已经有该相册了</span><br/>
										    </c:if>	
										</td>
									</tr>
									<tr>
										<td align="right" valign="top">
											<font class="word3" style="font-weight: bold;">描述:</font>
										</td>
										<td align="left">
											<textarea class="wbq" name="descript" id="adesc"></textarea>
										</td>
									</tr>
									<tr>
										<td align="right">
											<font class="word3" style="font-weight: bold;">谁能浏览:</font>
										</td>
										<td align="left">
											<select name="people" style="width: 200px">
												<option value="me">只有我自己</option>
												<option value="friends">我的好友</option>
												<option value="samearea">我的好友及所有同网络的人</option>
												<option value="all" selected="selected">所有人</option>
											</select>
										</td>
									</tr>
									<tr>
										<td>
											&nbsp;
										</td>
										<td align="left">
											<input type="submit" class="sub" value="创建相册"
												style="width: 100px" />
											<input type="reset" class="sub" value="取消"
												style="width: 60px" />
										</td>
									</tr>
								</table>
								</form>
							</td>

						</tr>
						<tr>
							<td >
								<img src="/xiaonei/images/front/photo.gif" />
								<font class="word2" > 选择相册
								</font>
							</td>
						</tr>
						<tr>
							<td valign="top"  align="center" style="border-bottom: 1px #D8DFEA solid;">
								<table width="80%" cellpadding="5" cellspacing="5">
								
									<tr>
										<td align="right" width="20%">
											<font class="word3" style="font-weight: bold;">选择相册:</font>
										</td>
										<td align="left">
											<select id="selal" style="width: 200px" >
												<!-- 你的相册有哪些 -->
											</select>
										</td>
									</tr>
									<tr>
										<td>
											&nbsp;
										</td>
										<td align="left">
											<input type="button" class="sub" value="确定"
												style="width: 60px" onclick="addphoto()" />
											<input type="reset" class="sub" value="取消"
												style="width: 60px" />
										</td>
									</tr>
								</table>
							</td>

						</tr>

					</table>
				</td>
				<td valign="top" align="center">
					<img src="/xiaonei/images/front/albumright.jpg" />
				</td>
				</tr>
				</table>
			</div>
		</div>
		<!-- 引入foot.jsp -->
		<jsp:include page="../public/foot.jsp"></jsp:include>
	</body>
</html>
