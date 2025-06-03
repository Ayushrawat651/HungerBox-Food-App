package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Cart;
import com.bean.Menu;

@WebServlet("/controller/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		if (request.getSession().getAttribute("auth") != null) {

			try (PrintWriter out = response.getWriter()) {
//            out.print("add to cart servlet");

				ArrayList<Cart> cartList = new ArrayList<>();
				int id = Integer.parseInt(request.getParameter("id"));
				String name = (String) request.getParameter("name");
				int price = Integer.parseInt(request.getParameter("price"));
				Cart cm = new Cart();
				cm.setDishId(id);
				cm.setDishName(name);
				cm.setPrice(price);
				cm.setQuantity(1);
				HttpSession session = request.getSession();
				ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
				if (cart_list == null) {
					cartList.add(cm);
					session.setAttribute("cart-list", cartList);
					response.sendRedirect("/HungerBox/ordering.jsp");
				} else {
					cartList = cart_list;

					boolean exist = false;
					for (Cart c : cart_list) {
						if (c.getDishId() == id) {
							exist = true;
							out.println(
									"<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='/HungerBox/cart.jsp'>GO to Cart Page</a></h3>");
						}
					}

					if (!exist) {
						cartList.add(cm);
						response.sendRedirect("/HungerBox/ordering.jsp");
					}
				}
			}
		} else {
			response.sendRedirect("/HungerBox/login.jsp");
		}
	}

}
