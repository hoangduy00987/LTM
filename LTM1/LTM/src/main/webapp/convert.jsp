<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hồ sơ</title>

<link href="View/CSS/UserProfileStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
	<nav>
		<ul class="nav_link">
			<li><a href="HomePage.jsp">Trang chủ</a></li>
			<li><a href="HomePage.jsp">Hỗ trợ</a></li>
			<li><a href="Login.jsp">Logout</a></li>
		</ul>
	</nav>
</header>

<div class="Wrapper">
	<div class="left">
		<img src="img/default-profile-icon-24.jpg" alt="user" width="100">
		<h4>Hùng Nguyễn</h4>
		<p>UI Developer</p>
	</div>
	<div class="right">
		<div class="info">
			<h3>Thông tin cá nhân</h3>
			<div class="info_data">
				<div class="data">
					<h4>Email</h4>
					<p>tuannguyen.300501@gmail.com</p>
				</div>
				<div class="data">
					<h4>Điện thoại</h4>
					<p>0001-234-999842</p>
				</div>
			</div>
		</div>
		<div class="projects">
			<h3>Projects</h3>
			<table>
				<thead>
					<tr>
						<td class="id"><b>ID</b></td>
						<td class="name"><b>File name</b></td>
						<td class="download"><b>Download</b></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>[ID]</td>
						<td>[File name]</td>
						<td>[Download]</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

</body>
</html>
