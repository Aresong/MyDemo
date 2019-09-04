<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<s:fielderror/>
<form action="${ pageContext.request.contextPath }/userAction1.action" method="post">
    用户名:<input type="text" name="username"/><br/>
    密码:<input type="password" name="password"><br/>
    年龄:<input type="text" name="age"/><br/>
    生日:<input type="text" name="birthday"/><br/>
    工资:<input type="text" name="salary"/><br/>
    <input type="submit" value="提交">
</form>

<h3>方式二：属性驱动-在页面中提供表达式方式</h3>
<form action="${ pageContext.request.contextPath }/userAction2.action" method="post">
    用户名:<input type="text" name="user.username"/><br/>
    密码:<input type="password" name="user.password"><br/>
    年龄:<input type="text" name="user.age"/><br/>
    生日:<input type="text" name="user.birthday"/><br/>
    工资:<input type="text" name="user.salary"/><br/>
    <input type="submit" value="提交">
</form>

<h3>方式三：模型驱动-模型驱动方式</h3>
<form action="${ pageContext.request.contextPath }/userAction3.action" method="post">
    用户名:<input type="text" name="username"/><br/>
    密码:<input type="password" name="password"><br/>
    年龄:<input type="text" name="age"/><br/>
    生日:<input type="text" name="birthday"/><br/>
    工资:<input type="text" name="salary"/><br/>
    <input type="submit" value="提交">
</form>

</body>
</html>