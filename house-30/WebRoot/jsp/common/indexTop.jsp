<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<span class="text">
		<img src="images/house.gif" class="logo"></img><span class="logo-big">青鸟租房</span><br/>
		专业的房屋出租出售平台 &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		[<span class="welcome" style="color: red;"><s:property value="#session._user.username"/></span>]:欢迎登录青鸟租房网！
		<span class="top-r">
			<input type="button" style="font-size:25px; background-color:green;color:white;" value="发布房屋信息 "
                   onclick="document.location.href='houseTypeShow'"/>
			<input type="button" style="font-size:25px; background-color:green;color:white;" value="  退  出 "
                   onclick="document.location.href='login.jsp'"/>
		</span>
	</span>
<br/>
<br/>


	
