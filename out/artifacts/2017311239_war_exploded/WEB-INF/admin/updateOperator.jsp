<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改学生信息</title>
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
                <a href="">操作员管理</a>
                <a><cite>修改操作员信息</cite></a>
            </span>
            <form class="layui-form" action="${pageContext.request.contextPath}/updateOperatorInfoServlet" style="padding-top: 50px" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">员工号</label>
                    <div class="layui-input-block">
                        <input type="text" readonly="readonly" name="operator-id" value="${operator.s_id}" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="operator-name" id="operator-name" value="${operator.s_name}" placeholder="" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">

                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-block">
                            <input type="radio" name="operator-sex" id="idsex" value="男" title="男">
                            <input type="radio" name="operator-sex" id="idsex2" value="女" title="女">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">年龄</label>
                        <div class="layui-input-block">
                            <input type="text" name="operator-age" id="operator-age" value="${operator.s_age}" placeholder="" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">电话</label>
                        <div class="layui-input-block">
                            <input type="text" name="operator-phone" id="operator-phone" value="${operator.s_phone}" placeholder="" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">邮箱</label>
                        <div class="layui-input-block">
                            <input type="text" name="operator-email" id="operator-email" value="${operator.s_email}" placeholder="" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">城市</label>
                    <div class="layui-input-block">
                        <input type="text" name="operator-address" id="operator-address" value="${operator.s_address}" placeholder="请输入你所在的省市" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">修改</button>
                        <button class="layui-btn layui-btn-primary" id="inforeset">重置</button>
                        <span style="padding-left: 20px;">${update_msg}</span>
                    </div>
                </div>
            </form>
            <jsp:include page="/footer.jsp"></jsp:include>
        </div>
    </div>
</div>


<script type="text/javascript">
    $("#nav li:nth-child(2) dl dd:nth-child(2)").addClass("layui-this");
    $("#nav li:nth-child(2)").addClass("layui-nav-itemed");
    $("#hidden-update").removeAttr("hidden");
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
<script>
    var sex = "${operator.s_sex}";
    if (sex == '男') {
        $("#idsex").attr("checked","checked");
        $("#idsex2").removeAttr("checked");
    } else if (sex == '女') {
        $("#idsex2").attr("checked","checked");
        $("#idsex").removeAttr("checked");
    }else{
        $("#idsex").removeAttr("checked");
        $("#idsex2").removeAttr("checked");
    }
</script>
<script type="text/javascript">
    $(function () {
        $('#inforeset').bind('click',function () {
            $("#idsex").removeAttr("checked");
            $("#idsex2").removeAttr("checked");
            $("#operator-name").val("");
            $("#operator-age").val("");
            $("#operator-phone").val("");
            $("#operator-email").val("");
            $("#operator-address").val("");
            alert("已重置！");
        });


    });
</script>

</body>
</html>


