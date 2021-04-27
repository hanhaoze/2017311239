<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test" id="nav">
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">工作流</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/studentSelectCourseListServlet">选择工作点</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/operatorOptionalLineServlet">可选线体</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">产品信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/findProductByPageServlet">产品信息查询</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">操作员通讯录</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/findOperatorByPageServlet">操作员信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">督导通讯录</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/leaderListServlet">督导信息</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item">
                    <a class="" href="javascript:;">个人信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/operatorInformationServlet">个人信息</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/operatorPasswordIndexServlet">修改密码</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/fileListServlet">文件列表</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
</div>
<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>
</body>
</html>
