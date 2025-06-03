package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;
import com.dao.GetAllCustomers;
import com.dao.GetHistory;
import com.dao.GetMenuItems;

@WebServlet("/controller/adminDashboard")
public class adminDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("auth") != null) {
			request.getSession().setAttribute("Admin-menu", new GetMenuItems().getMenuItems(null));
			request.getSession().setAttribute("Admin-customers", new GetAllCustomers().getAllCustomers());
			request.getSession().setAttribute("Admin-history", new GetHistory().getHistory());
			System.out.println(request.getSession().getAttribute("Admin-menu"));
			response.sendRedirect("/HungerBox/adminDashboard.jsp");
		}
		else {
    		response.sendRedirect("/HungerBox/login.jsp");
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
