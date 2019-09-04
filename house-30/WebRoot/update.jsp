<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="laydate/laydate.js"></script>
    <title>修改房屋信息</title>
    <style type="text/css">
        .doubleselect br {
            display: none;
        }
    </style>
</head>
<body>
<s:form id="updatedata" name="updatedata" action="updatedata" method="post" enctype="multipart/form-data">
    <s:hidden name="house.id"></s:hidden>
    <s:hidden name="house.adddate"></s:hidden>
    <h1 align="center">修改房屋信息</h1>
    <table width="400" height="560" border="0" align="center" cellpadding="10" cellspacing="2" bgcolor="#ECF5FF">
        <tr>
            <s:property value="#session.user.id"/>
            <td>标题：</td>
            <td>
                <input type="text" name="house.title" value="${house.title}">
            </td>
        </tr>
        <tr>
            <td>户型:</td>
            <td>
                <s:select theme="simple" name="house.houseType.id"
                          list="houseTypelist" listKey="id" listValue="name"/>
            </td>
        </tr>
        <tr>
            <td>面积：</td>
            <td>
                <input type="text" name="house.floorage" value="${house.floorage}">平米
            </td>
        </tr>
        <tr>
            <td>价格</td>
            <td>
                <input type="text" name="house.price" value="${house.price}">元/平米
            </td>
        </tr>
        <tr>
            <td>房产证日期：</td>
            <td>
                <input name="house.pubdate" value="${house.pubdate}"
                       onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
            </td>
        </tr>
        <tr>
            <td>位置:</td>
            <td>
                <div class="doubleselect">
                    <s:doubleselect theme="simple" name="house.street.district.id"
                                    list="districtlist" listKey="id" listValue="name"
                                    doubleName="house.street.id" doubleList="streetMap.get(id)"
                                    doubleListKey="id" doubleListValue="name"/>
                </div>
            </td>
        </tr>
        <tr>
            <td>联系方式：</td>
            <td>
                <input type="text" name="house.contact" value="${house.contact}">
            </td>
        </tr>
        <tr>
            <td>详细信息：</td>
            <td>
                <textarea name="house.description" cols="20" rows="5">${house.description}</textarea>
            </td>
        </tr>
        <tr>
            <td>显示图片信息：</td>
            <td>
                <s:iterator var="p" value="#session.house.getHousePictures()" status="status">
                    <img src="<s:property value='#p.url'/>" width="190" height="130"/>
                </s:iterator>
            </td>
        </tr>
        <tr>
            <td>修改图片信息：</td>
            <td>
                <input type="file" name="file">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="  保  存  ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button" value="  返    回  " onclick="javascript:history.back();">
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>