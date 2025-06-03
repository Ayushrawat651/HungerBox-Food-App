package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Cart;
import com.bean.Customer;
import com.bean.Orders;
import com.dao.ConfirmOrder;

@WebServlet("/controller/cart-check-out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("auth") != null) {
			try {
				ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
				String auth = (String) request.getSession().getAttribute("auth");
				if (cart_list != null && auth != null) {
					ArrayList<Orders> ordersList = new ArrayList<>();
						Orders order = new Orders();
						HashMap<String,Integer> dishes = new HashMap<>();
						for (Cart c : cart_list) {
							dishes.put(c.getDishName(), c.getQuantity());
						}
						order.setDishes(dishes);
						order.setCustomerId(((Customer) request.getSession().getAttribute("user")).getCustomerId());
						order.setStatus(0);

						ConfirmOrder co = new ConfirmOrder();
						boolean result = co.confirmOrder(order);
						if (!result) {
							//error page
//							break;
						}
						ordersList.add(order);
					System.out.println( request.getSession().getAttribute("cart-list"));
					cart_list.clear();
					System.out.println( request.getSession().getAttribute("cart-list"));
					response.sendRedirect("/HungerBox/ordering.jsp");
				} else {
					if (auth == null) {
						response.sendRedirect("/HungerBox/login.jsp");
					}
					response.sendRedirect("/HungerBox/cart.jsp");
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		} 
		else {
			response.sendRedirect("/HungerBox/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}