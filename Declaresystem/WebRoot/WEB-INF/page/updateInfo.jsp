<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改企业注册信息</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("[name='save']").click(function () {
                var name = $("[name='name']").val();
                var license = $("[name='license']").val();
                var password = $("[name='password']").val();
                var checkPassword = $("[name='checkPassword']").val();
                if ("" == name) {
                    alert("机构名不能为空！")
                } else if ("" == license) {
                    alert("营业许可证不能为空！")
                } else if ("" == password) {
                    alert("密码不能为空！")
                } else if ("" == checkPassword) {
                    alert("请确认您的密码！")
                } else {
                    $("#updateForm").submit();
                    alert("修改成功")
                }
            });
        });
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath }/listCtrl/updateInfo" method="post" id="updateForm">
    <div align="center">
        <table align="center" border="1" bordercolor="#000000" cellspacing="0" cellpadding="2"
               style="border-collapse:collapse;" bgcolor="#E6E6FA">
            <tr>
                <td align="right">机构名称*</td>
                <td><input type="text" name="name" id="name" value="${enterprise.name }">
                    <div id="nameJudge" style="display:inline"></div>
            </tr>
            <tr>
                <td align="right">营业许可证*</td>
                <td><input type="text" name="license" id="license" value="${enterprise.license }">
                    <div id="licenseJudge" style="display:inline"></div>
            </tr>
            <tr>
                <td align="right">密码*</td>
                <td><input type="text" name="password" id="password" value="${enterprise.password }">
                    <div id="passwordJudge" style="display:inline"></div>
            </tr>
        </table>
    </div>
    <div align="center"><input type="button" name="save" value="保存"></div>
</form>
</body>
</html>