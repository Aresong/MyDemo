<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>success页面</title>
</head>
<body>
<h1>查看值栈的内部结构</h1>
<s:debug></s:debug>
<!-- 获取方式1：利用Action在值栈中的特性 -->
<s:property value="user.name"/>
<s:property value="user.password"/>
</body>
</html>