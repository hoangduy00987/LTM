package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.BO.checkLoginBO;

@WebServlet("/checkLogin")
public class checkLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public checkLogin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destination = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
        
		checkLoginBO checkLoginBO = new checkLoginBO();
		String Iduser = checkLoginBO.getIDUser(username, password, "Client");
		getServletContext().setAttribute("idUser", Iduser);
		 if (checkLoginBO.isValidUser(username, password, "Client")) {
			destination = "/HomePage.jsp";
		} else {
			destination = "/Login.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
