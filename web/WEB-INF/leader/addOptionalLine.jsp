<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加课程</title>
    <link rel="stylesheet" href="../../css/layui.css">
    <link rel="stylesheet" href="../../css/style.css">
    <script src="../../layui.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<body class="layui-layout-body" style="background-color: #F2F2F2">
<jsp:include page="/filterLogin.jsp"></jsp:include>
<jsp:include page="/WEB-INF/leader/lHeader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/leader/leaderNav.jsp"></jsp:include>
<div class="layui-layout layui-layout-admin">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <span class="layui-breadcrumb">
                <a href="">督导</a>
                <a href="">线体信息</a>
                <a><cite>添加线体</cite></a>
            </span>
            <form class="layui-form" action="${pageContext.request.contextPath}/addOptionalLineServlet" style="padding-top: 50px" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">线体号</label>
                    <div class="layui-input-block">
                        <input type="text" name="cid" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">线体名</label>
                    <div class="layui-input-block">
                        <input type="text" name="line-name" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">线体信息</label>
                    <div class="layui-input-block">
                        <input type="text" name="line-info" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
                        <span style="padding-left: 20px;">${update_msg}</span>
                    </div>
                </div>
            </form>
            <jsp:include page="/footer.jsp"></jsp:include>
        </div>
    </div>
</div>


<script type="text/javascript">
    $("#nav li:nth-child(1) dl dd:nth-child(4)").addClass("layui-this");
    $("#nav li:nth-child(1)").addClass("layui-nav-itemed");
</script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>

<script>
    //Demo
    layui.use('form', function(){

    });
</script>

</body>
</html>