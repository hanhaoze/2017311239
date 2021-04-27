<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TITLE</title>
</head>
<body>
<%
    if (session.getAttribute("operator")==null && session.getAttribute("leader")==null && session.getAttribute("admin")==null) {
%>
        <jsp:forward page = "login.jsp"/>
<%
    }
%>

</body>
</html>
