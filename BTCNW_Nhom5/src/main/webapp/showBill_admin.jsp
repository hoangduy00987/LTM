<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="Model.BEAN.Bill"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hóa Đơn Thanh Toán Tour</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
            border-radius: 4px;
        }

        h2 {
            color: #333;
            font-size: 24px;
            margin-bottom: 20px;
            text-align: center;
        }

        .tour-card {
            border: 1px solid #ccc;
            padding: 20px;
            margin-bottom: 20px;
            background-color: #f9f9f9;
            border-radius: 4px;
        }

        .tour-details {
            margin-bottom: 10px;
        }

        .detail-description {
            margin-bottom: 5px;
            color: #333;
        }

        .price {
            font-size: 24px;
            color: #ff4d4d;
            text-align: right;
            margin-top: 20px;
            font-weight: bold;
        }

        .no-tours {
            text-align: center;
        }

        .no-tours h1 {
            margin-top: 0;
        }

  
  .button-pay {
      
        display: inline-block;
        padding: 10px 20px ;
        background-color: #4caf50;
        color: #fff;
        text-align: center;
        text-decoration: none;
        border-radius: 4px;
        transition: background-color 0.3s;
        font-size: 16px;
        border: none;
        cursor: pointer;
    }

    .button-pay:hover {
        background-color: #45a049;
    }
      

        @media print {
            .no-print {
                display: none;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="select-tours">
            <div class="custom-table">
                <% 
                    Bill bill = (Bill) request.getAttribute("bill");
                    if (bill != null) {
                %>
                <h2>Hóa Đơn Thanh Toán Tour <%=bill.getLocation() %></h2>
                <div class="tour-card">
                    <div class="tour-details">
                        <div class="detail-description">Tên Khách Hàng: <%=bill.getUserName() %></div>
                        <div class="detail-description">Số điện thoại: <%=bill.getPhoneNumber() %></div>
                        <div class="detail-description">Địa chỉ: <%=bill.getAddress()%></div>
                        <div class="detail-description">Số lượng vé: <%=bill.getNumParticipants()%></div>
                    </div>
                    <div class="price">Tổng Tiền: <%= bill.getBill() %></div>
                </div>
                <h2>Vui Lòng Thanh Toán Bằng Tiền Mặt</h2>
                <a href="cancel_admin?booking=<%=request.getAttribute("id")%>" style="padding-left: 250px;"> <button class  = "button-pay">Đã Thanh Toán</button></a>
                <% 
                    } else {
                %>
                <div class="no-tours">
                    <h1>No tours available</h1>
                </div>
                <% 
                    }
                %>
            </div>
        </div>
    </div>
</body>
</html>