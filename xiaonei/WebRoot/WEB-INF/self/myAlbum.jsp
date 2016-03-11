<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<link rel="stylesheet" href="/xiaonei/css/css/updPersonInfo.css" type="text/css"></link>
	</head>
	<body>

		<jsp:include page="head.jsp"></jsp:include>
		<div class="album_main">
			<div class="album_left">
				<table width="80%" style="float: left;" cellspacing="0"
					cellpadding="10">
					<tr>
						<td colspan="2">
							<table width="100%" border="0" cellspacing="5" cellpadding="5">
								<tr>
									<td rowspan="2" width="10%">
										<a href="/xiaonei/profile/homepage.action">
											<c:choose>
												<c:when test="${fn:contains(user.photo, 'default.gif')}">	
													<img src="/xiaonei/images/userhead/default.gif" width="50" height="50" />	
												</c:when>
												<c:otherwise>																			
													<img src="/xiaonei/images/${user.id }/head/${user.photo }" width="50"
													height="50" />
												</c:otherwise>
											</c:choose>
								
										</a>
									</td>
									<td>
										<font class="word2">我的相册</font>
									</td>
								</tr>
								<tr>
									<td>
										<a href="/xiaonei/album/addAlbumUI.action" class="xh">上传新照片</a>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<font class="word4"> 共${albumNum } 个相册</font>
						</td>
						<td align="right">
							<table border="0">
								<tr>
									<td>
										<font class="word2" style="font-size: 12px">第1页</font>
									</td>
									<td>
										<font class="word2" style="font-size: 12px">共1页</font>
									</td>
									<td>
										<a href="album.do?type=album&pageNo=1&oid=xx" class="xh">
											<< 第一页 </a>
									</td>
									<td>
										...
									</td>
									<td>
										<a href="album.do?type=album&pageNo=xx&oid=xx" class="xh">
											< 上一页</a>
									</td>
								</tr>
							</table>
						</td>
					</tr>


					<tr>


						<td width="80%" valign="top" colspan="2"
							style="border-top: 1px #D8DFEA solid; border-bottom: 1px #D8DFEA solid;">
							<table width="100%" border="0" cellspacing="5" cellpadding="5">
								<tr>
									<td class="tblDiv">
										<table width="100%" border="0" cellspacing="3" cellpadding="1">
											<c:if test="${albumList != null }">											
											  <c:forEach var="album" items="${albumList }">
												<tr>
													<td valign="top" width="33%">
														<a href="#">
															<img src="/xiaonei/images/${user.id }/album/${album.virname }/${album.photo}" width="150px"
																height="150px" border="0" /> </a>															
																
													</td>
													<td valign="top">
														<table width="100%" border="0" cellspacing="1"
															cellpadding="1">
															<tr>
																<td>
																	<a href="/xiaonei/album/oneAlbum.action?albumid=${album.id }"
																		class="xh" style="font-weight: bold; font-size: 16px">相册名称：${album.name }
																	</a>
																</td>
															</tr>
															<tr>
																<td>
																	<font class="word3">${fn:length(album.photos) }张照片</font>
																</td>
															</tr>
	
															<tr>
																<td>
																	<font class="word3">${album.descript } </font>
																</td>
															</tr>
	
															<tr>
																<td>
																	<font class="word3">更新于${album.creTime } </font>
																</td>
															</tr>
															<tr>
																<td>
																	<font class="word3">创建于${album.updTime } </font>
																</td>
															</tr>
															<tr>
																<td>
																	<a href="/xiaonei/editAlbum.jsp?aid=xxx" class="xh">编辑相册</a>
																	|
																	<a href="/xiaonei/album/oneAlbum.action?albumid=${album.id }"
																		class="xh">查看相册</a>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											   </c:forEach>								
											</c:if>
											<c:if test="${albumNum == 0 }">	
												您还没有创建相册哦，现在去创建吧~
											</c:if>
										</table>
										
									</td>
								</tr>

							</table>
						</td>

					</tr>
					<tr>
						<td>
							&nbsp;

						</td>
						<td align="right">
							<table>
								<tr>
									<td>
										<font class="word2" style="font-size: 12px">第1页</font>
									</td>
									<td>
										<font class="word2" style="font-size: 12px">共1页</font>
									</td>
									<td>
										<a href="album.do?type=album&pageNo=1&oid=xx" class="xh">
											<< 第一页 </a>
									</td>
									<td>
										...
									</td>
									<td>
										<a href="album.do?type=album&pageNo=xx&oid=xx" class="xh">
											< 上一页</a>
									</td>
								</tr>
							</table>
						</td>
					</tr>

				</table>
				<div
					style="width: 20%; float: left; text-align: center; padding-top: 5px">
					<img src="/xiaonei/images/front/selfright.jpg" />
				</div>
			</div>
		</div>
		<!-- 引入foot.jsp -->
		<jsp:include page="../public/foot.jsp"></jsp:include>
	</body>
</html>
