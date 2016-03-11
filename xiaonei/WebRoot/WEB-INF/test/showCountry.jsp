<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>显示国家</title>
  </head>
  
  <body>
    <s:iterator value="list" var="ctry">
    	<s:property value="#ctry.name"/><br>
    </s:iterator>
    <s:debug></s:debug>
  </body>
</html>
