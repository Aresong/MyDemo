<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>组织机构框图页面</title>
</head>
<body>
<h1 align="center">组织机构框图</h1>
<hr>
<c:if test="${null!=chartName }">
    <div align="center"><img src="${pageContext.request.contextPath}/upload/${chartName }"></div>
</c:if>

</body>
</html>