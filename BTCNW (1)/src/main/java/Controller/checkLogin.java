package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BEAN.Tour;
import Model.BO.checkLoginBO;
import Model.BO.functionBO;


@WebServlet("/checkLogin")
public class checkLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public checkLogin() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String destination = null;
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    HttpSession session= request.getSession(true);
	    checkLoginBO checkLoginBO = new checkLoginBO();
	    ArrayList<Tour> tourArray = null;
        functionBO func = new functionBO();
        tourArray = func.getAllTour(); 
        request.setAttribute("tourArray", tourArray);
	    if (checkLoginBO.isValidUser(username, password, "admin")) {
	    	session.setAttribute("username", username);
	        destination = "/home_admin.jsp";
	    } else if (checkLoginBO.isValidUser(username, password, "Client")) {
	        destination = "/home.jsp";
	    } else {
	        destination = "/Login.jsp";
	    }

	    RequestDispatcher rd = request.getRequestDispatcher(destination);
	    rd.forward(request, response);
	}
}
