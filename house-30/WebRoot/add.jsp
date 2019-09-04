<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/style_add.css" rel="stylesheet" type="text/css"/>
    <title>添加房屋信息</title>
    <script type="text/javascript" src="laydate/laydate.js"></script>
    <style type="text/css">
        .doubleselect br {
            display: none;
        }
    </style>
    <script type="text/javascript" src="../../standard-sm-20/WebRoot/laydate/laydate.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#sub").click(function () {
                if ($(":input[name='house.title']").val() == "") {
                    alert("标题不能为空!");
                    return false;
                } else if ($(":input[name='house.floorage']").val() == "") {
                    alert("房屋面积不能为空!");
                    return false;
                } else if ($(":input[name='house.price']").val() == "") {
                    alert("每平米价格不能为空!");
                    return false;
                } else if ($(":input[name='house.pubdate']").val() == "") {
                    alert("房产证日期不能为空!");
                    return false;
                } else if ($(":input[name='house.contact']").val() == "") {
                    alert("联系方式不能为空!");
                    return false;
                } else if ($(":input[name='house.description']").val() == "") {
                    alert("详细信息不能为空!");
                    return false;
                } else if ($(":input[name='file']").val() == "") {
                    alert("图片不能为空!");
                    return false;
                }
            });
        });
    </script>
</head>
<body>
<h1 align="center">添加房屋信息</h1>
<s:form name="add" action="add" method="post" enctype="multipart/form-data">
    <table width="400" height="550" border="0" align="center" cellpadding="10" cellspacing="2" bgcolor="#ECF5FF">
        <tr>
            <td>＊标题：</td>
            <td><input type="text" name="house.title" id=""></td>
        </tr>
        <tr>
            <td>＊户型:</td>
            <td><s:select theme="simple" name="house.houseType.id" list="houseTypelist" listKey="id"
                          listValue="name"/></td>
        </tr>
        <tr>
            <td>＊面积：</td>
            <td><input type="text" name="house.floorage">平米</td>
        </tr>
        <tr>
            <td>＊价格</td>
            <td><input type="text" name="house.price">元/平米</td>
        </tr>
        <tr>
            <td>＊房产证日期：</td>
            <td><input name="house.pubdate" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
            </td>
        </tr>
        <tr>
            <td>＊位置:</td>
            <td>
                <div class="doubleselect"><s:doubleselect theme="simple" name="house.street.district.id"
                                                          list="districtlist" listKey="id" listValue="name"
                                                          doubleName="house.street.id" doubleList="streetMap.get(id)"
                                                          doubleListKey="id" doubleListValue="name"
                /></div>
            </td>
        </tr>
        <tr>
            <td>＊联系方式：</td>
            <td><input type="text" name="house.contact"></td>
        </tr>
        <tr>
            <td>＊详细信息：</td>
            <td><textarea name="house.description" cols="20" rows="5"></textarea></td>
        </tr>
        <tr>
            <td>＊图片附件：</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" id="sub" value="立即发布">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button" value="  返    回  " onclick="javascript:history.back();"></td>
        </tr>
    </table>
</s:form>
</body>
</html>