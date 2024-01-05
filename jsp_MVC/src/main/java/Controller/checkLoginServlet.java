package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BEAN.Wife;
import Model.BO.checkLoginBO;

@WebServlet("/checkLoginServlet")
public class checkLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public checkLoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		checkLoginBO checkLoginBO = new checkLoginBO();
		ArrayList<Wife> wifeArray = null;
		
		if(checkLoginBO.isValidUser(username, password)) {
			wifeArray = checkLoginBO.getWifeList(username);
			request.setAttribute("wifeArray", wifeArray);
			destination = "/convertForm.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}else {
			destination = "/Login.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
			
		}
		
		
	}

}
