<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录页面</title>
    <link href="css/style_login.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#sub").click(function () {
                if ($(":input[name='user.username']").val() == "") {
                    alert("用户名不能为空!");
                    return false;
                } else if ($(":input[name='user.password']").val() == "") {
                    alert("密码不能为空!");
                    return false;
                }

            });
        });
    </script>
</head>
<body class="body">
<span class="text">
<img src="images/house.gif" class="logo"></img><span class="logo-big">青鸟租房</span><br/>专业的房屋出租出售平台</span>

<form action="login" method="post">
    <div class="table">
        <div class="header">用户登录</div>
        <hr/>
        <br/><br/>
        <p align="center">
            <label>用户名：</label>
            <input type="text" name="user.username">
        </p>
        <p align="center">
            <label>密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
            <input type="password" name="user.password">
        </p>
        <p align="center">
            <font color="red"><s:fielderror fieldName="u"/></font>
        </p>
        <p class="login_bu" align="center">
            <input type="submit" style="background:#46A3FF;" id="sub" value="   登    录    "> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" style="background:#46A3FF;" name="reg" value="    注     册    "
                   onclick="document.location.href='register.jsp'">
        </p>
    </div>
</form>

<jsp:include page="/jsp/common/indexBottom.jsp"></jsp:include>
</body>
</html>