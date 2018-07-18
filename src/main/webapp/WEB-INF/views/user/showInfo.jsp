<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="<%=request.getContextPath() %>/resources/jquery/jquery.js"></script>
    <script src="<%=request.getContextPath() %>/resources/jquery/jquery-1.4.2.min.js"></script>

    <title>用户展示</title>
</head>
<body>
姓名： <p><input value="${requestScope}"></p>
姓名： ${modelMap}
<br/>
ajax显示全部用户信息：
<div id="show_all_user"></div>
</body>
<script type="text/javascript">
    $.ajax({
        type : "get",
        url : "user/showAll.htmls",
        dataType : "json",
        success : function(data) {
            $(data).each(
                function(i, user) {
                    var p = "<p>username:" + user.name + "    age:"
                        + user.age + "    uregister:"
                        + user.registerTime + "</p>";
                    $("#show_all_user").append(p);
                });
        },
        async : true
    });
</script>


</html>
