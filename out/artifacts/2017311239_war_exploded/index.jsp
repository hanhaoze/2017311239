<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>TITLE</title>
</head>
<body>

<%
  if (session.getAttribute("operator")!=null) {
%>
<jsp:forward page = "/WEB-INF/operator/oIndex.jsp"/>
<%
}else if (session.getAttribute("leader")!=null) {
%>
<jsp:forward page = "/WEB-INF/leader/lIndex.jsp"/>
<%
}else if (session.getAttribute("admin")!=null) {
%>
<jsp:forward page = "/WEB-INF/admin/aIndex.jsp"/>
<%
}else {
%>
<jsp:forward page = "login.jsp" />
<%
  }
%>
</body>
</html>
