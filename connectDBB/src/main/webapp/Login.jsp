<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  
String temp = "temp";
session.setAttribute("temp", temp);
%>

<form name = "form1" action= "CheckLogin.jsp" method = "post">
Username: <input type = "text" name = "username"><br/>
Username: <input type = "password" name = "password"><br/>
 <input type = "submit" value="Login">
 <input type = "reset" value= "Reset">

</form>
<%
String errorMessage = (String) session.getAttribute("errorMessage");
if (errorMessage != null) {
%>
    <div class="error-message">
        <%= errorMessage %>
    </div>
<%
    // Xóa thông báo lỗi khỏi session sau khi hiển thị
    session.removeAttribute("errorMessage");
}
%>
</body>
</html>