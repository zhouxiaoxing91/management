<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script src="${ctx}/static/js/jquery.min.js"></script>
<%--<script src="../static/js/jquery.form.js"></script>--%>
<%--<script src="../static/js/jquery.1.11.3.min.js"></script>--%>
<script src="${ctx}/static/js/layer.js"></script>
<%--<script src="../static/js/layer/bootstrap.js"></script>--%>
<%--<link href="../static/css/bootstrap.css" rel="stylesheet">--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
登录界面
用户名：<input type="text" id="userId" placeholder="用户名"/>
密码：<input type="password" id="password" placeholder="密码"/>
<input type="button" value="提交" onclick="login()"/>


<script>
    function login() {
        var userId = $("#userId").val() ;
        var password = $("#password").val() ;

        if(password==null || userId==null ||
            password=="" || userId==""){
            layer.alert('用户名或者密码缺失' , {
                time: 4000          // 等待时间
            });
            return ;
        }

        $.ajax({
            type:'post',
            dataType: 'json',
            url:'${ctx}/login/in',
            data:{"userId" :userId, "password": password},
            error:function(data){
                layer.msg("接口异常，请检查", {time: 2000 });
            },
            success:function(data){
                window.location.href="/basic/index";
            }
        });

    }

</script>

</body>
</html>
