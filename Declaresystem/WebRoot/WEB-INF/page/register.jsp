<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>企业注册页面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("[name='code']").blur(function () {
                if (null == $("#code").val() || "" == $("#code").val()) {
                    /* alert("登录名不能为空") */
                    $("#codeJudge").html("用户名不能为空");
                } else {
                    $.ajax({
                        url: "${pageContext.request.contextPath}/EnterpriseUser/checkEnterprise",
                        type: "post",
                        data: {code: $("#code").val()},
                        dataType: "json",
                        success: function (data) {
                            dealData(data)
                        },
                        error:
                            function (XMLHttpRequest, textStatus, errorThrown) {
                                alert(XMLHttpRequest.status);
                                alert(XMLHttpRequest.readyState);
                                alert(textStatus);
                            }
                    });

                    function dealData(data) {
                        if (true == data) {
                            $("#codeJudge").html("用户名已存在");
                        } else {
                            $("#codeJudge").html("用户名可以使用");
                        }
                    }
                }
            });

            $("[name='name']").blur(function () {
                if (null == $("#name").val() || "" == $("#name").val()) {
                    $("#nameJudge").html("机构名称不能为空");
                } else {
                    $("#nameJudge").html("");
                }
            });

            $("[name='license']").blur(function () {
                if (null == $("#license").val() || "" == $("#license").val()) {
                    $("#licenseJudge").html("营业许可证不能为空");
                } else {
                    $("#licenseJudge").html("");
                }
            });

            $("[name='password']").blur(function () {
                if (null == $("#password").val() || "" == $("#password").val()) {
                    $("#passwordJudge").html("密码不能为空");
                } else {
                    $("#passwordJudge").html("");
                }
                if ("" != $("#checkPassword").val()) {
                    if ($("#password").val() != $("#checkPassword").val()) {
                        $("#checkPasswordJudge").html("两次密码输入内容不一致");
                    } else {
                        $("#checkPasswordJudge").html("");
                    }
                }
            });

            $("[name='checkPassword']").blur(function () {
                if ("" != $("#password").val()) {
                    if ($("#password").val() != $("#checkPassword").val()) {
                        $("#checkPasswordJudge").html("两次密码输入内容不一致");
                    } else {
                        $("#checkPasswordJudge").html("");
                    }
                }
            });

        });
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/EnterpriseUser/add" method="post">
    <table align="center" border="1" bordercolor="#000000" cellspacing="0" cellpadding="2"
           style="border-collapse:collapse;" bgcolor="#E6E6FA">
        <tr>
            <td align="right">登录名*</td>
            <td><input type="text" name="code" id="code">${codeerr}
                <div id="codeJudge" style="display:inline"></div>
        </tr>
        <tr>
            <td align="right">机构名称*</td>
            <td><input type="text" name="name" id="name">${nameerr}
                <div id="nameJudge" style="display:inline"></div>
        </tr>
        <tr>
            <td align="right">营业许可证*</td>
            <td><input type="text" name="license" id="license">${licenseerr}
                <div id="licenseJudge" style="display:inline"></div>
        </tr>
        <tr>
            <td align="right">密码*</td>
            <td><input type="password" name="password" id="password">${passworderr}
                <div id="passwordJudge" style="display:inline"></div>
        </tr>
        <tr>
            <td align="right">确认密码*</td>
            <td><input type="password" name="checkPassword" id="checkPassword">
                <div id="checkPasswordJudge" style="display:inline"></div>
        </tr>
        <tr>
            <td colspan="2">
                <div>${registerErr}</div>
            </td>
        </tr>
    </table>
    <div align="center"><input type="submit" value="提交"></div>
</form>
</body>
</html>