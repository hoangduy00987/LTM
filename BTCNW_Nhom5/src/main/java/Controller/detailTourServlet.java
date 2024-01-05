package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BEAN.Comment;
import Model.BEAN.Tour;
import Model.BEAN.User;
import Model.BO.functionBO;
@WebServlet("/detailTourServlet")
public class detailTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public detailTourServlet() {
        super();
    }
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(true);
        functionBO cmt = new functionBO();
        String username = (String) session.getAttribute("username");

        User user = null;
        user = cmt.getFull_name(username);

        String tourIdParam = request.getParameter("tourId");
        int tour_id = Integer.parseInt(tourIdParam);

        ArrayList<Comment> list = cmt.getAllComment_of_tour(tour_id);
        request.setAttribute("commentArray", list);
        request.setAttribute("full_name", user);

        functionBO fun = new functionBO();
        Tour tour = fun.getTourById(tour_id);
        request.setAttribute("tour_detail", tour);
        
        session.setAttribute("tourId", tour_id);

        request.getRequestDispatcher("detailTour.jsp").forward(request, response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(true);
  
        functionBO cmt = new functionBO();
        String username = (String) session.getAttribute("username");
        
        int id = (int) session.getAttribute("tourId");
        int user_id = cmt.getIDUserByUsername(username);
        String content = request.getParameter("content");
        cmt.SendComment(id, user_id, content);
        response.sendRedirect(request.getHeader("Referer"));
    }

}
