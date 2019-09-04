<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新增人员信息</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("[name='save']").click(function () {
                var pe_name = $("[name='pe_name']").val();
                var pe_sex = $("[name='pe_sex']").val();
                var pe_birthday = $("[name='pe_birthday']").val();
                var pe_school = $("[name='pe_school']").val();
                var pe_professional = $("[name='pe_professional']").val();
                var pe_record = $("[name='pe_record']").val();
                var pe_finish_school = $("[name='pe_finish_school']").val();
                var pe_cardid = $("[name='pe_cardid']").val();
                var pe_technical = $("[name='pe_technical']").val();
                var pe_assess_date = $("[name='pe_assess_date']").val();
                var pe_address = $("[name='pe_address']").val();
                var pe_tel = $("[name='pe_tel']").val();
                var pe_speciality = $("[name='pe_speciality']").val();
                if ("" == pe_name) {
                    alert("人员姓名不能为空！")
                } else if ("" == pe_sex) {
                    alert("性别不能为空！")
                } else if ("" == pe_birthday) {
                    alert("出生日期不能为空！")
                } else if ("" == pe_school) {
                    alert("毕业学校不能为空！")
                } else if ("" == pe_professional) {
                    alert("专业不能为空！")
                } else if ("" == pe_record) {
                    alert("学历不能为空！")
                } else if ("" == pe_finish_school) {
                    alert("毕业日期不能为空！")
                } else if ("" == pe_cardid) {
                    alert("身份证号不能为空！")
                } else if ("" == pe_technical) {
                    alert("技术职称不能为空！")
                } else if ("" == pe_assess_date) {
                    alert("评定日期不能为空！")
                } else if ("" == pe_address) {
                    alert("通信地址不能为空！")
                } else if ("" == pe_tel) {
                    alert("联系电话不能为空！")
                } else {
                    $("#addPersonForm").submit();
                    alert("保存成功！")
                }
            });
            $("[name='goBack']").click(function () {
                window.location = "${pageContext.request.contextPath }/staffCtrl/getOtherStaff"
            });
        });
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath }/staffCtrl/addPerson" method="post" id="addPersonForm">
    <div align="center">人员信息</div>
    <table align="center" border="1" bordercolor="#000000" cellspacing="0" cellpadding="2"
           style="border-collapse:collapse;" bgcolor="#E6E6FA">
        <tr>
            <td align="right">人员姓名：</td>
            <td><input type="text" name="pe_name"/></td>
            <td align="right">性别：</td>
            <td>
                <input type="radio" value="1" name="pe_sex"/>男
                <input type="radio" value="0" name="pe_sex"/>女
            </td>
        </tr>
        <tr>
            <td align="right">出生日期：</td>
            <td><input type="text" name="pe_birthday" onclick="WdatePicker()"/></td>
            <td align="right">毕业学校：</td>
            <td><input type="text" name="pe_school"/></td>
        </tr>
        <tr>
            <td align="right">专业：</td>
            <td>
                <select name="pe_professional">
                    <option value="17">计算机
                    <option value="18">软件工程
                </select>
            </td>
            <td align="right">学历：</td>
            <td>
                <select name="pe_record">
                    <option value="7">高中</option>
                    <option value="8">大专</option>
                    <option value="9">本科</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right">毕业日期：</td>
            <td><input type="text" name="pe_finish_school" onclick="WdatePicker()"/></td>
            <td align="right">身份证号：</td>
            <td><input type="text" name="pe_cardid"/></td>
        </tr>
        <tr>
            <td align="right">技术职称：</td>
            <td>
                <select name="pe_technical">
                    <option value="10">助理工程师</option>
                    <option value="11">工程师</option>
                    <option value="12">高级工程师</option>
                </select>
            </td>
            <td align="right">评定日期：</td>
            <td><input type="text" name="pe_assess_date" onclick="WdatePicker()"/></td>

        </tr>
        <tr>
            <td align="right">通信地址：</td>
            <td><input type="text" name="pe_address"/></td>
            <td align="right">联系电话：</td>
            <td><input type="text" name="pe_tel"/></td>
        </tr>
        <tr>
            <td align="right">业务专长：</td>
            <td colspan="3" align="center">
                <textarea name="pe_speciality" cols="60" rows="10"></textarea>
            </td>
        </tr>
    </table>
    <div align="center">
        <input type="button" name="save" value="保存">
        <input type="button" name="goBack" value="返回">
    </div>
</form>
</body>
</html>