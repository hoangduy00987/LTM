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
	<header class="header">
        <section class="section">
            <div class="introduce">
                <img class="logo-page" src="./View/icon/Logo.png">
                <h1 class="title-page">
                    <span class="large-text">Đề tài quản lí tour du lịch</span>
                    <span class="small-text">
                        <h3 class="info-contact">
                            Tel: 036 520 5808&nbsp;&nbsp;-&nbsp;&nbsp;088 915 9648<br>
                            Email: nguyenthanhhung26102003@gmail.com
                        </h3>
                    </span>
                </h1>                
            </div>
            <div class="list-item">
                <ul class="item">
                   <li><a>Welcome: <%=session.getAttribute("username")%></a></li>
                    <li><a >TRANG CHỦ</a></li>

                     <li><a href="getAllBookingServlet">TOUR ĐÃ ĐẶT</a></li>
                    <li> <a href="Login.jsp">Log out</a></li>
                </ul>
            </div>
        
            <div class="slideshow-container" id="slide-container"></div>
        
            <div class="title-tour">
                Travel Tour
            </div>
            <a href="addTour.jsp" style="text-decoration: none;">
             <button style="padding: 10px 20px; font-size: 30px; display: flex; align-items: center;">
             <img src="./View/icon/plus.png" alt="Thêm Tour mới" /> Add Tour
             </button>
              </a>
            <div class="select-tours">
                <table class="custom-table">
                    <tr>
                       <%
                       ArrayList<Tour> tourArray = (ArrayList<Tour>) request.getAttribute("tourArray");
                       				if (tourArray != null) {
                       					for (int i=0; i<tourArray.size(); i++) {
                       %>
                              <td> 
                                <div class="cell-content">
                                    <img style="width: 200px; height: 200px; object-fit:" src="./images/<%= tourArray.get(i).getImage() %>" alt="img">
                                    <div class="content-tour">
                                       <a href="detailTourServlet?tourId=<%= tourArray.get(i).getDetail_id() %>" style="text-decoration: none; font-family: arial;"> <span class="name-tour"><%= tourArray.get(i).getLocation() %></span><br></a>
                                        <ul class="detail-tour">
                                            <a ><li><span class="icon" >✅</span><span class="text">Mô tả: <%= tourArray.get(i).getDescription() %></span></li></a>
                                            <li><span class="icon">✅</span><span class="text">Hiệu lực: <%= tourArray.get(i).getNumber_day() %></span></li>
                                             <li><span class="text" style="color:red; font-family: Arial; font-size: 18px;">Giá vé: <%= tourArray.get(i).getPrice() %>/Người</span></li>
                                             
                                              </ul>
                                    </div>
								   <div style="display: flex;">
								  <a href="updateServlet?id=<%=tourArray.get(i).getDetail_id() %>" style="text-decoration: none;">
								    <button class="update-tour">
								      Update
								    </button>
								  </a>
								  <a href="deleteServlet?id=<%=tourArray.get(i).getDetail_id() %>" style="text-decoration: none;">
								    <button class="delete-tour">
								      Delete
								    </button>
								  </a>
								</div>
                                </div>
                            </td>
                    <% 
                            }
                        } else {
                    %>
                            <td><h1>No tours available</h1></td>
                    <% 
                        }
                    %>
                            
                      
                    </tr>
                </table>
            </div>
        </section>
    </header>
     
    <script src="./View/JS/script.js"></script>
</body>
</html>