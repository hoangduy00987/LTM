package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BEAN.Booking;
import Model.BEAN.Tour;
import Model.BO.functionBO;


@WebServlet("/getAllBookingServlet")
public class getAllBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public getAllBookingServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Booking> booking = null;
        functionBO func = new functionBO();
        booking = func.getAllBookingBO(); 
        request.setAttribute("booking", booking);
        request.getRequestDispatcher("viewListTour_admin.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
