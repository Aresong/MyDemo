<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>选取企业负责人</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("[name='saveJob']").click(function () {
                var val = $('input:radio[name="select"]:checked').val();
                var re_job = $("[name='re_job']").val()
                if (val == null) {
                    alert("您未选择要分配职务的员工！");
                    return false;
                } else {
                    if (0 == re_job) {
                        alert("您未选取要分配给该员工的职务！")
                        return false;
                    } else {
                        $("#pe_id").val(val)
                        $("#updateJobForm").submit()
                        alert("分配职务成功！")
                    }
                }
            });
        });
    </script>

</head>
<body>
<table align="center" border="1" bordercolor="#000000" cellspacing="0" cellpadding="2" style="border-collapse:collapse;"
       bgcolor="#E6E6FA">
    <tr>
        <td colspan="9" height=1>
            <form action="${pageContext.request.contextPath}/ManagerCtrl/managerChoice" method="post">
                人员搜索：姓名<input type="text" name="personName"/>
                身份证号<input type="text" name="personId"/>
                <input type="submit" name="search" value="搜索">
                <a href="${pageContext.request.contextPath}/ManagerCtrl/getStaffList">返回</a>
            </form>
        </td>
    </tr>

    <tr>
        <td align="center" width="50" height=1>选取</td>
        <td align="center" width="130" height=1>姓名</td>
        <td align="center" width="50" height=1>性别</td>
        <td align="center" width="130" height=1>出生日期</td>
        <td align="center" width="130" height=1>专业</td>
        <td align="center" width="130" height=1>学历</td>
        <td align="center" width="130" height=1>职称</td>
        <td align="center" width="130" height=1>职务</td>
        <td align="center" width="130" height=1>任职部门</td>
    </tr>
    <c:forEach var="itm" items="${list }">
        <tr>
            <td align="center"><!-- <input type="radio" name="select"> -->
                <input type="radio" name="select" value="${itm.pe_id }"/>
            </td>
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
            <td align="center">${itm.dd4.name }</td>
            <td align="center">${itm.relation.re_dept }</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="9">
            <form action="${pageContext.request.contextPath}/ManagerCtrl/updateJob" method="post" id="updateJobForm">
                分配职务：<select name="re_job">
                <option value="0">-请选择-
                <option value="14">科长
                <option value="15">处长
                <option value="16">局长
            </select>
                <input type="hidden" name="pe_id" id="pe_id">
                <input type="button" value="保存" name="saveJob">
            </form>
        </td>
    </tr>
</table>

</body>
</html>