<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>在岗人员情况</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        function page_nav(frm, index) {
            var obj = document.getElementById("index");
            obj.value = index;
            frm.submit();
        }

        $(document).ready(function () {
            $("[name='choice']").click(function () {
                window.location = "${pageContext.request.contextPath}/ManagerCtrl/managerChoice"
            });
        });

        function cancelManager(frm, id) {
            if (confirm("确定注销该管理者么？")) {
                document.getElementById("deleteId").value = id
                frm.submit();
                alert("注销成功！")
            }
        }


    </script>
</head>
<body>
<span>企业负责人情况</span>
<a href="${pageContext.request.contextPath}/listCtrl/getState">返回</a><br>
<input type="button" value="选取" name="choice"/>
<hr>
<form action="${pageContext.request.contextPath}/ManagerCtrl/getStaffList" id="searchForm" name="searchForm"
      method="post">
    <input type="hidden" name="index" id="index">
</form>
<form action="${pageContext.request.contextPath}/ManagerCtrl/deleteRelation" id="cancelForm" method="post">
    <input type="hidden" name="deleteId" id="deleteId">
</form>
<table align="center" border="1" bordercolor="#000000" cellspacing="0" cellpadding="2" style="border-collapse:collapse;"
       bgcolor="#E6E6FA">
    <tr>
        <td align="center" width="50" height=1>序号</td>
        <td align="center" width="130" height=1>姓名</td>
        <td align="center" width="50" height=1>性别</td>
        <td align="center" width="130" height=1>出生日期</td>
        <td align="center" width="130" height=1>学历</td>
        <td align="center" width="130" height=1>专业</td>
        <td align="center" width="130" height=1>职称</td>
        <td align="center" width="130" height=1>任职部门</td>
        <td align="center" width="80" height=1>职务</td>
        <td align="center" width="50" height=1>操作</td>
    </tr>
    <c:forEach var="itm" items="${list }" varStatus="status">
        <tr>
            <td align="center">${status.index+1 }</td>
            <td align="center">${itm.pe_name }</td>
            <td align="center">
                <c:choose>
                    <c:when test="${itm.pe_sex==0 }">女</c:when>
                    <c:otherwise>男</c:otherwise>
                </c:choose>
            </td>
            <td align="center"><fmt:formatDate value="${itm.pe_birthday }" type="date" dateStyle="default"/></td>
            <td align="center">${itm.dd1.name }</td>
            <td align="center">${itm.dd2.name }</td>
            <td align="center">${itm.dd3.name }</td>
            <td align="center">${itm.relation.re_dept }</td>
            <td align="center">${itm.dd4.name }</td>
            <td align="center">
                <a href="javascript:cancelManager(document.getElementById('cancelForm'),${itm.pe_id })"
                   name="delete">注销</a>
            </td>
        </tr>
    </c:forEach>
    <tr bgcolor="#F5FFFA">
        <td colspan="10">
            <div align="right">
                <a href="javascript:page_nav(document.getElementById('searchForm'),1)">首页</a><strong>|</strong>
                <a href="javascript:page_nav(document.getElementById('searchForm'),${currentPageIndex-1})">上一页</a><strong>|</strong>
                <a href="javascript:page_nav(document.getElementById('searchForm'),${currentPageIndex+1})">下一页</a><strong>|</strong>
                <a href="javascript:page_nav(document.getElementById('searchForm'),${totalPage})">尾页</a><strong>|</strong>
                共${totalCount}条数据，第${currentPageIndex}页,共${totalPage}页
            </div>
        </td>
    </tr>
</table>

</body>
</html>