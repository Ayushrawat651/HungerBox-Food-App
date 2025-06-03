package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Cart;
import com.bean.Menu;
import com.dao.ProductDao;

@WebServlet("/controller/quantity-inc-dec")
public class QuantityIncDecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		if (request.getSession().getAttribute("auth") != null) {
			try (PrintWriter out = response.getWriter()) {
				String action = request.getParameter("action");
				int id = Integer.parseInt(request.getParameter("id"));
				ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");

				if (action != null && id >= 1) {
					if (action.equals("inc")) {
						for (Cart c : cart_list) {
							if (c.getDishId() == id) {
								int quantity = c.getQuantity();
								quantity++;
								c.setQuantity(quantity);
								response.sendRedirect("/HungerBox/cart.jsp");
							}
						}
					}

					if (action.equals("dec")) {
						for (Cart c : cart_list) {
							if (c.getDishId() == id && c.getQuantity() > 1) {
								int quantity = c.getQuantity();
								quantity--;
								c.setQuantity(quantity);
								break;
							}
						}
						response.sendRedirect("/HungerBox/cart.jsp");
					}
				} else {
					response.sendRedirect("/HungerBox/cart.jsp");
				}
			}
		} else {
			response.sendRedirect("/HungerBox/login.jsp");
		}
	}

}