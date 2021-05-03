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
                    <a class="" href="javascript:;">工作信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/operatorSelectLineListServlet">员工工作流</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/operatorOptionalLineServlet">可选线体</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">操作员通讯录</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/findOperatorByPageServlet">查询操作员</a></dd>
                        <dd hidden id="hidden-update"><a href="#">修改操作员信息</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/addOperatorServlet">增加操作员</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">督导管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/leaderListServlet">查询督导</a></dd>
                        <dd hidden id="hidden-update2"><a href="#">修改督导信息</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/addLeaderServlet">增加督导</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">产品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/cdcListServlet">产品查询</a></dd>
                        <dd><a href="#">产品增加</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">系统管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/notifyServlet">公告发布</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/notifyListServlet">公告列表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/fileServlet">文件发布</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/fileListServlet">文件列表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/adminPasswordIndexServlet">修改密码</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>
