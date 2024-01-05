package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BEAN.Bill;
import Model.BO.functionBO;

/**
 * Servlet implementation class getBill
 */
@WebServlet("/getBill")
public class getBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getBill() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
        int id = Integer.parseInt(request.getParameter("booking"));

        request.setAttribute("id", id);
        Bill bill = new Bill();
        functionBO func = new functionBO();
        bill = func.getBill(id);

        request.setAttribute("bill", bill);

        request.getRequestDispatcher("ShowBill.jsp").forward(request, response);
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
