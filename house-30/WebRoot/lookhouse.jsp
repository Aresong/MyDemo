<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查看房屋明细</title>
    <style type="text/css">
        .doubleselect br {
            display: none;
        }
    </style>
</head>
<body>
<h1 align="center">查看房屋详细信息</h1>
<s:hidden name="house.id"></s:hidden>
<s:hidden name="house.user.id"></s:hidden>
<table width="400" height="405" border="0" align="center" cellpadding="10" cellspacing="2" bgcolor="#ECF5FF">
    <tr>
        <td>标题：</td>
        <td><s:property value="#session.house.title"/></td>
    </tr>
    <tr>
        <td>户型:</td>
        <td><s:property value="#session.house.houseType.name"/></td>
    </tr>
    <tr>
        <td>面积：</td>
        <td><s:property value="#session.house.floorage"/>平米</td>
    </tr>
    <tr>
        <td>价格</td>
        <td><s:property value="#session.house.price"/>元/平米</td>
    </tr>
    <tr>
        <td>房产证日期：</td>
        <td><s:property value="#session.house.pubdate"/></td>
    </tr>
    <tr>
        <td>位置:</td>
        <td><s:property value="#session.house.street.district.name"/>区 <s:property
                value="#session.house.street.name"/></td>
    </tr>
    <tr>
        <td>联系方式：</td>
        <td><s:property value="#session.house.contact"/></td>
    </tr>
    <tr>
        <td>详细信息：</td>
        <td><s:property value="#session.house.description"/></td>
    </tr>
    <tr>
        <td>图片：</td>
        <td>
            <s:iterator var="p" value="#session.house.getHousePictures()" status="status">
                <img src="<s:property value='#p.url'/>" width="190" height="130"/>
            </s:iterator>
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="button" value="  返    回  " onclick="javascript:history.back();">
        </td>
    </tr>
</table>
</body>
</html>