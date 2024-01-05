<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String username = request.getParameter("username");
String password = request.getParameter("password");
String address = "192 Nguyen Luong Bang";
// Truy cập vào DB để kiểm tra username và password xem có đúng hay không

boolean isValid = false;
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/login", "root", "123456789");
    Statement sm = conn.createStatement();
    String sql = "SELECT * FROM login";
    ResultSet rs = sm.executeQuery(sql);
    while (rs.next()) {
        String dbUsername = rs.getString("username");
        String dbPassword = rs.getString("password");
        if (username.equals(dbUsername) && password.equals(dbPassword)) {
            isValid = true;
            break; 
        }
    }
    rs.close();
    sm.close();
    conn.close();
}catch (ClassNotFoundException ex) {
    System.out.println("MySQL JDBC driver not found.");
    ex.printStackTrace();
} catch (SQLException ex) {
    System.out.println("An error occurred while connecting to the database.");
    ex.printStackTrace();
} catch (Exception ex) {
    System.out.println("An unexpected error occurred.");
    ex.printStackTrace();
}

if (isValid) {
    // Đăng nhập thành công và chuyển hướng đến trang welcome
    request.setAttribute("address", address);
    request.getRequestDispatcher("Welcome.jsp").forward(request, response);
} else {
    // Đăng nhập thất bại và chuyển hướng về trang login
    session.setAttribute("errorMessage", "Password or Username invalid!!");
    response.sendRedirect("Login.jsp");
}
%>
</body>
</html>