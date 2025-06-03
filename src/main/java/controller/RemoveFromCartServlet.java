package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Cart;

@WebServlet("/controller/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		if (request.getSession().getAttribute("auth") != null) {
			try (PrintWriter out = response.getWriter()) {
				String bookId = request.getParameter("id");
				if (bookId != null) {
					ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
					if (cart_list != null) {
						for (Cart c : cart_list) {
							if (c.getDishId() == Integer.parseInt(bookId)) {
								cart_list.remove(cart_list.indexOf(c));
								break;
							}
						}
					}
					response.sendRedirect("/HungerBox/cart.jsp");

				} else {
					response.sendRedirect("/HungerBox/cart.jsp");
				}

			}
		} else {
			response.sendRedirect("/HungerBox/login.jsp");
		}
	}

}