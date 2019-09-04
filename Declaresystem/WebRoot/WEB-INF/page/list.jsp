<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>流程页</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            /* $.ajax({
                     url:"
            ${pageContext.request.contextPath }/listCtrl/getBaseState",
		  		type:"post",
		  		data:null,
		  		dataType:"json",
		  		success:function(data){
		  		alert(data)
		  			 dealBaseState(data) 
		  		},
		  		error:
		  			function(XMLHttpRequest, textStatus, errorThrown) { 
		  				alert(XMLHttpRequest.status); 
		  				alert(XMLHttpRequest.readyState); 
		  				alert(textStatus);
		  			} 
		 	});
		 	
	 	function dealBaseState(data){
			if("haveno"==data.baseState){
				$('#basic').val('基本情况（未填写）') 
			}
			if("notall"==data.baseState){
				$('#basic').val('基本情况（未完成）') 
			}
			if("all"==data.baseState){
				$('#basic').val('基本情况（已填写）')
			}
		} */
            $("[name='changeInfo']").click(function () {
                window.location = "${pageContext.request.contextPath }/listCtrl/gotoUpdateInfo"
            });

            $("[name='exit']").click(function () {
                alert("已退出！")
                window.location = "${pageContext.request.contextPath }/listCtrl/exit"
            });

            $("[name='basic']").click(function () {
                window.location = "${pageContext.request.contextPath }/register/base"
            });

            $("[name='chart']").click(function () {
                $.ajax({
                    url: "${pageContext.request.contextPath }/listCtrl/checkBaseState",
                    type: "post",
                    data: null,
                    dataType: "json",
                    success: function (data) {
                        dealContinueChart(data)
                    },
                    error:
                        function (XMLHttpRequest, textStatus, errorThrown) {
                            alert(XMLHttpRequest.status);
                            alert(XMLHttpRequest.readyState);
                            alert(textStatus);
                        }
                });

                function dealContinueChart(data) {
                    if (true == data) {
                        window.location = "${pageContext.request.contextPath }/listCtrl/gotoChart"
                    } else {
                        alert("您的企业基本情况未填写或填写不完整，请核对！")
                    }
                }
            });

            $("[name='staff']").click(function () {
                window.location = "${pageContext.request.contextPath }/staffCtrl/getStaffList"
            });

            $("[name='manager']").click(function () {
                window.location = "${pageContext.request.contextPath }/listCtrl/gotoManager"
            });

            $("[name='print']").click(function () {
                window.location = "${pageContext.request.contextPath }/listCtrl/gotoPrint"
            });
        });
    </script>
</head>
<body>
<div align="right">
    <span>当前机构：${sessionScope.enterpriseObject.name}</span>
    <input type="button" value="修改注册信息" name="changeInfo">
    <input type="button" value="退出" name="exit">
    <input type="hidden" value="${sessionScope.enterpriseObject.id }" name="id">
</div>
<table id="1" align="center">
    <tr>
        <td>
            <div align="center"><input type="button" value="基本情况${baseState }" name="basic" id="basic"></div>
        </td>
    </tr>
    <td><span id="BaseState"></span></td>
    <tr>
        <td>
            <div align="center"><img src="${pageContext.request.contextPath}/image/arrow.png"></img></div>
        </td>
    </tr>
    <tr>
        <td>
            <div align="center"><input type="button" value="组织机构框图${chartState }" name="chart"></div>
        </td>
    </tr>
    <tr>
        <td>
            <div align="center"><img src="${pageContext.request.contextPath}/image/arrow.png"></img></div>
        </td>
    </tr>
    <tr>
        <td>
            <div align="center"><input type="button" value="在岗人员情况${totalStaff }" name="staff"></div>
        </td>
    </tr>
    <tr>
        <td>
            <div align="center"><img src="${pageContext.request.contextPath}/image/arrow.png"></img></div>
        </td>
    </tr>
    <tr>
        <td>
            <div align="center"><input type="button" value="企业负责人情况${totalManager }" name="manager"></div>
        </td>
    </tr>
    <tr>
        <td>
            <div align="center"><img src="${pageContext.request.contextPath}/image/arrow.png"></img></div>
        </td>
    </tr>
    <tr>
        <td>
            <div align="center"><input type="button" value="打印申请书" name="print"></div>
        </td>
    </tr>
</table>

</body>
</html>