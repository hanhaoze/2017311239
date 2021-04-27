<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息查询</title>
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
                    <a href="">操作员</a>
                    <a href="">产品信息</a>
                    <a><cite>产品信息查询</cite></a>
                </span>
                <form style="padding-top: 20px;" action="${pageContext.request.contextPath}/findProductByPageServlet" method="post">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label" style="width: auto;">产品号</label>
                            <div class="layui-input-inline">
                                <input type="tel" name="sn" value="${condition.sn[0]}" autocomplete="off" class="layui-input">
                            </div>
                            <label class="layui-form-label" style="width: auto;">上线日期</label>
                            <div class="layui-input-inline">
                                <input type="text" name="date" value="${condition.date[0]}" autocomplete="off" class="layui-input">
                            </div>

                            <div class="layui-input-inline">

                                <button type="submit" class="layui-btn">查询</button>
                            </div>
                        </div>
                    </div>
                </form>


                <table class="layui-table" lay-filter="test">
                    <thead>
                    <tr>
                        <th>产品标识码</th>
                        <th>类型</th>
                        <th>配料信息</th>
                        <th>上线日期</th>
                    </tr>
                    </thead>

                    <c:forEach items="${pb.list}" var="productinfo" varStatus="s">
                        <tr style="height: 70px;">
                            <td>${productinfo.sn}</td>
                            <td>${productinfo.type}</td>
                            <td>${productinfo.main}</td>
                            <td>${productinfo.date}</td>
                        </tr>
                    </c:forEach>
                </table>
                <ul>

                    <c:if test="${pb.currentPage == 1}">
                    <a href ="javascript:return false;">
                        </c:if>
                        <c:if test="${pb.currentPage != 1}">
                        <a href="${pageContext.request.contextPath}/findProductByPageServlet?currentPage=${pb.currentPage-1}&rows=5&s_id=${condition.sn[0]}&s_name=${condition.date[0]}">
                            </c:if>

                            <li class="page-li">上一页</li></a>
                    </a>
                    <c:forEach begin="1" end="${pb.totalPage}" var="i">
                        <c:if test="${pb.currentPage == i}">
                            <a href="${pageContext.request.contextPath}/findProductByPageServlet?currentPage=${i}&rows=5&s_id=${condition.sn[0]}&s_name=${condition.date[0]}"><li class="page-li" style="background-color: #009688;border-radius: 2px;color: white;">${i}</li></a>
                        </c:if>
                        <c:if test="${pb.currentPage != i}">
                            <a href="${pageContext.request.contextPath}/findProductByPageServlet?currentPage=${i}&rows=5&s_id=${condition.sn[0]}&s_name=${condition.date[0]}"><li class="page-li">${i}</li></a>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pb.currentPage == pb.totalPage}">
                    <a href="javascript:return false;">
                        </c:if>
                        <c:if test="${pb.currentPage != pb.totalPage}">
                        <a href="${pageContext.request.contextPath}/findProductByPageServlet?currentPage=${pb.currentPage+1}&rows=5&s_id=${condition.sn[0]}&s_name=${condition.date[0]}">
                            </c:if>
                            <li class="page-li">下一页</li></a>
                </ul>

                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 0px;">
                    <legend>共${pb.totalCount}条记录，共${pb.totalPage}页</legend>
                </fieldset>
                <jsp:include page="/footer.jsp"></jsp:include>
            </div>
        </div>
    </div>


<script type="text/javascript">
    $("#nav li:nth-child(4) dl dd:nth-child(1)").addClass("layui-this");
    $("#nav li:nth-child(4)").addClass("layui-nav-itemed");
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
