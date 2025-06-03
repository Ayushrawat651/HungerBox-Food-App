package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Menu;
import com.dao.AddMenuItem;
import com.dao.RemoveMenuItem;

@WebServlet("/controller/RemoveDish")
public class RemoveDish extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("auth") != null) {
			String dishName = request.getParameter("remove-item-name");

			boolean check = new RemoveMenuItem().removeMenuItem(dishName);

			if (check) {
				response.sendRedirect("/HungerBox/controller/adminDashboard");
			} else {
				System.out.println("something went wrong!!!!");
				response.sendRedirect("/HungerBox/controller/adminDashboard");
			}
		} 
		else {
			response.sendRedirect("/HungerBox/login.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
