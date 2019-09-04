<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- JSTL标签的核心库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- JSTL标签的时间格式处理 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>显示信息页</title>
    <script type="text/javascript">
        function update(id) {
            window.location.href = "update?house.id=" + id;

        }

        function deletedate(id) {
            var msg = "您真的确定要删除吗？\y\n请确认！";
            if (confirm(msg) == true) {
                window.location.href = "deletedata?house.id=" + id;
                return true;
            } else {
                return false;
            }
        }

        function page_nav(pagestart) {
            window.location.href = "show?pageSupport.pagestart=" + pagestart;
        }

    </script>
</head>
<body>
<s:debug></s:debug>

<s:iterator var="houseList" value="#session.houseList" status="status">


    <table>
        <tr>
            <td rowspan="3" style="border:1px solid red;border-color:red;">
                <s:iterator var="p" value="#houseList.housePictures" status="status">
                    <s:if test='#p.url!=null and #p.url!=""'>
                        <img src="<s:property value='#p.url'/>" width="90" height="60"/>
                    </s:if>
                    <s:else>
                        <img src="images/noPictures.gif" width="90" height="60"/>
                    </s:else>
                </s:iterator>

            </td>
            <td>
                <s:property value="#status.count"/>:
                <s:url action="lookhouse" var="lookhouseURL">
                    <s:param name="house.id" value="#houseList.id"></s:param>
                </s:url>
                <s:a href="%{lookhouseURL}"><s:property value="#houseList.title"/></s:a>
            </td>
        </tr>
        <tr>
            <td>
                <s:property value="street.district.name"/>区
                <s:property value="#houseList.street.name"/>&nbsp;&nbsp;
                面积:<s:property value="#houseList.floorage"/>平米
            </td>
        </tr>
        <tr>
            <td>联系方式：<s:property value="#houseList.contact"/></td>
        </tr>
    </table>

    <div align="right">

        <input type="button" name="house.id" id="#houseList.id" value="修    改"
               onclick="update(<s:property value="#houseList.id"/>)"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" name="house.id" id="#houseList.id" value="删    除"
               onclick="javascript:return deletedate(<s:property value="#houseList.id"/>)"/>
    </div>
    <hr/>
</s:iterator>
<div align="right">
    共<label id="totalCount"><s:property value="#session.pageSupport.totalcount"/></label>条数据 &nbsp;&nbsp;
    <a id="firstPage" href="javascript:page_nav(1)">首页</a>
    <a id="prePage" href="javascript:page_nav(<s:property value="#session.pageSupport.pagestart-1"/>)">上一页</a>
    <a id="nextPage" href="javascript:page_nav(<s:property value="#session.pageSupport.pagestart+1"/>)">下一页</a>
    <a id="lastPage" href="javascript:page_nav(<s:property value="#session.pageSupport.totalpage"/>)">末页</a>
    第<label id="pagestart"><s:property value="#session.pageSupport.pagestart"/></label>页/共
    <label id="totalpage"><s:property value="#session.pageSupport.totalpage"/></label>页
</div>
</body>
</html>