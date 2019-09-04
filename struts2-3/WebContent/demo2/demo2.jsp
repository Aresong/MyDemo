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
<h1>%号的用法</h1>
<%
    request.setAttribute("name", "王东");
%>
姓名：<input type="text" name="name" value='<s:property value="#request.name"/>'><br/>
姓名：<s:textfield name="name" value="%{#request.name}"/>强制解析<br/>
<s:property value="%{'#request.name'}"/>强制不解析
</body>
</html>