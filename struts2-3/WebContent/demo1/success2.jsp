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
<h1>查看值栈的内部结构</h1>
<s:debug></s:debug>

<!-- 获取一个对象的数据 -->
<s:property value="name"/><br/>
<s:property value="password"/><br/>

<!-- 获取集合当中的数据 -->
<s:property value="list[0].name"/><br/>
<s:property value="list[0].password"/><br/>
<s:property value="list[1].name"/><br/>
<s:property value="list[1].password"/><br/>
<s:property value="list[2].name"/><br/>
<s:property value="list[2].password"/><br/>

<!-- 获取context中的数据 -->
<s:property value="#request.username"/><br/>
<s:property value="#session.username"/><br/>
<s:property value="#application.username"/><br/>
<s:property value="#attr.username"/><br/>
<s:property value="#parameters.id"/><br/><!-- xxx.action?id=1 -->

<!-- 因为struts2的框架的底层对request.getAttribute(String name)的增强 -->
EL表达式：${list[2].name }
</body>
</html>