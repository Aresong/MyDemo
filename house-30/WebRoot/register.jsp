<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册页面</title>
    <link href="css/style_register.css" rel="stylesheet" type="text/css"/>
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
                } else if ($(":input[name='user.telephone']").val() == "") {
                    alert("联系电话不能为空!");
                    return false;
                }
            });
        });
    </script>
</head>
<body>
<form action="register" method="post">
    <table class="register">
        <tr>
            <td colspan="2" align="center">用户注册
                <hr/>
            </td>
        </tr>
        <tr>
            <td>＊用&nbsp;户&nbsp;名：</td>
            <td><input type="text" name="user.username"/></td>
        </tr>
        <tr>
            <td>＊密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
            <td><input type="password" name="user.password"/></td>
        </tr>
        <tr>
            <td>＊联系电话：</td>
            <td><input type="text" name="user.telephone"/></td>
        </tr>
        <tr>
            <td>真实姓名：</td>
            <td><input type="text" name="user.realname"/></td>
        </tr>
        <tr>
            <td>是否管理员：</td>
            <td><input type="checkbox" name="user.isadmin" value="y"/>是
                <input type="checkbox" name="user.isadmin" checked="checked" value="n"/>否
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" id="sub" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button" value="返回" onclick="document.location.href='login.jsp'"/></td>
        </tr>
    </table>
</form>
</body>
</html>