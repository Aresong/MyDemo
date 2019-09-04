<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>打印申请书</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("[name='printChart']").click(function () {
                window.location = "${pageContext.request.contextPath }/printCtrl/printChart"
            });

            $("[name='printExcel']").click(function () {
                window.location = "${pageContext.request.contextPath }/printCtrl/printExcel"
                alert("表格已保存到E盘根目录下！")
            });
        });
    </script>
</head>
<body>
<p>打印申请书</p>
<a href="${pageContext.request.contextPath }/listCtrl/getState">返回</a>
<hr>
<div align="center">
    <input type="button" name="printChart" value="打印组织机构框图">
    <input type="button" name="printExcel" value="打印申请表">
</div>
</body>
</html>