<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>#号的用法</h1>
<h3>获取context的数据</h3>
<%
    request.setAttribute("name", "李冰");
%>
<s:property value="#request.name"/>

<h3>构建map集合</h3>
<s:iterator var="i" value="{'aa','bb','cc'}">
    <s:property value="#i"/>--<s:property value="#i"/><br/>
</s:iterator>

<s:iterator var="entry" value="#{'aa':'11','bb':'22','cc':'33'}">
    <s:property value="key"/>--<s:property value="value"/><br/>
    <s:property value="#entry.key"/>--<s:property value="#entry.value"/><br/>
</s:iterator>
<hr>
<h3>传统的：</h3><br/>
性别<input type="radio" name="sex" value="1">男
<input type="radio" name="sex" value="2">女<br/>
<h3>ognl的：</h3><br/>
<span>传统的value和外面显示的文字一样则是list集合，不一样map</span><br/>
<s:radio list="#{'1':'男','2':'女'}" name="sex1" label="性别"/><br/>
<s:radio list="{'男','女'}" name="sex1" label="性别"/>
</body>
</html>