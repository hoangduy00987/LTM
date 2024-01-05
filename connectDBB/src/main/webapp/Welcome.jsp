<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String username = request.getParameter("username");
String address = (String)request.getAttribute("address");
String temp = (String)session.getAttribute("temp");

%>
Welcome = <%=username %>!<br>
You are Living at = <%=address %><br>
Temp = <%=temp %>
</body>
</html>