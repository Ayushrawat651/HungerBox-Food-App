package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DeleteCustomerById;

@WebServlet("/controller/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("auth") != null) {
			int id = Integer.parseInt(request.getParameter("Admin-customer-id"));
			boolean status = new DeleteCustomerById().deleteCustomer(id);
			if (status) {
				response.sendRedirect("/HungerBox/controller/adminDashboard");
			} else {
				System.out.println("something went wrong!!!!");
				response.sendRedirect("/HungerBox/controller/adminDashboard");
			}
		} else {
			response.sendRedirect("/HungerBox/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
