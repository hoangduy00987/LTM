<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
<style>

body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
}

header {
    background-color: #333;
    color: #fff;
    padding: 10px;
}

nav ul {
    margin: 0;
    padding: 0;
    list-style: none;
}

nav ul li {
    display: inline-block;
}

nav ul li a {
    color: #fff;
    text-decoration: none;
    padding: 10px;
}

.container {
    max-width: 800px;
    margin: 20px auto;
    padding: 20px;
    background-color: #f4f4f4;
    border: 1px solid #ccc;
}

.header {
    text-align: center;
    margin-bottom: 20px;
}

.main {
    text-align: center;
}

.submain {
    display: inline-block;
    padding: 20px;
    background-color: #fff;
    border: 1px solid #ccc;
}

.button {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.button i {
    font-size: 48px;
    margin-bottom: 10px;
}

.button input[type="file"] {
    display: none;
}

.button label {
    background-color: #333;
    color: #fff;
    padding: 10px 20px;
    cursor: pointer;
}

.button .submit {
    margin-top: 10px;
    background-color: #333;
    color: #fff;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
}

.button .submit:hover {
    background-color: #555;
}

</style>
<script src="https://kit.fontawesome.com/410b195647.js" crossorigin="anonymous"></script>
</head>
<body>

<header>
	<nav>
		<ul class="nav_link">
			<li><a href="Login.jsp">Log out</a></li>
		</ul>
	</nav>
</header>

<div class="container">
	<div class="header">
		<h2>Chuyển file .doc qua PDF</h2>
	</div>
	<div class="main">
		<div class="submain">
			<form action="UploadFileServlet" class="button" method="POST" enctype="multipart/form-data">
				<i class="far fa-copy"></i>
				<input type="file" id="file"  accept=".pdf" name ="file">
				<label for="file">Select File</label>
				<input  class="submit" type="submit" value="Send">
				
			</form>
		</div>
	</div>
	
</div>

</body>
</html>
