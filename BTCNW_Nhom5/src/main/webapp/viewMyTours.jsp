<%@page import="Model.BEAN.User"%>
<%@page import="Model.BEAN.Booking"%>
<%@page import="Model.BEAN.Tour"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trang Thông Tin</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

<!-- custom css file link -->
<link rel="stylesheet" type="text/css" href="./View/CSS/style.css">

</head>
<body>
	<%
	String username = (String) session.getAttribute("username");
	session.setAttribute("username", username);
	%>
	<header class="header">
		<section class="section">
			<div class="introduce">
				<img class="logo-page" src="./View/icon/Logo.png">
				<h1 class="title-page">
					<span class="large-text">Đề tài quản lí tour du lịch</span> <span
						class="small-text">
						<h3 class="info-contact">
							Tel: 036 520 5808&nbsp;&nbsp;-&nbsp;&nbsp;088 915 9648<br>
							Email: nguyenthanhhung26102003@gmail.com
						</h3>
					</span>
				</h1>
			</div>

			<div class="list-item">
				<ul class="item">
				<li><a href="MyTours">Welcome: <%=session.getAttribute("username") %></a></li>
					<li><a >TRANG CHỦ</a></li>
					
					<li><a href="Login.jsp">Log out</a></li>
				</ul>
			</div>

			<%
			ArrayList<Booking> bookingArray = (ArrayList<Booking>)request.getAttribute("bookingArray");
			ArrayList<Tour> myTourArray = (ArrayList<Tour>)request.getAttribute("myTourArray");
			%>
			<div>
				<table border=1 width=100%>
					<caption>My Tours</caption>
					<tr>
						<th>STT</th>
						<th>Tour</th>
						<th>Date Booking</th>
						<th>Number of Participants</th>
						<th>Options</th>
					</tr>
					<tr>
					<% for (int i=0; i<bookingArray.size(); i++) { %>
						<td align="center"><%= i+1 %></td>
						<td align="center"><%=myTourArray.get(i).getLocation() %></td>
						<td align="center"><%=bookingArray.get(i).getBooking_date() %></td>
						<td align="center"><%=bookingArray.get(i).getNum_participants() %></td>
						<td align="center"><a href="UpdateBooking?bookingId=<%=bookingArray.get(i).getBooking_id()%>"><button>Gia hạn</button></a>
						<a href="CancelTour?bookingId=<%=bookingArray.get(i).getBooking_id()%>"><button>Hủy</button></a>
						<a href="getBill?booking=<%=bookingArray.get(i).getBooking_id()%>"><button>Xem Bill</button></a>
						</td>
				
			
					</td>
					</tr>
					<% } %>
				</table>
			</div>
			
		</section>
		<div style="padding-left: 700px;">
      <button style="background-color: lightgrey;" onclick="window.history.back()">Quay lại</button>
    </div>
	</header>
<script src="./View/JS/script.js"></script>
</body>
</html>