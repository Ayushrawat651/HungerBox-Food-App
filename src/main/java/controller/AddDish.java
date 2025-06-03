package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Menu;
import com.dao.AddMenuItem;

@WebServlet("/controller/AddDish")
public class AddDish extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("auth") != null) {
			String dishName = request.getParameter("item-name");
			String dishDescription = request.getParameter("dish-Description");
			boolean veg = false;
			if((request.getParameter("type")).equalsIgnoreCase("TRUE")) {
				veg = true;
			}
			else {
				veg = false;
			}
			
			String imgUrl = request.getParameter("img-Url");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int price = Integer.parseInt(request.getParameter("item-price"));
			boolean status = true;

			/*
			 * System.out.println("----------------------------------------------");
			 * System.out.println(dishName); System.out.println(dishDescription);
			 * System.out.println(veg); System.out.println(imgUrl);
			 * System.out.println(price); System.out.println(quantity);
			 */
			System.out.println(request.getParameter("type"));
			boolean check = new AddMenuItem()
					.addMenuItem(new Menu(0, dishName, dishDescription, veg, imgUrl, price, quantity, status));

			if (check) {
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
