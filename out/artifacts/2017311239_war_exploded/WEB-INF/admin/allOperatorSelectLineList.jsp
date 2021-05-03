<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>选课列表</title>
    <link rel="stylesheet" href="../../css/layui.css">
    <link rel="stylesheet" href="../../css/style.css">
    <script src="../../layui.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<body class="layui-layout-body" style="background-color: #F2F2F2">
<jsp:include page="/filterLogin.jsp"></jsp:include>
<jsp:include page="/WEB-INF/admin/aHeader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/admin/adminNav.jsp"></jsp:include>
<div class="layui-layout layui-layout-admin">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
                <span class="layui-breadcrumb">
                    <a href="">管理员</a>
                    <a href="">选课信息管理</a>
                    <a><cite>选课列表</cite></a>
                </span>
            <table class="layui-table" lay-filter="test">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>员工号</th>
                    <th>操作员姓名</th>
                    <th>线体ID</th>
                    <th>线体名称</th>
                    <th>线体简介</th>
                    <th>督导ID</th>
                    <th>督导</th>
                </tr>
                </thead>

                <c:forEach items="${selectlines}" var="selectline" varStatus="s">
                    <tr>
                        <td>${s.count}</td>
                        <td>${selectline.s_id}</td>
                        <td>${selectline.s_name}</td>
                        <td>${selectline.c_id}</td>
                        <td>${selectline.c_name}</td>
                        <td>${selectline.c_info}</td>
                        <td>${selectline.t_id}</td>
                        <td>${selectline.t_name}</td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="/footer.jsp"></jsp:include>
        </div>
    </div>
</div>


<script type="text/javascript">
    $("#nav li:nth-child(1) dl dd:nth-child(1)").addClass("layui-this");
    $("#nav li:nth-child(1)").addClass("layui-nav-itemed");
</script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>

</body>
</html>

