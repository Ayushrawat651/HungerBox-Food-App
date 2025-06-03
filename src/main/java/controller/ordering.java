package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Menu;
import com.dao.GetMenuItems;

@WebServlet("/controller/ordering")
public class ordering extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("auth") != null) {
			System.out.println("Ordering initiated");
			RequestDispatcher rd = request.getRequestDispatcher("/ordering.jsp");
			
			String type = request.getParameter("switch");

			ArrayList<Menu> menu_arr = new GetMenuItems().getMenuItems(type);
			
			if (menu_arr != null) {
				Menu[] menu = menu_arr.toArray(new Menu[0]);

				//System.out.println(menu[0].getDishName());

//                String selectdOption = request.getParameter("option");
				if (type == null || type.equals("all")) {
					System.out.println("filter option -- all");
					request.getSession().setAttribute("selectdOption", "all");
				} else {
					System.out.println("filter option -- veg/non-veg");
					request.getSession().setAttribute("selectdOption", type);
				}

				request.getSession().setAttribute("menu", menu);
				rd.include(request, response);
			}
			else {
				request.getSession().setAttribute("menu", null);
				rd.include(request, response);
			}
		} else {
			response.sendRedirect("/HungerBox/login.jsp");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}